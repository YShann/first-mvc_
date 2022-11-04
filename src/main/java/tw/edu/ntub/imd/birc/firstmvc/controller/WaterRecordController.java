package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.service.WaterRecordService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/waterRecord")

public class WaterRecordController {
    private final WaterRecordService waterRecordService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchWaterRecord() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(waterRecordService.searchAll(), this::addWaterRecordToObjectData)
                .build();
    }

    @PostMapping(path = "")
    public ResponseEntity<String> createWaterRecord(@Valid WaterRecordBean waterRecordBean,
                                                   BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        waterRecordService.save(waterRecordBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path = "")
    public ResponseEntity<String> updateWaterRecord(WaterRecordBean waterRecordBean) {
        waterRecordService.update(waterRecordBean.getId(), waterRecordBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path = "")
    public ResponseEntity<String> deleteWaterRecord(@RequestParam(name = "id") Integer id) {
        waterRecordService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"id"})
    public ResponseEntity<String> getWaterRecord(@RequestParam(name = "id") Integer id) {
        ObjectData objectData = new ObjectData();
        Optional<WaterRecordBean> waterRecordBeanOptional = waterRecordService.getById(id);
        waterRecordBeanOptional.orElseThrow(() -> new RuntimeException("查無此紀錄，請確認名字是否正確"));
        WaterRecordBean waterRecordBean = waterRecordBeanOptional.get();
        addWaterRecordToObjectData(objectData, waterRecordBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    @GetMapping(path = "", params = {"startDate", "endDate"})
    public ResponseEntity<String> getWaterRecordRange(
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate) {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(waterRecordService.searchByWaterTimeRange(startDate,endDate), this::addWaterRecordToObjectData)
                .build();
    }

//    @GetMapping(path = "", params = {"mealTime"})
//    public ResponseEntity<String> getWaterRecord(
//            @RequestParam(name = "mealTime") LocalDate mealTime) {
//        return ResponseEntityBuilder.success()
//                .message("查詢成功")
//                .data(waterRecordService.searchByWaterTimeRange(mealTime), this::addWaterRecordToObjectData)
//                .build();
//    }

    private void addWaterRecordToObjectData(ObjectData objectData, WaterRecordBean waterRecordBean) {
        objectData.add("id", waterRecordBean.getId());
        objectData.add("waterVolume", waterRecordBean.getWaterVolume());
        objectData.add("waterTime", waterRecordBean.getWaterTime());
    }

}