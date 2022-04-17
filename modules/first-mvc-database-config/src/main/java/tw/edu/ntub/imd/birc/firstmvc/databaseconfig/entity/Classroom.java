package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license.ClassroomLicense;

import javax.persistence.*;
import java.time.LocalDateTime;

// 長出getter跟setter，和其他必備的東西，要有lombok
@Data
// 告訴spring這是一個entity
@Entity
// 有些欄位有預設值，或是不可為null，所以在新增、更新時檢查
@EntityListeners(ClassroomLicense.class)
// 對應資料表的名稱
@Table(name = "classroom", schema = Config.DATABASE_NAME)
// 從資料庫取出的資料格式為entity
public class Classroom {
    /**
     * 學生編號
     *
     * @Since 1.0.1
     */
    // PK
    @Id
    // 對應欄位資料
    @Column(name = "id", length = 10, nullable = false)
    public String id;

    /**
     * 教室名字
     *
     * @Since 1.0.1
     */
    @Column(name = "name", length = 45, nullable = false)
    public String name;


}