package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.DefecationBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.DefecationDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Defecation;
import tw.edu.ntub.imd.birc.firstmvc.service.DefecationService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.DefecationTransformer;
import java.util.List;

@Service
public class DefecationServiceImpl extends BaseServiceImpl<DefecationBean, Defecation, Integer> implements DefecationService {
    private final DefecationDAO defecationDAO;
    private final DefecationTransformer transformer;

    public DefecationServiceImpl(DefecationDAO defecationDAO, DefecationTransformer transformer) {
        super(defecationDAO, transformer);
        this.defecationDAO = defecationDAO;
        this.transformer = transformer;
    }

    @Override
    public DefecationBean save(DefecationBean defecationBean) {
        Defecation saveResult = defecationDAO.saveAndFlush(transformer.transferToEntity(defecationBean));
        return transformer.transferToBean(saveResult);
    }

    @Override
    public List<DefecationBean> searchAll() {
        return CollectionUtils.map(defecationDAO.findAll(), transformer::transferToBean);
    }
}
