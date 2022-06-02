package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Defecation;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class DietRecordLicense {

    @PrePersist
    public void preSave(DietRecord dietRecord) {
        if (dietRecord.getMealTime() == null) {
            dietRecord.setMealTime(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(DietRecord dietRecord) {
        dietRecord.setMealTime(LocalDateTime.now());
    }
}
