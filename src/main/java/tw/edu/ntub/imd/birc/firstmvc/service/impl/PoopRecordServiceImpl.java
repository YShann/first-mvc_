package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.PoopRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.PoopRecordDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.WaterRecordDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.PoopRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.PoopRecord_;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord_;
import tw.edu.ntub.imd.birc.firstmvc.service.PoopRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.WaterRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.PoopRecordTransformer;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.WaterRecordTransformer;

import java.time.LocalDate;
import java.util.List;

@Service
public class PoopRecordServiceImpl extends BaseServiceImpl<PoopRecordBean, PoopRecord, Integer> implements PoopRecordService {
    private final PoopRecordDAO poopRecordDAO;
    private final PoopRecordTransformer transformer;

    public PoopRecordServiceImpl(PoopRecordDAO poopRecordDAO, PoopRecordTransformer transformer) {
        super(poopRecordDAO, transformer);
        this.poopRecordDAO = poopRecordDAO;
        this.transformer = transformer;
    }

    @Override
    public PoopRecordBean save(PoopRecordBean poopRecordBean) {
        PoopRecord poopRecord = transformer.transferToEntity(poopRecordBean);
        PoopRecord saveResult = poopRecordDAO.saveAndFlush(poopRecord);
        return transformer.transferToBean(saveResult);
    }

    @Override
    public List<PoopRecordBean> searchByPoopTimeRange(LocalDate startDate, LocalDate endDate) {
        return CollectionUtils.map(poopRecordDAO.searchByPoopTimeRange(startDate, endDate), transformer::transferToBean);

    }

    @Override
    public List<PoopRecordBean> searchAll() {
        return CollectionUtils.map(poopRecordDAO.findAll(getSort()), transformer::transferToBean);
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.asc(PoopRecord_.POOP_TIME)
        );
    }

//    @Override
//    public DietRecordBean save(WaterRecordBean waterRecordBean) {
//        return null;
//    }
}
