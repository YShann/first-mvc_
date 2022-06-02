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
     * 食物分類
     *
     * @Since 1.0.1
     */
    @Column(name = "type", length = 45, nullable = false)
    public String type;

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
     * 食物標籤
     *
     * @Since 1.0.1
     */
    @Column(name = "label", length = 45)
    public String label;
}
