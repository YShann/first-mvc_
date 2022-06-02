package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Defecation;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Food;

import java.time.LocalDateTime;

@Repository
public interface DefecationDAO extends BaseDAO<Defecation, Integer> {

}
