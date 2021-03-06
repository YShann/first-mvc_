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
     * 流水號
     *
     * @Since 1.0.1
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    /**
     * 食物名稱
     *
     * @Since 1.0.1
     */
    @Column(name = "food_name", length = 45, nullable = false)
    public String foodName;

    /**
     * 份量(0:少量/1:適中/2:飽食/3:過量)
     *
     * @Since 1.0.1
     */
    @Column(name = "portion_size", length = 3, nullable = false)
    public String portionSize;

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
    /**
     * 食物熱量(以大卡為單位)
     *
     * @Since 1.0.1
     */
    @Column(name = "energy", nullable = false)
    public Integer energy;

    /**
     * 脂肪
     *
     * @Since 1.0.1
     */
    @Column(name = "fat",precision=11, scale=3, nullable = false)
    public Double fat;

    /**
     * 飽和脂肪
     *
     * @Since 1.0.1
     */
    @Column(name = "saturated_fat",precision=11, scale=3, nullable = false)
    public Double saturatedFat;

    /**
     * 碳水化合物
     *
     * @Since 1.0.1
     */
    @Column(name = "carbohydrate",precision=11, scale=3, nullable = false)
    public Double carbohydrate;

    /**
     * 蛋白質
     *
     * @Since 1.0.1
     */
    @Column(name = "protein",precision=11, scale=3, nullable = false)
    public Double protein;

    /**
     * 是否為全榖雜糧類(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "grains", length = 1, nullable = false)
    public String grains;

    /**
     * 是否為蔬菜類(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "vegetables", length = 1, nullable = false)
    public String vegetables;

    /**
     * 是否為蛋豆魚肉類(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "meats_protein", length = 1, nullable = false)
    public String meatsAndProtein;

    /**
     * 是否為乳品類(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "milk_dairy", length = 1, nullable = false)
    public String milkAndDairy;

    /**
     * 是否為水果類(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "fruits", length = 1, nullable = false)
    public String fruits;

    /**
     * 是否為油脂與堅果種子類(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "fats", length = 1, nullable = false)
    public String fats;

    /**
     * 圖片
     *
     * @Since 1.0.1
     */
    @Column(name = "image", length = 500, nullable = false)
    public String imageUrl;
}
