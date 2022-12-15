package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Defecation;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DietRecordLicense {

    @PrePersist
    public void preSave(DietRecord dietRecord) {
        if (dietRecord.getImageUrl() == null) {
            dietRecord.setImageUrl("https://i.imgur.com/cqzFOY2.png");
        }
    }

    @PreUpdate
    public void preUpdate(DietRecord dietRecord) {

    }
}
