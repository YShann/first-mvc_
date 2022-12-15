package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.User;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserDAO extends BaseDAO<User, String> {

    @Query("FROM User d where d.account = :account")
    List<User> getByAccount(@Param("account") String account);
}
