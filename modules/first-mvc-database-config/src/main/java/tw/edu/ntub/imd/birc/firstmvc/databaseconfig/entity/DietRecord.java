package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license.DietRecordLicense;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(DietRecordLicense.class)
@Table(name = "diet_record", schema = Config.DATABASE_NAME)
public class DietRecord {
    /**
     * 食物名稱
     *
     * @Since 1.0.1
     */
    @Id
    @Column(name = "food_name", length = 45, nullable = false)
    public String foodName;

    /**
     * 份量
     *
     * @Since 1.0.1
     */
    @Column(name = "portion_size",nullable = false)
    public Integer portionSize;

    /**
     * 進食時間
     *
     * @Since 1.0.1
     */
    @Column(name = "meal_time", nullable = false)
    public LocalDateTime mealTime;

    /**
     * 備註
     *
     * @Since 1.0.1
     */
    @Column(name = "note", length = 500, nullable = false)
    public String note;
}
