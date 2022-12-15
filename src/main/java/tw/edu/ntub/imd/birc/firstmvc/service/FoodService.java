package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;

import java.time.LocalDate;
import java.util.List;

public interface FoodService extends BaseService<FoodBean, Integer> {

    List<FoodBean> getByName(String name);

}
