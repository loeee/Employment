package com.just.emp.service;

import com.just.emp.po.*;

import java.util.List;
import java.util.Map;

public interface StudentWorkEntryService {
    List<WorkInfo> selectWorkAll(String keyword, String type);
    //首页工作
    List<WorkInfo> selectFavorite(String uid);
    //收藏夹
    List<Work> selectWork(String uid);
    int insertWork(Work work);
    int insertImage(OfferPath offerPath);
    int updateWork(Work work);
    int updateImage(OfferPath offerPath);
    int deleteWork(String wid);
    int deleteCollect(String wid,String tid,String uid);
    int insertCollect(String wid,String tid,String uid);


    //查看已经投递的简历
    Map<String,Object> selectResume(String status, String name, String uid, String currenpag, String row);

    //查看简历的详细信息
    Resume resumeInfo(String tid,String wid,String uid);

    //删除已经投递的经理
    int delResume(String tid,String wid,String uid);
   //按条件查询已经投递的简历
    PageBean<Resume> selectLikeResume(String _currenpag,String _rows,String name, String uid,String statu);

     //学生查看就业信息
    Employment selectMyEmployment(String uid);
    //学生添加就业信息
    int insertMyemp(Employment employment);

    //学生就业信息修改
    int updateMyemp(Employment employment);

    //删除就业信息
    int delMyemp(String uid);

    //查看就业信息中公司的详细信息
    WorkInfo InfoMe(String gc);

    //上传简历
    int UploadsResume(String wid,String tid,String uid,String resumefile);

    //查询工作详细信息
    WorkInfo SelectWorkInfo(String wid, String tid);

    //查询主页工作详细信息
    int MycllockInfo(String wid, String tid,String uid);

}
