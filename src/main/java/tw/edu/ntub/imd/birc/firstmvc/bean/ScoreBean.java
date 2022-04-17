package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
//entity資料是類別不可放進來
public class ScoreBean {
    @Null(message = "id - 不得填寫")
    public Integer id;

    @NotBlank(message = "學號 - 未填寫")
    @Size(max = 10, message = "學號 - 輸入字數大於{max}個字")
    public String studentId;

    @NotBlank(message = "科目 - 未填寫")
    @Size(max = 20, message = "科目 輸入字數大於{max}個字")
    public String subject;

    @NotNull(message = "成績 - 未填寫")
    @Max(100)
    @Min(0)
    public Integer score;

    @Null(message = "最後修改時間 - 不得填寫")
    public LocalDateTime transactionTime;
    
    public String studentName;
}
