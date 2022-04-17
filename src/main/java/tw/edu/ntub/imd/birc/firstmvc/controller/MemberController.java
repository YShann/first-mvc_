package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.ScoreBean;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.service.ScoreService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.Optional;

/*
題目:
1. 查詢全部學生
2. 查PK，學生
3. 條件查詢(某個科目成績不及格的學生名單)
4. 新增成績
5. 修改成績
6. 刪除成績
 */

/*
1. 需有lombok
2. 環境變數log.path
3. 複製application-server.yml改名為application-local.yml，增加資料庫相關資料
4. 如果不知道怎麼下手，可以先把相關的檔案建完再照著順序走

建檔順序: entity => bean => DAO => service => controller
撰寫順序: Controller => Service => DAO(習慣反過來寫)
*/

// 建立所有參數的建構元
@AllArgsConstructor
// 告訴spring這是一個controller
@RestController
// 定義url，url以/student開頭的都會進到這裡
@RequestMapping(path = "/student")
// 建構controller會用到要使用的service

public class MemberController {
    private final MemberService memberService;
    private final ScoreService scoreService;

    // 查詢使用get，url為/student的會進入這裡
    @GetMapping(path = "")
    // 回傳多筆用search、單筆get(看團隊習慣)
    public ResponseEntity<String> searchStudent() {
        ArrayData arrayData = new ArrayData();
        // baseService有的searchAll方法
        for (MemberBean memberBean : memberService.searchAll()) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", memberBean.getId());
            objectData.add("name", memberBean.getName());
            // 三元運算子
            objectData.add("gender", memberBean.getGender().equals("0") ? "男" : "女");
        }
        // 鏈式，做完一個function後回傳自己，繼續執行下個方法
        // 必有 message, result
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @PostMapping(path="")
    public ResponseEntity<String> createStudent(@Valid @RequestBody MemberBean memberBean,
                                                BindingResult bindingResult){
        BindingResultUtils.validate(bindingResult);
        memberService.save(memberBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path="")
    public ResponseEntity<String> createStudent(@RequestBody MemberBean memberBean){
        memberService.update(memberBean.getId(), memberBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        memberService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    // url如果一樣，但是參數不一樣可以這樣寫，增加進入條件
    // params: url參數(因為遇到url一樣才要寫，平常寫@RequestPram就可以了)
    @GetMapping(path = "", params = {"id"})
    // @RequestParam，/url&id=XXX，&後面為請求參數，id=name
    public ResponseEntity<String> getStudent(@RequestParam(name = "id") String id) {
        ObjectData objectData = new ObjectData();
        // Optional，避免null造成程式壞掉，所以會先用optional包裝，最後要用的時候再檢查
        // getById正常應該也要覆寫，但是這裡為了展示就不覆寫
        Optional<MemberBean> memberBeanOptional = memberService.getById(id);
        /*
            1. isPresent()
            2. orElseThrow() (throw new RuntimeException())
         */
        memberBeanOptional.orElseThrow(() -> new RuntimeException("查無此學生，請確認學號是否正確"));
        MemberBean memberBean = memberBeanOptional.get();
        objectData.add("id", memberBean.getId());
        objectData.add("name", memberBean.getName());
        objectData.add("gender", memberBean.getGender().equals("0") ? "男" : "女");
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    @GetMapping(path = "/failed")
    public ResponseEntity<String> searchFailedStudent(@RequestParam(name = "subject") String subject) {
        ArrayData arrayData = new ArrayData();
        for (ScoreBean scoreBean : scoreService.searchFailedStudentBySubject(subject)) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("studentId", scoreBean.studentId);
            objectData.add("studentName", scoreBean.getStudentName());
            objectData.add("score", scoreBean.getScore());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @PostMapping(path = "/score")
    /*
        @RequestBody = 調整取資料的位置(像是get在url上)，get以外的方法預設為formData(檔案上傳會用)
            只可以使用一個參數接，要用json的格式(基本資料型態不行)
        @Valid，驗證傳入參數，必傳BindingResult bindingResult
     */
    public ResponseEntity<String> createScore(@Valid @RequestBody ScoreBean scoreBean,
                                              BindingResult bindingResult) {
        //表單驗證一定要寫
        BindingResultUtils.validate(bindingResult);
        scoreService.save(scoreBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    //不同的請求方式可以使用同個url
    @PatchMapping(path = "/score")
    public ResponseEntity<String> updateScore(@RequestBody ScoreBean scoreBean) {
        scoreService.update(scoreBean.getId(), scoreBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    //url動態帶編號(不是&參數)
    @DeleteMapping(path = "/score/{id}")
    public ResponseEntity<String> deleteScore(@PathVariable Integer id) {
        /*
            有兩種寫法，如果資料表中有啟用不啟用時，刪除通常指的是調整成不啟用
            第二種是直接刪除，這裡用這種
         */
        scoreService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

}