package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.firstmvc.bean.ClassroomBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.ClassroomDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Classroom;
import tw.edu.ntub.imd.birc.firstmvc.service.ClassroomService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.ClassroomTransformer;

@Service
public class ClassroomServiceImpl extends BaseServiceImpl<ClassroomBean, Classroom, String> implements ClassroomService {
    private final ClassroomDAO classroomDAO;
    private final ClassroomTransformer transformer;

    public ClassroomServiceImpl(ClassroomDAO classroomDAO, ClassroomTransformer transformer) {
        super(classroomDAO, transformer);
        this.classroomDAO = classroomDAO;
        this.transformer = transformer;
    }

    @Override
    public ClassroomBean save(ClassroomBean classroomBean) {
        Classroom classroom = classroomDAO.save(transformer.transferToEntity(classroomBean));
        return transformer.transferToBean(classroom);
    }


}
