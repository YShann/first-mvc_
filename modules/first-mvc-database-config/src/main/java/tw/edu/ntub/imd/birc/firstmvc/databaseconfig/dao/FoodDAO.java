package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Food;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FoodDAO extends BaseDAO<Food, Integer> {
    @Query("FROM Food f where f.name = :name")
    List<Food> getByName(@Param("name") String name);

}
