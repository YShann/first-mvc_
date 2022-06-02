package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user", schema = Config.DATABASE_NAME)
public class User {
    /**
     * 使用者姓名
     *
     * @Since 1.0.1
     */
    @Id
    @Column(name = "name", length = 45, nullable = false)
    public String name;

    /**
     * 性別(0:男生/1:女生)
     *
     * @Since 1.0.1
     */
    @Column(name = "gender", length = 1, nullable = false)
    public String gender;

    /**
     * 身高
     *
     * @Since 1.0.1
     */
    @Column(name = "height", nullable = false)
    public Integer height;

    /**
     * 體重
     *
     * @Since 1.0.1
     */
    @Column(name = "weight", nullable = false)
    public Integer weight;

    /**
     * bmi
     *
     * @Since 1.0.1
     */
    @Column(name = "bmi",precision=11, scale=2, nullable = false)
    public Double bmi;
}
