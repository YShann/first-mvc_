package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.service.FoodService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/food")

public class FoodController {
    private final FoodService foodService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchFood() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(foodService.searchAll(),this::addFoodToObjectData)
                .build();
    }

    @PostMapping(path="")
    public ResponseEntity<String> createFood(@Valid @RequestBody FoodBean foodBean,
                                                BindingResult bindingResult){
        BindingResultUtils.validate(bindingResult);
        foodService.save(foodBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path="")
    public ResponseEntity<String> updateFood(@RequestBody FoodBean foodBean){
        foodService.update(foodBean.getId(), foodBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path="")
    public ResponseEntity<String> deleteFood(@RequestParam(name = "id") Integer id) {
        foodService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"name"})
    public ResponseEntity<String> getFood(@RequestParam(name = "name") String name) {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(foodService.getByName(name), this::addFoodToObjectData)
                .build();
    }


    private void addFoodToObjectData(ObjectData objectData, FoodBean foodBean) {
        objectData.add("name", foodBean.getName());
        objectData.add("label", foodBean.getLabel());
        objectData.add("energy", foodBean.getEnergy());
        objectData.add("fat", foodBean.getFat());
        objectData.add("saturatedFat", foodBean.getSaturatedFat());
        objectData.add("carbohydrate", foodBean.getCarbohydrate());
        objectData.add("protein", foodBean.getProtein());
        objectData.add("label", foodBean.getLabel());
        objectData.add("grains", foodBean.getGrains());
        objectData.add("vegetables", foodBean.getVegetables());
        objectData.add("meatsAndProtein", foodBean.getMeatsAndProtein());
        objectData.add("milkAndDairy", foodBean.getMilkAndDairy());
        objectData.add("fruits", foodBean.getFruits());
        objectData.add("fats", foodBean.getFats());
    }

}