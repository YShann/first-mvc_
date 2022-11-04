package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.PoopRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.service.PoopRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.WaterRecordService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/poopRecord")

public class PoopRecordController {
    private final PoopRecordService poopRecordService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchPoopRecord() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(poopRecordService.searchAll(), this::addPoopRecordToObjectData)
                .build();
    }

    @PostMapping(path = "")
    public ResponseEntity<String> createPoopRecord(@Valid PoopRecordBean waterRecordBean,
                                                   BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        poopRecordService.save(waterRecordBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path = "")
    public ResponseEntity<String> updatePoopRecord(PoopRecordBean poopRecordBean) {
        poopRecordService.update(poopRecordBean.getId(), poopRecordBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path = "")
    public ResponseEntity<String> deletePoopRecord(@RequestParam(name = "id") Integer id) {
        poopRecordService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @GetMapping(path = "", params = {"id"})
    public ResponseEntity<String> getPoopRecord(@RequestParam(name = "id") Integer id) {
        ObjectData objectData = new ObjectData();
        Optional<PoopRecordBean> poopRecordBeanOptional = poopRecordService.getById(id);
        poopRecordBeanOptional.orElseThrow(() -> new RuntimeException("查無此紀錄，請確認名字是否正確"));
        PoopRecordBean poopRecordBean = poopRecordBeanOptional.get();
        addPoopRecordToObjectData(objectData, poopRecordBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }

    @GetMapping(path = "", params = {"startDate", "endDate"})
    public ResponseEntity<String> getPoopRecordRange(
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate) {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(poopRecordService.searchByPoopTimeRange(startDate,endDate), this::addPoopRecordToObjectData)
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

    private void addPoopRecordToObjectData(ObjectData objectData, PoopRecordBean poopRecordBean) {
        objectData.add("id", poopRecordBean.getId());
        objectData.add("poopCount", poopRecordBean.getPoopCount());
        objectData.add("poopTime", poopRecordBean.getPoopTime());
    }

}