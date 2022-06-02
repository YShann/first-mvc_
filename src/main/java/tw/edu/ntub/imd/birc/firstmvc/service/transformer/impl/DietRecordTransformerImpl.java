package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.DietRecordTransformer;

@Component
public class DietRecordTransformerImpl implements DietRecordTransformer {
    @NonNull
    @Override
    public DietRecord transferToEntity(@NonNull DietRecordBean dietRecordBean) {
        return JavaBeanUtils.copy(dietRecordBean, new DietRecord());
    }

    @NonNull
    @Override
    public DietRecordBean transferToBean(@NonNull DietRecord dietRecord) {
        return JavaBeanUtils.copy(dietRecord, new DietRecordBean());
    }
}
