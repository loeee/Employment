package com.just.emp.mapper;

import com.just.emp.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * author ： 周鑫
 */

@Mapper
public interface FileMapper {
    int updateheadImg(@Param("path") String path, @Param("uid")String uid);
    int updateLogo(EnterInfo enterInfo);
    int updateLic(EnterInfo enterInfo);
    int insertResume_stu(Resume resume);
    int insertResume_en(Resume resume);
    int insertMyempInfoImg(Employment employment);
    //修改就业信息图片
    int updateMyempImg(Employment employment);
}