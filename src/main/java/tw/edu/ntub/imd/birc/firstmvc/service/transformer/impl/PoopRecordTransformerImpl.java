package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.PoopRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.PoopRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.PoopRecordTransformer;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.WaterRecordTransformer;

@Component
public class PoopRecordTransformerImpl implements PoopRecordTransformer {
    @NonNull
    @Override
    public PoopRecord transferToEntity(@NonNull PoopRecordBean poopRecordBean) {
        return JavaBeanUtils.copy(poopRecordBean, new PoopRecord());
    }

    @NonNull
    @Override
    public PoopRecordBean transferToBean(@NonNull PoopRecord poopRecord) {
        return JavaBeanUtils.copy(poopRecord, new PoopRecordBean());
    }
}
