package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DietRecordBean {
    public String foodName;
    public Integer portionSize;
    public LocalDateTime mealTime;
    public String note;
}
