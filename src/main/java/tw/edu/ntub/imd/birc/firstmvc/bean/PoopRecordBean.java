package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PoopRecordBean {
    public Integer id;
    public Integer poopCount;
    public LocalDate poopTime;
}
