package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DietRecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.DietRecordDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord_;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.MultipartFileUploader;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.UploadResult;
import tw.edu.ntub.imd.birc.firstmvc.service.DietRecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.DietRecordTransformer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DietRecordServiceImpl extends BaseServiceImpl<DietRecordBean, DietRecord, Integer> implements DietRecordService {
    private final DietRecordDAO dietRecordDAO;
    private final DietRecordTransformer transformer;
    private final MultipartFileUploader uploader;

    public DietRecordServiceImpl(DietRecordDAO dietRecordDAO, DietRecordTransformer transformer, MultipartFileUploader uploader) {
        super(dietRecordDAO, transformer);
        this.dietRecordDAO = dietRecordDAO;
        this.transformer = transformer;
        this.uploader = uploader;
    }

    @Override
    public DietRecordBean save(DietRecordBean dietRecordBean, MultipartFile imageFile) {
        DietRecord dietRecord = transformer.transferToEntity(dietRecordBean);
        DietRecord saveResult = dietRecordDAO.saveAndFlush(dietRecord);
        if (imageFile != null) {
            UploadResult uploadResult = uploader.upload(imageFile, "imageFile");
            saveResult.setImageUrl(uploadResult.getUrl());
            dietRecordDAO.save(saveResult);
        }
        return transformer.transferToBean(dietRecord);
    }

    @Override
    public List<DietRecordBean> searchAll() {
        return CollectionUtils.map(dietRecordDAO.findAll(getSort()), transformer::transferToBean);
    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.desc(DietRecord_.MEAL_DATE)
        );
    }

    @Override
    public List<DietRecordBean> searchByMealDateRange(LocalDate startDate, LocalDate endDate) {
        return CollectionUtils.map(dietRecordDAO.searchByMealTimeRange(startDate, endDate), transformer::transferToBean);
    }

    @Override
    public List<DietRecordBean> searchByMealDate(LocalDate mealDate) {
        return CollectionUtils.map(dietRecordDAO.searchByMealDate(mealDate, getSort()), transformer::transferToBean);
    }

    @Override
    public DietRecordBean save(DietRecordBean dietRecordBean) {
        return null;
    }
}
