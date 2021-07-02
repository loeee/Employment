package com.just.emp.service;


import com.just.emp.po.*;

import java.util.List;
import java.util.Map;
/**
 authot ：赵文辉 郭欣华
 */
public interface EnterpriseWorkService {
    List<Enterprise> selectWorkAll(String keyword);
    //查询所有岗位
    WorkInfo selectWorkInfo(String tid, String wid);
    //查询岗位详细信息
    Address selectAddByWid(String wid);
    //查询公司地址
    int insertAddre(Address address);
    //添加地址
    int insertWork(Info info);
    //添加工作
    WorkImgPath selectImg(String wid);
    //查询图片
    int insertimg(WorkImgPath workImgPath);
    //上传图片


    int deleteWork(String wid,String tid);
    //删除岗位
    int deleteAddress(String wid,String tid);
    //删除地址
    int updateWork(Info info);
    //更新岗位
    Enterprise selectInfo(Integer tid);
    //查询岗位进行数据回显

    //PageBean<Resume> findresumeByPage(String currenpag, String rows);

    Resume infoOne(Integer id,String name);

    Map<String,Object> findResumeStu(String stu, String status, String currenpag, String rows, String uid);
    //查看投递的简历

    int updateaccept(Integer tid,String name,String explain,String status);

    Integer collect(String wid,String tid,String uid);
    //查看收藏

    //我的收藏
    List<Enterprise> selectfavorite(String uid);

    //公司信息
    EnterInfo selectEnterInfo(String uid);

    //完善信息
    int updateInfo(String type,String chang,String uid);

    //企业查看自己的工作
    List<WorkInfo> selectEnterAll(String uid);

    //添加岗位信息
    int insertWorkInfo(WorkInfo workInfo);

    //删除简历
    int delectResume(String uid,String tid, String wid);

    //查看岗位详细信息
    WorkInfo selectworkOneInfo(String tid, String wid);

    /*更新岗位信息*/
    int UpdateEnterInfoWork(String type,String chang,String uid,String tid,String wid);


    /*更新简历状态*/
    int updateResumeStatusStu(String status,String sm,String uid,String wid,String tid);
    /*更新简历状态*/
    int updateResumeStatusEn(String status,String uid,String wid,String tid);
    WorkInfo selectMail(String tid, String wid);

    StudentInfo selectStuInfo(String uid);
    int updatetouximg(String imgpath, String uid);

    int updateWorkInfo(WorkInfo workInfo ,String type);
    int updateAddress(Address address);
    String selectFilename(String uid,String wid,String tid);
    int updateWorkInfo(EnterInfo enterInfo,String type);
    EnterInfo selectMyself(String uid);


}
