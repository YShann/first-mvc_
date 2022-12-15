package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class DietRecordBean {
    public Integer id;
    public String foodName;
    public Integer portionSize;
    public LocalDate mealDate;
    public LocalTime mealTime;
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
    private String imageUrl;
    private MultipartFile imageFile;
    public String foodContent;
    public String account;
}
