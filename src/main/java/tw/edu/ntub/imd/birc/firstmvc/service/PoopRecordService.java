package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.PoopRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;

import java.time.LocalDate;
import java.util.List;

public interface PoopRecordService extends BaseService<PoopRecordBean, Integer> {

    PoopRecordBean save(PoopRecordBean poopRecordBean);

    List<PoopRecordBean> searchByPoopTimeRange(LocalDate startDate, LocalDate endDate);

    List<PoopRecordBean> searchByPoopTime(LocalDate poopTime);

}
