package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DietRecordDAO extends BaseDAO<DietRecord, Integer> {
    //    between :startDate and :endDate
//    @Query("FROM DietRecord d where d.mealTime >= :startDate AND d.mealTime <= :endDate order by d.mealTime DESC ")
    @Query("FROM DietRecord d where d.mealDate between :startDate and :endDate order by d.mealDate DESC ")
    List<DietRecord> searchByMealTimeRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("FROM DietRecord d where d.mealDate = :mealDate order by d.mealDate DESC ")
    List<DietRecord> searchByMealDate(@Param("mealDate") LocalDate mealDate, Sort sort);
}
