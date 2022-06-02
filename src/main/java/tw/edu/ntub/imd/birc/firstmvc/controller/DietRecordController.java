package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.service.DietRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.FoodService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/dietRecord")

public class DietRecordController {
    private final DietRecordService dietRecordService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchDietRecord() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(dietRecordService.searchAll(),this::addDietRecordToObjectData)
                .build();
    }

    @PostMapping(path="")
    public ResponseEntity<String> createDietRecord(@Valid @RequestBody DietRecordBean dietRecordBean,
                                                BindingResult bindingResult){
        BindingResultUtils.validate(bindingResult);
        dietRecordService.save(dietRecordBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path="")
    public ResponseEntity<String> updateDietRecord(@RequestBody DietRecordBean dietRecordBean){
        dietRecordService.update(dietRecordBean.getFoodName(), dietRecordBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path="")
    public ResponseEntity<String> deleteDietRecord(@RequestParam(name = "foodName") String foodName) {
        dietRecordService.delete(foodName);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"foodName"})
    public ResponseEntity<String> getDietRecord(@RequestParam(name = "foodName") String foodName) {
        ObjectData objectData = new ObjectData();
        Optional<DietRecordBean> dietRecordBeanOptional = dietRecordService.getById(foodName);
        dietRecordBeanOptional.orElseThrow(() -> new RuntimeException("查無此紀錄，請確認名字是否正確"));
        DietRecordBean dietRecordBean = dietRecordBeanOptional.get();
        addDietRecordToObjectData(objectData,dietRecordBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    private void addDietRecordToObjectData(ObjectData objectData, DietRecordBean dietRecordBean) {
        objectData.add("foodName", dietRecordBean.getFoodName());
        objectData.add("portionSize", dietRecordBean.getPortionSize());
        objectData.add("mealTime", dietRecordBean.getMealTime());
        objectData.add("note", dietRecordBean.getNote());
    }

}