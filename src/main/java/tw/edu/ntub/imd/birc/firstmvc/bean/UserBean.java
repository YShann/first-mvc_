package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

@Data
public class UserBean {
    public String name;
    public String gender;
    public Integer height;
    public Integer weight;
    public Double bmi;
}
