package com.just.emp.controller;

import com.just.emp.po.*;
import com.just.emp.service.StudentInfoService;
import com.just.emp.service.StudentWorkEntryService;
import com.just.emp.file.FileUploads;
import com.just.emp.gould.GouldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * author ： 张俊飞 徐波
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentWorkEntryController {


    @Autowired
    private StudentWorkEntryService studentWorkEntryService;
    @Autowired
    private StudentInfoService studentInfoService;
    FileUploads fileUploads = new FileUploads();
    //文件上传工具类
    GouldUtil gouldUtil = new GouldUtil();
    //文件上传工具类
    public String uid = null;
    //学号

    //主页面数据处理--登录成功之后执行
    @RequestMapping("/main")
    public List<WorkInfo> selectInfo(String keyword, String type){
        List<WorkInfo> workInfos = studentWorkEntryService.selectWorkAll(keyword,type);
        return workInfos;
    }
    //主页工作点击查看
    @RequestMapping("/maininfo")
    public WorkInfo SelectMainWorkInfo(String tid,String wid,String uid) throws Exception {
        WorkInfo workInfo = studentWorkEntryService.SelectWorkInfo(wid,tid);
        int i = studentWorkEntryService.MycllockInfo(wid,tid,uid);
        String datainfo  = gouldUtil.getAMapByLngAndLat(workInfo.getAddress().getLocation());
        Address address = new Address();
        address.setLocation(workInfo.getAddress().getLocation());
        address.setDetailaddr(datainfo);
        workInfo.setAddress(address);
        if(i > 0){
            workInfo.setStaclloct("1");
        }else{
            workInfo.setStaclloct("0");
        }
        return workInfo;
    }
    //收藏夹
    @RequestMapping("/favorite")
    public List<WorkInfo> favorite(String uid){
        List<WorkInfo> enterprises = studentWorkEntryService.selectFavorite(uid);
        return enterprises;
    }

    //取消收藏
    @RequestMapping("/deleteCollect")
    public Result deleteCollect(String wid, String tid, String uid){
        Result result = new Result();
        int i = studentWorkEntryService.deleteCollect(wid,tid,uid);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("取消收藏成功");
        }else{
            result.setStatus(false);
            result.setMsg("取消收藏失败！");
        }
        return result;
    }

    //点击收藏
    @RequestMapping("/insertcollect")
    public Result insertCollect(String wid,String tid,String uid){
        Result result = new Result();
        int i = studentWorkEntryService.insertCollect(wid,tid,uid);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("收藏成功");
        }else{
            result.setStatus(false);
            result.setMsg("收藏失败！");
        }
        return result;
    }



    //查询已投递的简历
    @RequestMapping("/selectresume")
    public Map<String,Object> selectResume(String status, String name, String row, String currenpag, String uid){
        if(row == null || row == ""){
            row = "10";
        }
        if(currenpag == null || currenpag == ""){
            currenpag = "1";
        }

        //分页查询
        Map<String,Object> pageBean = studentWorkEntryService.selectResume(status,name,uid,currenpag,row);
        return pageBean;
    }

    //查看简历投递的详细信息
    @RequestMapping("/resumeinfo")
    public Resume resumeInfo(String tid, String wid, String uid){
        Resume resume = studentWorkEntryService.resumeInfo(tid,wid,uid);
        return resume;
    }

    //删除已经投递的简历
    @RequestMapping("/delresume")
    public String delresume(String tid,String wid,String uid){
        int i = studentWorkEntryService.delResume(tid,wid,uid);
        if(i > 0){
            return "true";
        }else {
            return "false";
        }
    }

    //提交简历
    @RequestMapping("/uploadresume")
    public String UploadResume(@RequestParam("file") MultipartFile file, String wid, String tid, HttpServletRequest request) throws IOException {
        String pathurl = fileUploads.fileUploads(file,request);
        int i = studentWorkEntryService.UploadsResume(wid,tid,uid,pathurl);
        if(i > 0){
            return "true";
        }else {
            return "false";
        }
    }

    //查看受理成功的简历
    @RequestMapping("myemployment")
    public Employment SelectMyemployment(String uid){
        Employment employment = studentWorkEntryService.selectMyEmployment(uid);
        return employment;
    }

    //添加就业信息
    @RequestMapping("insertmyemp")
    public String insertmyemp(Employment employment,@RequestParam("file") MultipartFile file,HttpServletRequest request,RedirectAttributes redirectAttributes) throws IOException {
        HttpSession session = request.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("logininfo");
        String pathurl = fileUploads.fileUploads(file,request);
        employment.setEmimg(pathurl);
        employment.setUid(userlogin.getUid());
        int i = studentWorkEntryService.insertMyemp(employment);
        if(i > 0){
            redirectAttributes.addFlashAttribute("Msg", "1");
        }else {
            redirectAttributes.addFlashAttribute("Msg", "0");
        }
        return "redirect:/student/myemployment";
    }
    //修改就业信息
    @RequestMapping("updatemyemp")
    public Result  updatemyemp(Employment employment) {
        System.out.println(employment);
        Result result = new Result();
        int i = studentWorkEntryService.updateMyemp(employment);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("修改成功");
        }else {
            result.setStatus(false);
            result.setMsg("修改失败！！");
        }
        return result;
    }

    //删除就业信息
    @RequestMapping("delmyemp")
    public Result delmyemp(String uid){
        Result result = new Result();
        int i = studentWorkEntryService.delMyemp(uid);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("删除成功");
        }else {
            result.setStatus(false);
            result.setMsg("删除失败！请稍后重试");
        }
        return result;
    }
    //查看就业信息中公司的详细信息
    @RequestMapping("infome")
    public WorkInfo InfoMe(String gc){
        WorkInfo workInfo = studentWorkEntryService.InfoMe(gc);
        return workInfo;
    }

    //查看工作详细信息
    @RequestMapping("/selectworkinfo")
    public WorkInfo SelectWorkInfo(String tid,String wid) throws Exception {
        WorkInfo workInfo = studentWorkEntryService.SelectWorkInfo(wid,tid);
        String datainfo  = gouldUtil.getAMapByLngAndLat(workInfo.getAddress().getLocation());
        Address address = new Address();
        address.setLocation(workInfo.getAddress().getLocation());
        address.setDetailaddr(datainfo);
        workInfo.setAddress(address);
        return workInfo;
    }
}
