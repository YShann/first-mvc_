package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DietRecordDAO extends BaseDAO<DietRecord, Integer> {

    @Query("FROM DietRecord d where d.mealTime between :startDate and :endDate order by d.mealTime DESC ")
    List<DietRecord> searchByMealTime(@Param("startDate") LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);
}
