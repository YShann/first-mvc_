package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.license;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Classroom;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ClassroomLicense {

    @PrePersist
    public void preSave(Classroom classroom) {

    }

    @PreUpdate
    public void preUpdate(Classroom classroom) {

    }
}
