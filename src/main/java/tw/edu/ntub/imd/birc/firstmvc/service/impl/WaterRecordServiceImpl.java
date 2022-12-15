package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.WaterRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.WaterRecordDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord_;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.UploadResult;
import tw.edu.ntub.imd.birc.firstmvc.service.WaterRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.WaterRecordTransformer;

import java.time.LocalDate;
import java.util.List;

@Service
public class WaterRecordServiceImpl extends BaseServiceImpl<WaterRecordBean, WaterRecord, Integer> implements WaterRecordService {
    private final WaterRecordDAO waterRecordDAO;
    private final WaterRecordTransformer transformer;

    public WaterRecordServiceImpl(WaterRecordDAO waterRecordDAO, WaterRecordTransformer transformer) {
        super(waterRecordDAO, transformer);
        this.waterRecordDAO = waterRecordDAO;
        this.transformer = transformer;
    }

    @Override
    public WaterRecordBean save(WaterRecordBean waterRecordBean) {
        WaterRecord waterRecord = transformer.transferToEntity(waterRecordBean);
        WaterRecord saveResult = waterRecordDAO.saveAndFlush(waterRecord);
        return transformer.transferToBean(saveResult);
    }

    @Override
    public List<WaterRecordBean> searchByWaterTimeRange(LocalDate startDate, LocalDate endDate,String account) {
        return CollectionUtils.map(waterRecordDAO.searchByWaterTimeRange(startDate, endDate, account), transformer::transferToBean);

    }

    @Override
    public List<WaterRecordBean> searchByWaterTime(LocalDate waterTime,String account) {
        return CollectionUtils.map(waterRecordDAO.searchByWaterTime(waterTime, account), transformer::transferToBean);
    }

    @Override
    public List<WaterRecordBean> searchAll() {
        return CollectionUtils.map(waterRecordDAO.findAll(getSort()), transformer::transferToBean);
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.asc(WaterRecord_.WATER_TIME)
        );
    }

}
