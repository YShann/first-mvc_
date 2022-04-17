package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
// 前端資料需要的格式，基本上會跟entity一樣，但是可以因為需求而增加變數
public class MemberBean {
    public String id;
    public String name;
    public String gender;
    public Boolean available;
    public LocalDateTime transactionTime;
}
