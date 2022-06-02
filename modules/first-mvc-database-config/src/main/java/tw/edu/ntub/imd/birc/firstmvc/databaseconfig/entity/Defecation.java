package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license.DefecationLicense;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(DefecationLicense.class)
@Table(name = "defecation", schema = Config.DATABASE_NAME)
public class Defecation {
    /**
     * 流水號
     *
     * @Since 1.0.1
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    /**
     * 排便時間
     *
     * @Since 1.0.1
     */
    @Column(name = "defecation_time", nullable = false)
    public LocalDateTime defecationTime;

    /**
     * 詳細說明
     *
     * @Since 1.0.1
     */
    @Column(name = "detail",length = 100,nullable = false)
    public String detail;
}
