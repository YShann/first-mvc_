package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DietRecordService extends BaseService<DietRecordBean, Integer> {

    List<DietRecordBean> searchByMealTime(LocalDateTime startDate, LocalDateTime endDate);

}
