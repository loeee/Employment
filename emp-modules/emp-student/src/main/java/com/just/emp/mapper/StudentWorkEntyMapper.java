package com.just.emp.mapper;

import com.just.emp.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentWorkEntyMapper {

    List<WorkInfo> selectWorkAll(@Param("keyword") String keyword, @Param("type") String type);
    //查询所有岗位

    List<WorkInfo> selectFavorite(@Param("uid") String uid);
    //查看收藏夹

    List<Work> selectWork(String uid);
    int insertWork(Work work);
    int insertImage(OfferPath offerPath);
    int updateWork(Work work);
    int updateImage(OfferPath offerPath);
    int deleteWork(String wid);
    int deleteCollect(@Param("wid") String wid, @Param("tid") String tid, @Param("uid") String uid);
    int insertCollect(@Param("wid") String wid, @Param("tid") String tid, @Param("uid") String uid);

    //查询总数
    int findTotal(@Param("uid") String uid,@Param("status")String status,@Param("name")String name);
   //查询通过的
    int findTotalReBystatu(@Param("uid") String uid,@Param("status")String status,@Param("name")String name);

    //查看已经投递的简历
    List<WorkInfo> selectResume(@Param("uid") String uid,@Param("start")Integer start,@Param("rows")Integer rows,@Param("status")String status,@Param("name")String name);

    Resume resumeInfo(@Param("tid")String tid, @Param("wid")String wid, @Param("uid")String uid);
    //删除简历
    int delResume(@Param("tid")String tid, @Param("wid")String wid, @Param("uid")String uid);

    List<Resume> selectLikeResume(@Param("name") String name,@Param("uid") String uid,@Param("start")Integer start,@Param("rows")Integer rows,@Param("status")String status);
    List<Resume> selectLikeResumetol(@Param("name") String name,@Param("uid") String uid,@Param("start")Integer start,@Param("rows")Integer rows);

    int findTotalLikeCountByuid(@Param("uid") String uid,@Param("name") String name,@Param("status")String status);


    int findTotalLikeReBystatu(@Param("uid") String uid,@Param("name") String name);

    int findTotalLikeCountBytol(@Param("uid") String uid,@Param("name") String name);

    //查看投递的简历
    Employment selectMyEmployment(String uid);

    //学生提交就业信息
    int insertMyemp(Employment employment);
    //学生就业信息修改
    int updateMyemp(Employment employment);
    //删除学生就业信息
    int delMyemp(String uid);

    //查看就业信息中公司的详细信息
    WorkInfo InfoMe(String gc);

    //上传简历
    int insertUploadsResume(@Param("wid") String wid, @Param("tid")String tid, @Param("uid")String uid,@Param("resumefile")String resumefile);

    WorkInfo SelectWorkInfo(@Param("wid") String wid, @Param("tid")String tid);
    int SelectMycllockInfo(@Param("wid") String wid, @Param("tid")String tid,@Param("uid")String uid);



}
