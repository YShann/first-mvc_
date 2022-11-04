package tw.edu.ntub.imd.birc.firstmvc.service;

import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DietRecordService extends BaseService<DietRecordBean, Integer> {

    DietRecordBean save(DietRecordBean dietRecordBean, MultipartFile imageFile);

    List<DietRecordBean> searchByMealTimeRange(LocalDateTime startDate, LocalDateTime endDate);

    List<DietRecordBean> searchByMealTime(LocalDateTime mealTime);

}
