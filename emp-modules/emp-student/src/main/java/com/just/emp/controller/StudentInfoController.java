package com.just.emp.controller;

import com.just.emp.po.Result;
import com.just.emp.po.StudentInfo;
import com.just.emp.po.Userlogin;
import com.just.emp.service.StudentInfoService;
import com.just.emp.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * author ： 徐鑫祥
 */
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentInfoController {
    @Autowired
    private StudentInfoService studentInfoService;

    public String uid = null;

    //个人信息
    @RequestMapping("/studentinfo")
    public StudentInfo studentinfo(String uid){
        StudentInfo studentInfo = studentInfoService.selectInfo(uid);
        return studentInfo;
    }

    //账户管理页面跳转
    @RequestMapping("/management")
    public String touxHui(String type,Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("logininfo");
        StudentInfo studentInfo = studentInfoService.selectInfo(userlogin.getUid());
        model.addAttribute("user",studentInfo);
        uid = userlogin.getUid();
        if(type.equals("avatar")){
            return "student/avatarmodification";
        }else{
            return "student/updatepassword";
        }
    }

    //修改密码
    @RequestMapping("/savePsw")
    public Msg savePsw(String passwd, String npasswd, String recode, HttpServletRequest request) {
        String checkcode_right = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //1.2获取验证码参数值
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        if (recode == null || !recode.equalsIgnoreCase(checkcode_right)) {
            return Msg.success("验证码错误");
        } else {
            //查询旧密码
            HttpSession session = request.getSession();
            Userlogin userlogin = (Userlogin) session.getAttribute("logininfo");
            String npwd = studentInfoService.selectOldPwd(userlogin.getUid());
            if(!npwd.equals(passwd)){
                return Msg.success("旧密码不正确");
            }
            int i = studentInfoService.savePwd(userlogin.getUid(),npasswd);
            if(i > 0){
                return Msg.success("修改密码成功");
            }else {
                return Msg.fail("未知错误");
            }

        }
    }


    //修改个人信息
    @RequestMapping("/updatastuinfo")
    public Result UpdataStuInfo(StudentInfo studentInfo, String type){
        Result result = new Result();
        int i = studentInfoService.updateStudentInfo(studentInfo,type);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("编辑成功");
        }else {
            result.setStatus(false);
            result.setMsg("编辑失败！请稍后再试");
        }
        return result;
    }
}
