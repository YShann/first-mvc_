package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefecationBean {
    public Integer id;
    public LocalDateTime defecationTime;
    public String detail;
}
