package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserBean {
    public String account;
    public String password;
    public String name;
    public String gender;
    public Double height;
    public Double weight;
    public Double bmi;
    public String email;
    public String isEmailLogin;
    public LocalDate birthday;
}
