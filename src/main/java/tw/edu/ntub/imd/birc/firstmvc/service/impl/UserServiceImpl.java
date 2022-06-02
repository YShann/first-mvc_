package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.UserBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.UserDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.User;
import tw.edu.ntub.imd.birc.firstmvc.service.UserService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.UserTransformer;

import java.util.List;

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
        User saveResult = userDAO.saveAndFlush(transformer.transferToEntity(userBean));
        return transformer.transferToBean(saveResult);
    }

    @Override
    public List<UserBean> searchAll() {
        return CollectionUtils.map(userDAO.findAll(), transformer::transferToBean);
    }
}
