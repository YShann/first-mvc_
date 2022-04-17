package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
//entity資料是類別不可放進來
public class ClassroomBean {
    public String id;
    public String name;
}
