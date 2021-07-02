package com.just.emp.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * author ： 周鑫
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userlogin {
    private String uid;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String name;//真实姓名
    private String type;
    private String toux;
    private String email;
    private TeacherInfo teacherInfo;
}