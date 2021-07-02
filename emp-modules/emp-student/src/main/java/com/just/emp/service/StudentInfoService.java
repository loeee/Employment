package com.just.emp.service;

import com.just.emp.po.StudentInfo;

public interface StudentInfoService {
    StudentInfo selectInfo(String uid);
    int saveInfo(StudentInfo studentInfo);
    String selectOldPwd(String uid);
    int savePwd(String uid, String newPwd);
    int inserttouximg(String imgpath,String uid);
    int insertStudentInfo(StudentInfo studentInfo);
    int updateStudentInfo(StudentInfo studentInfo,String type);

}
