package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user", schema = Config.DATABASE_NAME)
public class User {
    /**
     * 使用者帳號
     *
     * @Since 1.0.1
     */
    @Id
    @Column(name = "account", length = 45, nullable = false)
    public String account;
    /**
     * 使用者姓名
     *
     * @Since 1.0.1
     */
    @Column(name = "password", length = 45, nullable = false)
    public String password;
    /**
     * 使用者姓名
     *
     * @Since 1.0.1
     */
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
    @Column(name = "height",precision=11, scale=2, nullable = false)
    public Double height;

    /**
     * 體重
     *
     * @Since 1.0.1
     */
    @Column(name = "weight",precision=11, scale=2, nullable = false)
    public Double weight;

    /**
     * bmi
     *
     * @Since 1.0.1
     */
    @Column(name = "bmi",precision=11, scale=2, nullable = false)
    public Double bmi;
    /**
     * 使用者信箱
     *
     * @Since 1.0.1
     */
    @Column(name = "email", length = 45, nullable = false)
    public String email;
    /**
     * 生日
     *
     * @Since 1.0.1
     */
    @Column(name = "birthday", nullable = false)
    public LocalDate birthday;
    /**
     * 是否透過google登入(0:否/1:是)
     *
     * @Since 1.0.1
     */
    @Column(name = "email_login", length = 1, nullable = false)
    public String isEmailLogin;
}
