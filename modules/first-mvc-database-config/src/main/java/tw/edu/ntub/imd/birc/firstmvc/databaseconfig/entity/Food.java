package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "food", schema = Config.DATABASE_NAME)
public class Food {
    /**
     * 食物名稱
     *
     * @Since 1.0.1
     */
    @Id
    @Column(name = "name", length = 45, nullable = false)
    public String name;

    /**
     * 食物標籤
     *
     * @Since 1.0.1
     */
    @Column(name = "label", length = 45)
    public String label;

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
}
