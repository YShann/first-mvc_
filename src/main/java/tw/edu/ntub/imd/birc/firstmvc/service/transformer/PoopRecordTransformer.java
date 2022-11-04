package tw.edu.ntub.imd.birc.firstmvc.service.transformer;

import tw.edu.ntub.imd.birc.firstmvc.bean.PoopRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.PoopRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;

public interface PoopRecordTransformer extends BeanEntityTransformer<PoopRecordBean, PoopRecord> {
}
