package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class DietRecordBean {
    public Integer id;
    public String foodName;
    public String portionSize;
    public LocalDateTime mealTime;
    public String note;
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
    private String url;
    private MultipartFile imageFile;
}
