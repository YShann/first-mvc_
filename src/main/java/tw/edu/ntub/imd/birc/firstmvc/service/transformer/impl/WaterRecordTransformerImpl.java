package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.DietRecordTransformer;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.WaterRecordTransformer;

@Component
public class WaterRecordTransformerImpl implements WaterRecordTransformer {
    @NonNull
    @Override
    public WaterRecord transferToEntity(@NonNull WaterRecordBean waterRecordBean) {
        return JavaBeanUtils.copy(waterRecordBean, new WaterRecord());
    }

    @NonNull
    @Override
    public WaterRecordBean transferToBean(@NonNull WaterRecord waterRecord) {
        return JavaBeanUtils.copy(waterRecord, new WaterRecordBean());
    }
}
