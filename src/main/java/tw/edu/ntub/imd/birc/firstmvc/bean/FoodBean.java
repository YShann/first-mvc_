package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FoodBean {
    public String name;
    public String type;
    public Integer energy;
    public Double fat;
    public Double saturatedFat;
    public Double carbohydrate;
    public Double protein;
    public String label;
}
