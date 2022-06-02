package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.DietRecordDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.service.DietRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.DietRecordTransformer;

import java.util.List;

@Service
public class DietRecordServiceImpl extends BaseServiceImpl<DietRecordBean, DietRecord, String> implements DietRecordService {
    private final DietRecordDAO dietRecordDAO;
    private final DietRecordTransformer transformer;

    public DietRecordServiceImpl(DietRecordDAO dietRecordDAO, DietRecordTransformer transformer) {
        super(dietRecordDAO, transformer);
        this.dietRecordDAO = dietRecordDAO;;
        this.transformer = transformer;
    }

    @Override
    public DietRecordBean save(DietRecordBean dietRecordBean) {
        DietRecord saveResult = dietRecordDAO.saveAndFlush(transformer.transferToEntity(dietRecordBean));
        return transformer.transferToBean(saveResult);
    }

    @Override
    public List<DietRecordBean> searchAll() {
        return CollectionUtils.map(dietRecordDAO.findAll(), transformer::transferToBean);
    }
}
