package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.UserBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.UserDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.User;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.UploadResult;
import tw.edu.ntub.imd.birc.firstmvc.service.UserService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.UserTransformer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserBean, User, String> implements UserService {
    private final UserDAO userDAO;
    private final UserTransformer transformer;

    public UserServiceImpl(UserDAO userDAO, UserTransformer transformer) {
        super(userDAO, transformer);
        this.userDAO = userDAO;
        this.transformer = transformer;
    }

    @Override
    public UserBean save(UserBean userBean) {
        User user = transformer.transferToEntity(userBean);
        User saveResult = userDAO.saveAndFlush(user);
        String md5Password = DigestUtils.md5DigestAsHex(userBean.password.getBytes());
        saveResult.setPassword(md5Password);
        userDAO.save(saveResult);
        return transformer.transferToBean(user);
    }

    @Override
    public void update(String account, UserBean userBean) {
        Optional<User> optional = userDAO.findById(account);
        User user = optional.get();
        if (userBean.name != null) {
            user.setName(userBean.name);
        }
        if (userBean.gender != null) {
            user.setGender(userBean.gender);
        }
        if (userBean.height != null) {
            user.setHeight(userBean.height);
        }
        if (userBean.weight != null) {
            user.setWeight(userBean.weight);
        }
        if (userBean.birthday != null) {
            user.setBirthday(userBean.birthday);
        }

        user.setIsEmailLogin(userBean.isEmailLogin);
        if (userBean.getIsEmailLogin() == "0") {
            user.setPassword(DigestUtils.md5DigestAsHex(userBean.password.getBytes()));
        }
        userDAO.update(user);
    }

    @Override
    public List<UserBean> getByAccount(String account) {
        return CollectionUtils.map(userDAO.getByAccount(account), transformer::transferToBean);
    }

    @Override
    public List<UserBean> login(String account, String password) {
        List<UserBean> beanList = CollectionUtils.map(userDAO.getByAccount(account), transformer::transferToBean);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (beanList.size() <= 0) {
            beanList = CollectionUtils.map(userDAO.getByAccount("nAccount"), transformer::transferToBean);
        } else if (!beanList.get(0).password.equals(md5Password)) {
            beanList = CollectionUtils.map(userDAO.getByAccount("eAccount"), transformer::transferToBean);
        }
        return beanList;
    }

    @Override
    public List<UserBean> searchAll() {
        return CollectionUtils.map(userDAO.findAll(), transformer::transferToBean);
    }
}
