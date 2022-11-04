package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.service.DietRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.FoodService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
                .data(dietRecordService.searchAll(), this::addDietRecordToObjectData)
                .build();
    }

    @PostMapping(path = "")
    public ResponseEntity<String> createDietRecord(@Valid DietRecordBean dietRecordBean, MultipartFile imageFile,
                                                   BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        dietRecordService.save(dietRecordBean,imageFile);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path = "")
    public ResponseEntity<String> updateDietRecord(DietRecordBean dietRecordBean) {
        dietRecordService.update(dietRecordBean.getId(), dietRecordBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path = "")
    public ResponseEntity<String> deleteDietRecord(@RequestParam(name = "id") Integer id) {
        dietRecordService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"id"})
    public ResponseEntity<String> getDietRecord(@RequestParam(name = "id") Integer id) {
        ObjectData objectData = new ObjectData();
        Optional<DietRecordBean> dietRecordBeanOptional = dietRecordService.getById(id);
        dietRecordBeanOptional.orElseThrow(() -> new RuntimeException("查無此紀錄，請確認名字是否正確"));
        DietRecordBean dietRecordBean = dietRecordBeanOptional.get();
        addDietRecordToObjectData(objectData, dietRecordBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    @GetMapping(path = "", params = {"startDate", "endDate"})
    public ResponseEntity<String> getDietRecordRange(
            @RequestParam(name = "startDate") LocalDateTime startDate,
            @RequestParam(name = "endDate") LocalDateTime endDate) {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(dietRecordService.searchByMealTimeRange(startDate,endDate), this::addDietRecordToObjectData)
                .build();
    }

    @GetMapping(path = "", params = {"mealTime"})
    public ResponseEntity<String> getDietRecord(
            @RequestParam(name = "mealTime") LocalDateTime mealTime) {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(dietRecordService.searchByMealTime(mealTime), this::addDietRecordToObjectData)
                .build();
    }

    private void addDietRecordToObjectData(ObjectData objectData, DietRecordBean dietRecordBean) {
        objectData.add("id", dietRecordBean.getId());
        objectData.add("foodName", dietRecordBean.getFoodName());
        objectData.add("portionSize", dietRecordBean.getPortionSize());
        objectData.add("mealTime", dietRecordBean.getMealTime());
        objectData.add("note", dietRecordBean.getNote());
        objectData.add("energy", dietRecordBean.getEnergy());
        objectData.add("fat", dietRecordBean.getFat());
        objectData.add("saturatedFat", dietRecordBean.getSaturatedFat());
        objectData.add("carbohydrate", dietRecordBean.getCarbohydrate());
        objectData.add("protein", dietRecordBean.getProtein());
        objectData.add("grains", dietRecordBean.getGrains());
        objectData.add("vegetables", dietRecordBean.getVegetables());
        objectData.add("meatsAndProtein", dietRecordBean.getMeatsAndProtein());
        objectData.add("milkAndDairy", dietRecordBean.getMilkAndDairy());
        objectData.add("fruits", dietRecordBean.getFruits());
        objectData.add("fats", dietRecordBean.getFats());
        objectData.add("imageUrl", dietRecordBean.getImageUrl());
    }

}