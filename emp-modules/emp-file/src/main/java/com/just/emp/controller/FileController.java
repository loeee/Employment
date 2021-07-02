package com.just.emp.controller;

import com.just.emp.po.Employment;
import com.just.emp.po.EnterInfo;
import com.just.emp.po.Result;
import com.just.emp.po.Resume;
import com.just.emp.service.FIleService;
import com.just.emp.file.FileUploads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FIleService fIleService;
    FileUploads fileUploads = new FileUploads();
    @RequestMapping("/headimg")
    public Result SetHeadImg(@RequestParam("files") MultipartFile files, @RequestParam("uid") String uid, HttpServletRequest request) throws IOException {
        Result result = new Result();
        String path = fileUploads.fileUploads(files,request);
        int i = fIleService.updateheadImg(path,uid);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("修改成功");
            result.setToux(path);
        }else{
            result.setStatus(false);
            result.setMsg("修改失败，请稍后尝试");
        }
        return  result;
    }

    //企业修改岗位logo
    @RequestMapping("/updateworkImg")
    public Result updateWorkImg(@RequestParam("files")MultipartFile files ,String type,HttpServletRequest request,String uid) throws IOException {
        Result result = new Result();
        EnterInfo enterInfo = new EnterInfo();
        String path = fileUploads.fileUploads(files,request);
        if(type!=null && type.equals("logo")){
            enterInfo.setLogoimg(path);
        }else if(type!=null && type.equals("lic")){
            enterInfo.setLicenseimg(path);
        }
        enterInfo.setUid(uid);
        int i = fIleService.updateWorkInfo(enterInfo,type);
        if(i>0){
            result.setStatus(true);
            result.setMsg("修改成功");
        }else{
            result.setStatus(false);
            result.setMsg("修改失败！！");
        }
        return  result;
    }

    //简历上传
    @RequestMapping("/fileupload")
    public Result demo(@RequestParam("files")MultipartFile file, Resume resume, HttpServletRequest request) throws IOException {
        Result result = new Result();
        System.out.println(resume);
        String path = fileUploads.fileUploads(file,request);
        resume.setResumefile(path);
        int i = fIleService.insertResume(resume);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("简历上传成功");
        }else {
            result.setStatus(false);
            result.setMsg(" 简历上传失败！！请稍后重试");
        }
        return result;
    }
    //修改就业信息
    @RequestMapping("updatemyempinfoimg")
    public Result  updatemyempinfoimg(@RequestParam("gc") String gc,@RequestParam("gw") String gw,@RequestParam("salary") String salary,@RequestParam("type") String type,@RequestParam("uid") String uid,@RequestParam("files")MultipartFile files,HttpServletRequest request) throws IOException {
        Employment employment = new Employment();
        String emimg = fileUploads.fileUploads(files,request);
        employment.setEmimg(emimg);
        employment.setGc(gc);
        employment.setGw(gw);
        employment.setType(type);
        employment.setSalary(salary);
        Result result = new Result();
        employment.setUid(uid);
        int i = fIleService.insertMyempInfoImg(employment);
        if(i > 0){
            result.setStatus(true);
            result.setMsg("添加成功");
        }else {
            result.setStatus(false);
            result.setMsg("添加失败！！");
        }
        return result;
    }

}
