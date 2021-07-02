package com.just.emp.controller;

import com.just.emp.po.Result;
import com.just.emp.po.StudentInfo;
import com.just.emp.po.Userlogin;
import com.just.emp.service.AuthService;
import com.just.emp.email.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author ： 周鑫
 */
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    SendMail sendMail = new SendMail();

    //登录表单处理
    @RequestMapping(value = "/loginconf")
    public Result login(Userlogin userlogin) throws Exception {
        Userlogin userlogin1 = authService.login(userlogin);
        Result result = new Result();
        if(userlogin1 != null){
            result.setUid(userlogin1.getUid());
            result.setName(userlogin1.getName());
            result.setToux(userlogin1.getToux());
            result.setStatus(true);
            result.setMsg("登录成功");
        }else {
            result.setStatus(false);
            result.setMsg("账号或密码错误");
        }
        return result;
    }
    //密码修改
    @RequestMapping(value = "/setpwd")
    @ResponseBody
    public Result SetPwd(String uid,String old,String npwd) throws Exception {
        Result result = new Result();
        //查询旧密码
        String pwd = authService.selectpwd(uid);
        if(pwd!=null && pwd.equals(old)){
            int i = authService.updatepwd(npwd,uid);
            if(i > 0) {
                result.setStatus(true);
                result.setMsg("密码修改成功，请妥善保管");
            }else{
                result.setStatus(false);
                result.setMsg("密码修改失败，请稍后尝试");
            }
        }else {
            result.setStatus(false);
            result.setMsg("旧密码不正确！请重新输入");
        }
        return result;
    }

    //发送验证吗
    @RequestMapping("sendcode")
    public void sendCode(String mail,String code,String title){
        sendMail.sendfMailCode(mail,code,title);
    }
    //找回密码
    @RequestMapping("/seachpwd")
    @ResponseBody
    public Result SeachPwd(String email,String pwd){
        Result result = new Result();
        int i = authService.updatesetpwd(email,pwd);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("密码找回成功，请妥善保管");
        }else{
            result.setStatus(false);
            result.setMsg("密码找回失败，请稍后尝试");
        }
        return result;
    }
    //账号退出
    @RequestMapping("/registstu")
    @ResponseBody
    public Result RegistStu(Userlogin user, StudentInfo studentInfo){
        Result result = new Result();
        user.setUsername(user.getUid());
        int i = authService.insertRegistStu(user,studentInfo);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("注册成功");
        }else{
            result.setStatus(false);
            result.setMsg("注册失败！请稍后尝试");
        }
        return result;
    }
}
