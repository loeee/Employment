package com.just.emp.controller;


import com.just.emp.po.*;
import com.just.emp.service.TeachersideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * author ： 阮薪翰  周鑫
 */
@Controller
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeachersideService teachersideService;
    public String tuid = null;
    public String tcla = null;
    public String major = null;

    //查询个人信息
    @RequestMapping("selectinfo")
    @ResponseBody
    public TeacherInfo TeacherInfo(String uid){
        TeacherInfo teacherInfo = teachersideService.selectInfo(uid);
        return teacherInfo;
    }

    //修改个人信息
    @RequestMapping("updateinfo")
    @ResponseBody
    public String updateinfo(String type,String chang){
        int i = teachersideService.updateInfo(type,chang,tuid);
        if(i > 0){
            return "true";
        }else {
            return "false";
        }
    }
    //查看班级学生的就业信息
    @RequestMapping("/selectechartsclass")
    @ResponseBody
    public List<EchartsMagor> selectEchartsClass(String cla){
        List<EchartsMagor> echarts = teachersideService.selectClass(cla);
        return echarts;
    }
    //查询专业学生就业信息
    @RequestMapping("/selectempinfo")
    @ResponseBody
    public List<EchartsMagor> selectEmpInfo(String major){
        List<EchartsMagor> emps = teachersideService.selectEmpInfo(major);
        return emps;
    }

     //班级 -- 就业信息
    @RequestMapping("/selectclassstuinfo")
    @ResponseBody
    public Map<String,Object> selectClassStuInfo(String rows, String currenpage, String sex, String gc,String cla){
        if(currenpage==null || "".equals(currenpage)){
            //如果获取到的当前页面为空。则给他赋值为1
            currenpage = "1";
        }
        if(rows==null||"".equals(rows)){
            //通过获取到的每页显示的总记录条数为空，则给他赋值为10
            rows="10";
        }
        if(sex!=null && sex.equals("全部")){
            sex = null;
        }
        Map<String,Object> pageBean = teachersideService.selectClassStuInfo(currenpage,rows,cla,sex,gc);
        return pageBean;
    }
    //专业 就业信息
    @RequestMapping("/selectmajortuinfo")
    @ResponseBody
    public Map<String,Object> selectMgjorStuInfo(String rows,String currenpage,String sex,String gc,String major){
        if(currenpage==null || "".equals(currenpage)){
            //如果获取到的当前页面为空。则给他赋值为1
            currenpage = "1";
        }
        if(rows==null||"".equals(rows)){
            //通过获取到的每页显示的总记录条数为空，则给他赋值为10
            rows="10";
        }
        if(sex!=null && sex.equals("全部")){
            sex = null;
        }
        Map<String,Object> pageBean = teachersideService.selectMagorStuInfo(currenpage,rows,major,sex,gc);
        return pageBean;
    }

    //页面跳转
    @RequestMapping("/teajump")
    public String TeaJump(String type){
        if(type.equals("pwd")){
            return "/teacher/teapassword";
        }else {
            return "/teacher/teamodification";
        }
    }

    //查询工作信息
    @RequestMapping("/stuempinfo")
    @ResponseBody
    public Employment SelectStuEmpInfo(String uid){
        Employment employment = teachersideService.SelectEpmStuInfo(uid);
        return employment;
    }

}
