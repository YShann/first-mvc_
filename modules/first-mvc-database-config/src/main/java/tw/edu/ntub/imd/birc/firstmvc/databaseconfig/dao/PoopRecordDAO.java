package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.PoopRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PoopRecordDAO extends BaseDAO<PoopRecord, Integer> {
//    between :startDate and :endDate
    @Query("FROM PoopRecord p where p.account =:account AND p.poopTime >= :startDate AND p.poopTime <= :endDate order by p.poopTime DESC ")
    List<PoopRecord> searchByPoopTimeRange(@Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate, @Param("account")String account);

    @Query("FROM PoopRecord d where d.poopTime = :poopTime AND d.account=:account order by d.poopTime DESC ")
    List<PoopRecord> searchByPoopTime(@Param("poopTime") LocalDate poopTime, @Param("account")String account);
}
