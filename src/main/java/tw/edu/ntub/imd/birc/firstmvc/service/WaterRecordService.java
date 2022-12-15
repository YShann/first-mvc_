package tw.edu.ntub.imd.birc.firstmvc.service;

import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.service.BaseService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface WaterRecordService extends BaseService<WaterRecordBean, Integer> {

    WaterRecordBean save(WaterRecordBean waterRecordBean);

    List<WaterRecordBean> searchByWaterTimeRange(LocalDate startDate, LocalDate endDate);

    List<WaterRecordBean> searchByWaterTime(LocalDate waterTime);

}
