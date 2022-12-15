package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WaterRecordBean {
    public Integer id;
    public Integer waterVolume;
    public LocalDate waterTime;
    public String account;

}
