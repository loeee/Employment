package com.just.emp.service;

import com.just.emp.po.StudentInfo;
import com.just.emp.po.Userlogin;

/**
 * author ： 周鑫
 */
public interface AuthService {
    Userlogin login(Userlogin user);
    String selectpwd(String uid);
    int updatepwd(String pwd,String uid);
    int updateheadImg(String path,String uid);
    int updatesetpwd(String email,String pwd);
    int insertRegistStu(Userlogin userlogin, StudentInfo studentInfo);
}
