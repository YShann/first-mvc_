package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license.ScoreLicense;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 分數
 *
 * @Since 1.0.1
 */
@Data
@Entity
@EntityListeners(ScoreLicense.class)
@Table(name = "score", schema = Config.DATABASE_NAME)
public class Score {
    /**
     * 流水號
     *
     * @Since 1.0.1
     */
    @Id
    // 自動增值(AI)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    /**
     * 學生編號
     *
     * @Since 1.0.1
     */
    @Column(name = "student_id", length = 10, nullable = false)
    public String studentId;

    /**
     * 科目
     *
     * @Since 1.0.1
     */
    @Column(name = "subject", length = 20, nullable = false)
    public String subject;

    /**
     * 分數
     *
     * @Since 1.0.1
     */
    @Column(name = "score", nullable = false)
    public Integer score;

    /**
     * 最後修改時間
     *
     * @Since 1.0.1
     */
    @Column(name = "transaction_time", nullable = false)
    public LocalDateTime transactionTime;

    /**
     * 學生
     *
     * @Since 1.0.1
     * @see Member
     */
    // 有關聯的話要寫
    @EqualsAndHashCode.Exclude
    // 多對一，多對多不建立，LAZY=有使用到才查詢(有get這個類別)
    @ManyToOne(fetch = FetchType.LAZY)
    // 關聯欄位資料
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Member memberByStudentId;
}
