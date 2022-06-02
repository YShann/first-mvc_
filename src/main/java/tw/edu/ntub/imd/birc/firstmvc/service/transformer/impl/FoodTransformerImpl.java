package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.FoodBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Food;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.FoodTransformer;

@Component
public class FoodTransformerImpl implements FoodTransformer {
    @NonNull
    @Override
    public Food transferToEntity(@NonNull FoodBean foodBean) {
        return JavaBeanUtils.copy(foodBean, new Food());
    }

    @NonNull
    @Override
    public FoodBean transferToBean(@NonNull Food food) {
        return JavaBeanUtils.copy(food, new FoodBean());
    }
}
