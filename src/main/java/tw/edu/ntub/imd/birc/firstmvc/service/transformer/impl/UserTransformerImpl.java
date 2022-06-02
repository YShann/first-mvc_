package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.UserBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.User;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.UserTransformer;

@Component
public class UserTransformerImpl implements UserTransformer {
    @NonNull
    @Override
    public User transferToEntity(@NonNull UserBean userBean) {
        return JavaBeanUtils.copy(userBean, new User());
    }

    @NonNull
    @Override
    public UserBean transferToBean(@NonNull User user) {
        return JavaBeanUtils.copy(user, new UserBean());
    }
}
