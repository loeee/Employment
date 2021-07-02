package com.just.emp.mapper;

import com.just.emp.po.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentInfoMapper {
    StudentInfo selectInfo(String uid);
    int saveInfo(StudentInfo studentInfo);
    String selectOldPwd(String uid);
    int savePwd(@Param("uid") String uid, @Param("newPwd") String newPwd);
    int inserttouximg(@Param("imgpath")String imgpath,@Param("uid")String uid);
    int insertStudentInfo(StudentInfo studentInfo);
    int updateStudentInfo(StudentInfo studentInfo);
    int updataStuinfo(StudentInfo studentInfo);
    int updateTelInfo(StudentInfo studentInfo);
    int updategzjlinfo(StudentInfo studentInfo);
    int updateskillinfo(StudentInfo studentInfo);
    int updateevainfo(StudentInfo studentInfo);
    int updateeduinfo(StudentInfo studentInfo);

}
