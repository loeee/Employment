package com.just.emp.mapper;

import com.just.emp.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeachersideMapper {
    //查询个人信息
    TeacherInfo selectInfo(String uid);

    //修改个人信息
    int updateInfo(@Param("type") String type, @Param("chang")String chang, @Param("uid")String uid);
    //查询班级已就业信息
    List<EchartsMagor> selectClass(String cla);

    List<EchartsMagor> selectEmpInfo(String major);

    int findTotalLikeReBycla(@Param("cla")String cla);
    int findTotalLikeReByemp(@Param("cla")String cla);
    List<StudentInfo> selectLikeStuInfo(@Param("start")Integer start,@Param("rows")Integer rows,@Param("sex")String sex,@Param("gc")String gc,@Param("cla")String cla);

    int findTotalLikeMaBycla(@Param("major")String major);
    int findTotalLikeMaByemp(@Param("major")String major);
    List<StudentInfo> selectLikeMajorInfo(@Param("start")Integer start,@Param("rows")Integer rows,@Param("sex")String sex,@Param("gc")String gc,@Param("major")String major);
    int updatetouximg(@Param("imgpath")String imgpath,@Param("uid")String uid);
    int updatePwd(@Param("uid") String uid, @Param("newPwd") String newPwd);
    Employment SelectEpmStuInfo(@Param("uid") String uid);

}
