package tw.edu.ntub.imd.birc.firstmvc.service;

import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;

import java.time.LocalDate;
import java.util.List;

public interface DietRecordService extends BaseService<DietRecordBean, Integer> {

    DietRecordBean save(DietRecordBean dietRecordBean, MultipartFile imageFile);

    List<DietRecordBean> searchByMealDateRange(LocalDate startDate, LocalDate endDate,String account);

    List<DietRecordBean> searchByMealDate(LocalDate mealDate,String account);

}
