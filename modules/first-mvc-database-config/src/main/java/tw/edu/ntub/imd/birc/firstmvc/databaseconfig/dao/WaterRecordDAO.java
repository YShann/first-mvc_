package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WaterRecordDAO extends BaseDAO<WaterRecord, Integer> {
//    between :startDate and :endDate
    @Query("FROM WaterRecord w where w.waterTime >= :startDate AND w.waterTime < :endDate order by w.waterTime DESC ")
    List<WaterRecord> searchByWaterTimeRange(@Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate);

//    @Query("FROM DietRecord d where DATE(d.mealTime) between :startDate and :endDate order by d.mealTime DESC ")
//    List<DietRecord> searchByMealTime(@Param("mealTime") LocalDateTime mealTime, Sort sort);
}
