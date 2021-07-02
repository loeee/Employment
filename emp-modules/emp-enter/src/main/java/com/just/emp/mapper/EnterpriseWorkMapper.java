package com.just.emp.mapper;

import com.just.emp.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 authot ：赵文辉 郭欣华
 */
@Mapper
public interface EnterpriseWorkMapper {


    List<Enterprise> selectWorkAll(@Param("keyword") String keyword);
    //查询所有岗位

    WorkInfo selectWorkInfo(@Param("tid") String tid,@Param("wid") String wid);
    //查看工作岗位

    Address selectAddByWid(String wid);

    //添加地址
    int insertAddress(Address address);

    int insertWork(Info info);

    WorkImgPath selectImg(String wid);

    int insertimg(WorkImgPath workImgPath);
    int insertWorkInfo(WorkInfo workInfo);
    int deleteWork(@Param("wid") String wid, @Param("tid") String tid);
    int deleteAddress(@Param("wid") String wid, @Param("tid") String tid);

    Enterprise selectInfo(Integer tid);
    int updateWork(Info info);

    int findTotalCount(@Param("uid") String uid,@Param("university")String university);
    //查询所有投递的简历
    int findTotalCountBystatu(@Param("uid") String uid,@Param("status")String status,@Param("university")String university);
    //查询受理通过的
    List<StudentInfo> findResumeByPage(@Param("uid") String uid,@Param("status") String status,@Param("university") String university,@Param("start")Integer start,@Param("rows")Integer rows);

    Resume findinfoOne(@Param("name") String name, @Param("id") Integer id);
    //模糊查询
    int updateaccept(@Param("tid")Integer tid,@Param("name")String name,@Param("explain")String explain,@Param("status")String status);

    Integer collect(@Param("wid") String wid, @Param("tid") String tid,@Param("uid")String uid);
    //收藏
    //我的收藏
    List<Enterprise> selectfavorite(String uid);

    //查看发布的工作
    List<WorkInfo> selectEnterAll(@Param("uid") String uid);

    //删除简历
    int delectResume(@Param("uid")String uid,@Param("tid")String tid,@Param("wid")String wid);

    EnterInfo selectEnterInfo(@Param("uid")String uid);

    int updateEnterInfo(@Param("type")String type, @Param("chang")String chang,@Param("uid")String uid);
    WorkInfo selectworkOneInfo(@Param("tid")String tid, @Param("wid")String wid);

    int UpdateEnterInfoWork(@Param("type")String type,@Param("chang")String chang,@Param("uid")String uid,@Param("tid")String tid,@Param("wid")String wid);

    //更新简历状态
    int updateResumeStatusEn(@Param("status")String status,@Param("uid")String uid,@Param("wid")String wid,@Param("tid")String tid);
    int updateResumeStatusStu(@Param("status")String status,@Param("sm")String sm,@Param("uid")String uid,@Param("wid")String wid,@Param("tid")String tid);

    WorkInfo selectMail(@Param("tid")String tid, @Param("wid")String wid);
    StudentInfo selectStuInfo(@Param("uid")String uid);
    int updatetouximg(@Param("imgpath")String imgpath,@Param("uid")String uid);

    // 修改基本信息
    int updateWorkZz(WorkInfo workInfo);
    int updateWorkLx(WorkInfo workInfo);
    int updateAddress(Address address);
    int updateGc(EnterInfo enterInfo);

    String selectFilename(@Param("uid")String uid,@Param("wid")String wid,@Param("tid")String tid);
    EnterInfo selectMysql(@Param("uid")String uid);
    int updateJb(EnterInfo enterInfo);
    int updateTel(EnterInfo enterInfo);
    int updateGs(EnterInfo enterInfo);

}
