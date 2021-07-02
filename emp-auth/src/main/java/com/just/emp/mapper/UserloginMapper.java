package com.just.emp.mapper;

import com.just.emp.po.StudentInfo;
import com.just.emp.po.Userlogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * author ： 周鑫
 */

@Mapper
public interface UserloginMapper {
    Userlogin login(Userlogin user);
    String selectpwd(String uid);
    int updatepwd(@Param("pwd") String pwd, @Param("uid")String uid);
    int updateheadImg(@Param("path") String path, @Param("uid")String uid);
    int updatesetpwd(@Param("email") String email, @Param("pwd")String pwd);
    int insert_tab(Userlogin userlogin);
    int insertStuInfo(StudentInfo studentInfo);
}