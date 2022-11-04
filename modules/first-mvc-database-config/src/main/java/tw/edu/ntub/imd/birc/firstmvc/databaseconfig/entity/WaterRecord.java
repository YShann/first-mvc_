package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license.WaterRecordLicense;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(WaterRecordLicense.class)
@Table(name = "water_record", schema = Config.DATABASE_NAME)
public class WaterRecord {
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
     *
     *
     * @Since 1.0.1
     */
    @Column(name = "water_volume", nullable = false)
    public Integer waterVolume;

    /**
     * 進食時間
     *
     * @Since 1.0.1
     */
    @Column(name = "water_time", nullable = false)
    public LocalDate waterTime;


}
