package com.just.emp.service.Impl;


import com.just.emp.mapper.EnterpriseWorkMapper;
import com.just.emp.po.*;
import com.just.emp.service.EnterpriseWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 authot ：赵文辉 郭欣华
 */
@Service
public class EnterpriseWorkServiceImpl implements EnterpriseWorkService {
   @Autowired
   private EnterpriseWorkMapper enterpriseWorkMapper;

    public List<Enterprise> selectWorkAll(String keyword) {
        return enterpriseWorkMapper.selectWorkAll(keyword);
    }

    public WorkInfo selectWorkInfo(String tid, String wid) {
        return enterpriseWorkMapper.selectWorkInfo(tid,wid);
    }

    public Address selectAddByWid(String wid) {
        return enterpriseWorkMapper.selectAddByWid(wid);
    }

    public int insertAddre(Address address) {
        return enterpriseWorkMapper.insertAddress(address);
    }

    public int insertWork(Info info) {
        return enterpriseWorkMapper.insertWork(info);
    }

    public WorkImgPath selectImg(String wid) {
        return enterpriseWorkMapper.selectImg(wid);
    }

    public int insertimg(WorkImgPath workImgPath) {
        return enterpriseWorkMapper.insertimg(workImgPath);
    }

    public int insertWorkInfo(WorkInfo workInfo) {
        return enterpriseWorkMapper.insertWorkInfo(workInfo);
    }

    public int delectResume(String uid, String tid, String wid) {
        return enterpriseWorkMapper.delectResume(uid,tid,wid);
    }



    public int deleteWork(String wid,String tid) {
        return enterpriseWorkMapper.deleteWork(wid,tid);
    }


    public int deleteAddress(String wid, String tid) {
        return enterpriseWorkMapper.deleteAddress(wid,tid);
    }

    public int updateWork(Info info) {
        return enterpriseWorkMapper.updateWork(info);
    }

    public Enterprise selectInfo(Integer tid) {
        return enterpriseWorkMapper.selectInfo(tid);
    }


    public Resume infoOne(Integer id, String name) {
        return enterpriseWorkMapper.findinfoOne(name,id);
    }

    // 查询投递的简历
    public Map<String,Object> findResumeStu(String stu,String statu,String _currenpag, String _rows,String uid){
        Map<String,Object> result = new HashMap<String, Object>();
        int currrenpag = Integer.parseInt(_currenpag);//当前页码
        int rows = Integer.parseInt(_rows);
        if(currrenpag <= 0){
            currrenpag = 1;
        }
        //调用enterpriseWorkMapper查询总记录条数
        int totalCount = enterpriseWorkMapper.findTotalCount(uid,stu);
        int status = enterpriseWorkMapper.findTotalCountBystatu(uid,statu,stu);
        int start = (currrenpag -1)*rows;
        List<StudentInfo> list = enterpriseWorkMapper.findResumeByPage(uid,statu,stu,start,rows);
        result.put("list",list);
        result.put("total",totalCount);
        result.put("tg",status);
        return result;
    }

    public int updateaccept(Integer tid, String name,String explain,String status) {
        if(status.equals("是")){
            status = "Y";
        }else {
            status = "N";
        }
        return enterpriseWorkMapper.updateaccept(tid,name,explain,status);
    }

    public Integer collect(String wid, String tid,String uid) {
        return enterpriseWorkMapper.collect(wid,tid,uid);
    }

    public List<Enterprise> selectfavorite(String uid) {
        return enterpriseWorkMapper.selectfavorite(uid);
    }

    public EnterInfo selectEnterInfo(String uid) {
        return enterpriseWorkMapper.selectEnterInfo(uid);
    }

    public int updateInfo(String type, String chang,String uid) {
        return enterpriseWorkMapper.updateEnterInfo(type,chang,uid);
    }

    public List<WorkInfo> selectEnterAll(String uid) {
        return enterpriseWorkMapper.selectEnterAll(uid);
    }

    public WorkInfo selectworkOneInfo(String tid, String wid) {
        return enterpriseWorkMapper.selectworkOneInfo(tid,wid);
    }
    public int UpdateEnterInfoWork(String type,String chang,String uid,String tid,String wid){
        return enterpriseWorkMapper.UpdateEnterInfoWork(type,chang,uid,tid,wid);
    }

    public int updateResumeStatusStu(String status, String sm, String uid, String wid, String tid) {
        return enterpriseWorkMapper.updateResumeStatusStu(status,sm,uid,wid,tid);
    }

    public int updateResumeStatusEn(String status, String uid, String wid, String tid) {
        return enterpriseWorkMapper.updateResumeStatusEn(status,uid,wid,tid);
    }

    public WorkInfo selectMail(String tid, String wid) {
        return enterpriseWorkMapper.selectMail(tid,wid);
    }
    public StudentInfo selectStuInfo(String uid){
        return enterpriseWorkMapper.selectStuInfo(uid);
    }
    public int updatetouximg(String imgpath, String uid) {
        return enterpriseWorkMapper.updatetouximg(imgpath,uid);
    }


    public int updateWorkInfo(WorkInfo workInfo, String type) {
        int i = 0;
        if(type != null && type.equals("gzzz")){
            //修改基本信息
          i = enterpriseWorkMapper.updateWorkZz(workInfo);
        }else if(type != null && type.equals("rzyq")){
           i = enterpriseWorkMapper.updateWorkLx(workInfo);
        }
        return i;
    }


    public int updateAddress(Address address) {
        return enterpriseWorkMapper.updateAddress(address);
    }


    public String selectFilename(String uid, String wid, String tid) {
        return enterpriseWorkMapper.selectFilename(uid,wid,tid);
    }


    public int updateWorkInfo(EnterInfo enterInfo, String type) {
        int i = 0;
        if(type!=null && type.equals("info")){
           i = enterpriseWorkMapper.updateGc(enterInfo);
        }else if(type!=null && type.equals("jb")){
            i = enterpriseWorkMapper.updateJb(enterInfo);
        }else if(type!=null && type.equals("tel")){
            i = enterpriseWorkMapper.updateTel(enterInfo);
        }else if(type!=null && type.equals("gs")){
            i = enterpriseWorkMapper.updateGs(enterInfo);
        }
        return i;
    }


    public EnterInfo selectMyself(String uid) {
        return enterpriseWorkMapper.selectEnterInfo(uid);
    }

}
