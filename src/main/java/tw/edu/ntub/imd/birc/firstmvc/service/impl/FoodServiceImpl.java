package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.FoodDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Food;
import tw.edu.ntub.imd.birc.firstmvc.service.FoodService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.FoodTransformer;
import java.util.List;

@Service
public class FoodServiceImpl extends BaseServiceImpl<FoodBean, Food, String> implements FoodService {
    private final FoodDAO foodDAO;
    private final FoodTransformer transformer;

    public FoodServiceImpl(FoodDAO foodDAO, FoodTransformer transformer) {
        super(foodDAO, transformer);
        this.foodDAO = foodDAO;
        this.transformer = transformer;
    }

    @Override
    public FoodBean save(FoodBean foodBean) {
        Food saveResult = foodDAO.saveAndFlush(transformer.transferToEntity(foodBean));
        return transformer.transferToBean(saveResult);
    }

    @Override
    public List<FoodBean> searchAll() {
        return CollectionUtils.map(foodDAO.findAll(), transformer::transferToBean);
    }
}
