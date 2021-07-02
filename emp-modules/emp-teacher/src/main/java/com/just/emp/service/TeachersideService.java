package com.just.emp.service;

import com.just.emp.po.*;

import java.util.List;
import java.util.Map;

public interface TeachersideService {
    TeacherInfo selectInfo(String uid);
    int updateInfo(String type,String chang,String uid);
    //查询班级已就业信息
    List<EchartsMagor> selectClass(String cla);

    //查询专业已就业信息
    List<EchartsMagor> selectEmpInfo(String major);
    //查询学生信息
    public Map<String,Object> selectClassStuInfo(String _currenpag, String _rows, String cla, String sex, String gc);
    //查询学生信息 --专业
    public Map<String,Object> selectMagorStuInfo(String _currenpag, String _rows, String major,String sex, String gc);
    int updatetouximg(String imgpath, String uid);
    int updatePwd(String uid, String newPwd);
    Employment SelectEpmStuInfo(String uid);
}
