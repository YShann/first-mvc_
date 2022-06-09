package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FoodBean {
    public String name;
    public String label;
    public Integer energy;
    public Double fat;
    public Double saturatedFat;
    public Double carbohydrate;
    public Double protein;
    public String grains;
    public String vegetables;
    public String meatsAndProtein;
    public String milkAndDairy;
    public String fruits;
    public String fats;

}
