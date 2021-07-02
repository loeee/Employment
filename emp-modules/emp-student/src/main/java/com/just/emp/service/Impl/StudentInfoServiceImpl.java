package com.just.emp.service.Impl;

import com.just.emp.mapper.StudentInfoMapper;
import com.just.emp.po.StudentInfo;
import com.just.emp.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public StudentInfo selectInfo(String uid){
        return studentInfoMapper.selectInfo(uid);
    }
    public int saveInfo(StudentInfo studentInfo) {
        return studentInfoMapper.saveInfo(studentInfo);
    }
    public String selectOldPwd(String uid){
        return studentInfoMapper.selectOldPwd(uid);
    }
    public int savePwd(String uid, String newPwd) {
        return studentInfoMapper.savePwd(uid,newPwd);
    }
    public int inserttouximg(String imgpath,String uid) {
        return studentInfoMapper.inserttouximg(imgpath,uid);
    }

    public int insertStudentInfo(StudentInfo studentInfo) {
        return studentInfoMapper.insertStudentInfo(studentInfo);
    }
    public int updateStudentInfo(StudentInfo studentInfo,String type){
        int i = 0;
        if(type != null && type.equals("stuinfo")){
            //修改个人信息
            i = studentInfoMapper.updataStuinfo(studentInfo);
        }else if(type != null && type.equals("lxfsinfo")){
            i = studentInfoMapper.updateTelInfo(studentInfo);
        }else if(type != null && type.equals("gzjlinfo")){
            i = studentInfoMapper.updategzjlinfo(studentInfo);
        }else if(type != null && type.equals("grjninfo")){
            i = studentInfoMapper.updateskillinfo(studentInfo);
        }else if(type != null && type.equals("evainfo")){
            i = studentInfoMapper.updateevainfo(studentInfo);
        }else if(type != null && type.equals("eduinfo")){
            i = studentInfoMapper.updateeduinfo(studentInfo);
        }
        return i;
    }


}
