package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.ClassroomBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Classroom;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.ClassroomTransformer;

@Component
public class ClassroomTransformerImpl implements ClassroomTransformer {
    @NonNull
    @Override
    public Classroom transferToEntity(@NonNull ClassroomBean classroomBean) {
        return JavaBeanUtils.copy(classroomBean, new Classroom());
    }

    @NonNull
    @Override
    public ClassroomBean transferToBean(@NonNull Classroom classroom) {
        return JavaBeanUtils.copy(classroom, new ClassroomBean());
    }
}
