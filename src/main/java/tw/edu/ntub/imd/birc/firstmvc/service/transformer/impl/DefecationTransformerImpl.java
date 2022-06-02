package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DefecationBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Defecation;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.DefecationTransformer;

@Component
public class DefecationTransformerImpl implements DefecationTransformer {
    @NonNull
    @Override
    public Defecation transferToEntity(@NonNull DefecationBean defecationBean) {
        return JavaBeanUtils.copy(defecationBean, new Defecation());
    }

    @NonNull
    @Override
    public DefecationBean transferToBean(@NonNull Defecation defecation) {
        return JavaBeanUtils.copy(defecation, new DefecationBean());
    }
}
