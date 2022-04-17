package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.ClassroomBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.ScoreBean;
import tw.edu.ntub.imd.birc.firstmvc.service.ClassroomService;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.service.ScoreService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/classroom")

public class ClassroomController {
    private final ClassroomService classroomService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchClassroom() {
        ArrayData arrayData = new ArrayData();
        for (ClassroomBean classroomBean : classroomService.searchAll()) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", classroomBean.getId());
            objectData.add("name", classroomBean.getName());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "", params = {"id"})
    public ResponseEntity<String> getClassroom(@RequestParam(name = "id") String id) {
        ObjectData objectData = new ObjectData();
        Optional<ClassroomBean> classroomBeanOptional = classroomService.getById(id);
        classroomBeanOptional.orElseThrow(() -> new RuntimeException("查無此教室，請確認id是否正確"));
        ClassroomBean classroomBean = classroomBeanOptional.get();
        objectData.add("id", classroomBean.getId());
        objectData.add("name", classroomBean.getName());
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    @PostMapping(path="")
    public ResponseEntity<String> createClassroom(@Valid @RequestBody ClassroomBean classroomBean,
                                                BindingResult bindingResult){
        BindingResultUtils.validate(bindingResult);
        classroomService.save(classroomBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path="")
    public ResponseEntity<String> createStudent(@RequestBody ClassroomBean classroomBean){
        classroomService.update(classroomBean.getId(), classroomBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        classroomService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }


}