package com.just.emp.service.Impl;

import com.just.emp.mapper.UserloginMapper;
import com.just.emp.po.StudentInfo;
import com.just.emp.po.Userlogin;
import com.just.emp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * author ： 周鑫
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserloginMapper userloginMapper;

    //判断用户是否存在
    public Userlogin login(Userlogin user) {
        return userloginMapper.login(user);
    }

    @Override
    public String selectpwd(String uid) {
        return userloginMapper.selectpwd(uid);
    }

    @Override
    public int updatepwd(String pwd, String uid) {
        return userloginMapper.updatepwd(pwd,uid);
    }

    @Override
    public int updateheadImg(String path, String uid) {
        return userloginMapper.updateheadImg(path,uid);
    }

    @Override
    public int updatesetpwd(String email, String pwd) {
        return userloginMapper.updatesetpwd(email,pwd);
    }


    @Override
    public int insertRegistStu(Userlogin userlogin, StudentInfo studentInfo) {
        int i = userloginMapper.insertStuInfo(studentInfo);
        int j = userloginMapper.insert_tab(userlogin);
        if(i > 0 && j > 0){
            return 1;
        }else {
            return 0;
        }
    }
}
