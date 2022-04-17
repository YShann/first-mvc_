package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.ScoreBean;

import java.util.List;

public interface ScoreService extends BaseService<ScoreBean, Integer> {
    List<ScoreBean> searchFailedStudentBySubject(String subject);
}
