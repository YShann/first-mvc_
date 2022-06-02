package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.DefecationBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.service.DefecationService;
import tw.edu.ntub.imd.birc.firstmvc.service.FoodService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/defecation")

public class DefecationController {
    private final DefecationService defecationService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchDefecation() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(defecationService.searchAll(),this::addDefecationToObjectData)
                .build();
    }

    @PostMapping(path="")
    public ResponseEntity<String> createDefecation(@Valid @RequestBody DefecationBean defecationBean,
                                                BindingResult bindingResult){
        BindingResultUtils.validate(bindingResult);
        defecationService.save(defecationBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path="")
    public ResponseEntity<String> updateDefecation(@RequestBody DefecationBean defecationBean){
        defecationService.update(defecationBean.getId(), defecationBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path="")
    public ResponseEntity<String> deleteDefecation(@RequestParam(name = "id") Integer id) {
        defecationService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"id"})
    public ResponseEntity<String> getDefecation(@RequestParam(name = "id") Integer id) {
        ObjectData objectData = new ObjectData();
        Optional<DefecationBean> defecationBeanOptional = defecationService.getById(id);
        defecationBeanOptional.orElseThrow(() -> new RuntimeException("查無此飲食，請確認名字是否正確"));
        DefecationBean defecationBean = defecationBeanOptional.get();
        addDefecationToObjectData(objectData,defecationBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    private void addDefecationToObjectData(ObjectData objectData, DefecationBean defecationBean) {
        objectData.add("id", defecationBean.getId());
        objectData.add("defecationTime", defecationBean.getDefecationTime());
        objectData.add("detail", defecationBean.getDetail());
    }

}