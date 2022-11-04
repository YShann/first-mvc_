package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.DietRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WaterRecordLicense {

    @PrePersist
    public void preSave(WaterRecord waterRecord) {
        if (waterRecord.getWaterTime() == null) {
            waterRecord.setWaterTime(LocalDate.now());
        }
    }

    @PreUpdate
    public void preUpdate(WaterRecord waterRecord) {
        waterRecord.setWaterTime(LocalDate.now());
    }
}
