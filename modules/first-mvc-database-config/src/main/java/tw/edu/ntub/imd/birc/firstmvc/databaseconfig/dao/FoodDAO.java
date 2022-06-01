package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Food;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;

import java.util.List;

@Repository
public interface FoodDAO extends BaseDAO<Food, String> {

}
