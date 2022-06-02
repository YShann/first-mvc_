package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Defecation;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class DefecationLicense {

    @PrePersist
    public void preSave(Defecation defecation) {
        if (defecation.getDefecationTime() == null) {
            defecation.setDefecationTime(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Defecation defecation) {
        defecation.setDefecationTime(LocalDateTime.now());
    }
}
