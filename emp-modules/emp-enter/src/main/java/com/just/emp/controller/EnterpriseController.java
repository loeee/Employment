package com.just.emp.controller;


import com.just.emp.po.*;
import com.just.emp.service.EnterpriseWorkService;
import com.just.emp.conv.Stringconversion;
import com.just.emp.email.SendMail;
import com.just.emp.file.FileUploads;
import com.just.emp.gould.GouldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
/**
    authot ：赵文辉 郭欣华
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseWorkService enterpriseWorkService;
    private FileUploads fileUploads = new FileUploads();
    SendMail sendMail = new SendMail();
    Stringconversion stringconversion = new Stringconversion();
    GouldUtil gouldUtil = new GouldUtil();


    // 查询企业信息
    @RequestMapping("selectmyself")
    public EnterInfo selectMyself(String uid){
        EnterInfo enterInfo = enterpriseWorkService.selectMyself(uid);
        return enterInfo;
    }

    //企业添加岗位
    @RequestMapping("/insertWork")
    public Result insertWork(Info info) throws Exception {
        Result result = new Result();
        //转换地址
        String location = gouldUtil.getLonLat(info.getSxq()+info.getXxdz());
        Address address = new Address();
        address.setLocation(location);
        address.setProvince(info.getS());
        address.setTid(info.getGsbh());
        address.setWid(info.getGwbh());
        //添加地址
        int addre = enterpriseWorkService.insertAddre(address);
        //添加工作
        int work = enterpriseWorkService.insertWork(info);
        if(addre > 0 && work >0){
            result.setStatus(true);
            result.setMsg("添加成功");
        }else {
            result.setStatus(false);
            result.setMsg("添加失败！");
        }
        return result;
    }
    //企业删除岗位
    @RequestMapping("/deletework")
    public Result deleteWork(String wid,String tid){
        Result result = new Result();
        int del = enterpriseWorkService.deleteWork(wid,tid);
        int addr = enterpriseWorkService.deleteAddress(wid,tid);
        if(del > 0 && addr >0){
            result.setStatus(true);
            result.setMsg("删除成功");
        }else {
            result.setStatus(false);
            result.setMsg("删除失败！");
        }
        return result;
    }

    //企业更新岗位
    @RequestMapping("/updateWork")
    public Result updateWork(WorkInfo workInfo, String type){
        Result result = new Result();
        int i = enterpriseWorkService.updateWorkInfo(workInfo,type);
        if(i>0){
            result.setStatus(true);
            result.setMsg("修改成功");
        }else{
            result.setStatus(false);
            result.setMsg("修改失败！！");
        }
        return  result;
    }

    //修改企业信息
    @RequestMapping("/updateworkInfo")
    public Result updateWorkInfo(EnterInfo enterInfo,String type){
        Result result = new Result();
        int i = enterpriseWorkService.updateWorkInfo(enterInfo,type);
        if(i>0){
            result.setStatus(true);
            result.setMsg("修改成功");
        }else{
            result.setStatus(false);
            result.setMsg("修改失败！！");
        }
        return  result;
    }


    //企业更新地址
    @RequestMapping("/updateaddress")
    public Result updateAddress(Address address) throws Exception {
        String loc = gouldUtil.getLonLat(address.getLocation()+address.getDetailaddr());
        address.setLocation(loc);
        Result result = new Result();
        int i = enterpriseWorkService.updateAddress(address);
        if(i>0){
            result.setStatus(true);
            result.setMsg("修改成功");
        }else{
            result.setStatus(false);
            result.setMsg("修改失败！！");
        }
        return  result;

    }
    //
    @RequestMapping("/infoOne")
    public Resume infoOne(Integer id,String name) {
        Resume resume = enterpriseWorkService.infoOne(id,name);
        return resume;
    }

    //查看我的收藏里面的工作信息
    @RequestMapping("/mycollectInfo")
    public WorkInfo mycollectInfo(String tid, String wid) {
        WorkInfo workInfo = enterpriseWorkService.selectWorkInfo(tid,wid);
        System.out.println(workInfo);
        return workInfo;
    }

    //企业查看自己的工作
    @RequestMapping("/selectenterall")
    public List<WorkInfo> SelectEnterAll(String uid){
        List<WorkInfo> enterprises = enterpriseWorkService.selectEnterAll(uid);
        return enterprises;
    }

    //完善信息
    @RequestMapping("/updateinfo")
    public String updateEnterinfo(String type,String chang,String uid){
        if(type != null && type.equals("js")){
            chang = stringconversion.rep(chang);
        }
        int i = enterpriseWorkService.updateInfo(type,chang,uid);
        if(i > 0){
            return "true";
        }else {
            return "false";
        }

    }

    //完善信息
    @RequestMapping("/updateinfoimg")
    public String updateEnterinfoimg(String type,String uid,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        String chang = null;
        if(file != null && type.equals("file")){
            chang = fileUploads.fileUploads(file,request);
        }
        int i = enterpriseWorkService.updateInfo(type,chang,uid);
        if(i > 0){
            return "true";
        }else {
            return "false";
        }

    }

    //岗位信息
    @RequestMapping(value = "/insertenterinfo")
    public String InsertEnterInfo(WorkInfo workInfo,Treatment treatment,Address address,HttpServletRequest request,RedirectAttributes redirectAttributes) throws IOException {
        HttpSession session = request.getSession();
        EnterInfo enterInfo = (EnterInfo) session.getAttribute("enter");
        String ter = "";
        if(treatment != null){
            if(treatment.getWx() != null){
                ter +=treatment.getWx()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getYx() != null){
                ter +=treatment.getYx()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getTj()!= null){
                ter +=treatment.getTj()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getNzj() != null){
                ter +=treatment.getNzj()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getNj() != null){
                ter +=treatment.getNj()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getCb() != null){
                ter +=treatment.getCb()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getGp() != null){
                ter +=treatment.getGp()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getJt() != null){
                ter +=treatment.getJt()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getZf() != null){
                ter +=treatment.getZf()+"&nbsp;&nbsp;&nbsp;";
            }
            if(treatment.getBc() != null){
                ter +=treatment.getBc()+"&nbsp;&nbsp;&nbsp;";
            }
        }
        try {
            address.setLocation(gouldUtil.getLonLat(address.getProvince()+address.getCity()+address.getCounty()+address.getDetailaddr()));
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("Msg", "3");//位置错误
            return "redirect:/enterprise/selectenterall";
        }
       workInfo.setTreatment(ter);
       workInfo.setOpera(stringconversion.rep(workInfo.getOpera()));
       workInfo.setClaim(stringconversion.rep(workInfo.getClaim()));
       //格式化
       //存数据
        //1. 存地址
        address.setTid(enterInfo.getTid());
        workInfo.setTid(enterInfo.getTid());
        workInfo.setUid(enterInfo.getUid());
        int addre = 0;
        int info = 0;
        addre = enterpriseWorkService.insertAddre(address);
        if(addre > 0 ){
            //2.存信息
            info = enterpriseWorkService.insertWorkInfo(workInfo);
            //插入数据成功
            if(info > 0){
                redirectAttributes.addFlashAttribute("Msg", "1");
            }
        }
        if(addre == 0 || info == 0) {
           redirectAttributes.addFlashAttribute("Msg", "0");
        }
        return "redirect:/enterprise/selectenterall";
    }

    //查看收到的简历
    @RequestMapping("/resumeacceptance")
    public Map<String,Object> ResumeAcccept(String rows,String currenpage,String stu,String status,String uid){
        if(currenpage==null || "".equals(currenpage)){
            //如果获取到的当前页面为空。则给他赋值为1
            currenpage = "1";
        }
        if(rows==null||"".equals(rows)){
            //通过获取到的每页显示的总记录条数为空，则给他赋值为10
            rows="10";
        }
        if(status!=null){
            if(status.equals("全部")){
                status = null;
            }
        }
        Map<String,Object> pageBean = enterpriseWorkService.findResumeStu(stu,status,currenpage,rows,uid);
        return pageBean;
    }

    // 删除简历
    @RequestMapping("/delresumestu")
    public Result DelresumeStu(String uid,String tid,String wid){
        Result result = new Result();
        int i = enterpriseWorkService.delectResume(uid,tid,wid);//uid：个人编号 tid：公司编号 wid：岗位编号
        if(i >0){
            result.setStatus(true);
            result.setMsg("删除成功");
        }else {
            result.setStatus(false);
            result.setMsg("删除失败！！");
        }
        return result;
    }
    //查看岗位信息
    @RequestMapping("selectenteroneinfo")
    public String SelectEnterInfo(String wid,String tid,Model model){
       WorkInfo workInfo = enterpriseWorkService.selectworkOneInfo(tid,wid);
       model.addAttribute("winfo",workInfo);
       return "/enterprise/workInfo";

    }

    //受理简历
    @RequestMapping("/accept")
    public Result AcceptResume(String status,String uid,String sm,String wid,String tid,String name,String email){
        Result result = new Result();
        if(status!=null && status.equals("是")){
            status ="通过";
        }else {
            status = "未通过";
        }
        boolean falg = false;
        //查询学生邮箱,姓名
        //查询公司，岗位
        WorkInfo workInfo = enterpriseWorkService.selectMail(tid,wid);
        //更新resume-en中status
        int i = enterpriseWorkService.updateResumeStatusEn(status,uid,wid,tid);
        //更新resume——stustataus,informatin
        int j = enterpriseWorkService.updateResumeStatusStu(status,sm,uid,wid,tid);
        falg = sendMail.sendMail(name, workInfo.getEnterInfo().getCname(), workInfo.getGw(), sm, email);
        if(i > 0 && j >0){
           result.setStatus(true);
           result.setMsg("受理成功");
        }else {
            result.setStatus(false);
            result.setMsg("受理失败！！！");
        }
        return result;
    }

    //页面跳转
    @RequestMapping("/jump")
    public String Jump(String type){
        if(type != null && type.equals("pwd")){
            return "/enterprise/enpassword";
        }else {
            return "/enterprise/enmodfilecation";
        }
    }

    //简历下载前获取简历所在路径（文件夹）
    @RequestMapping("/getpath")
    public Result download(String uid,String tid,String wid,HttpServletRequest request)  {
        Result result = new Result();
        String filen = enterpriseWorkService.selectFilename(uid,wid,tid);
        System.out.println(filen);
        String fileName =filen.substring(8);
        String path = request.getSession().getServletContext().getRealPath("/uploads/")+fileName;
        result.setPath(path);
        return result;
    }
    //简历下载
    @RequestMapping("/download")
    public void download(String path, HttpServletResponse response) {
        try {
            // path： 欲下载的文件的路径
            File file = new File(path);
            if(!file.exists()){
                return;
            }
            // 获取文件名 - 设置字符集
            String downloadFileName = new String(file.getName().getBytes(StandardCharsets.UTF_8), "iso-8859-1");
            // 以流的形式下载文件
            InputStream fis;
            fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
