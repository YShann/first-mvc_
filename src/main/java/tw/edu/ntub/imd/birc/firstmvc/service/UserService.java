package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.UserBean;

import java.time.LocalDate;
import java.util.List;

public interface UserService extends BaseService<UserBean, String> {

    UserBean save(UserBean userBean);

    void update(String account,UserBean userBean);

    List<UserBean> login(String account,String password);

    List<UserBean> getByAccount(String account);
}
