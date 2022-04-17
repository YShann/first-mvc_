package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Score;

import java.util.List;

@Repository
public interface ScoreDAO extends BaseDAO<Score, Integer> {
    /*
        動態查詢，對順序，如果條件很多可以使用@Query處理(SQL語法)
        ex: @Query("FROM Score s WHERE s.subject = :subject and s.score < :score")
     */
    List<Score> findBySubjectAndScoreLessThan(@Param("subject") String subject, @Param("score") Integer score);
}
