package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.PoopRecord;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.WaterRecord;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class PoopRecordLicense {

    @PrePersist
    public void preSave(PoopRecord poopRecord) {

    }

    @PreUpdate
    public void preUpdate(PoopRecord poopRecord) {
    }
}
