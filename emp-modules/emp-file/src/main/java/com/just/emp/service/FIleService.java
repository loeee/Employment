package com.just.emp.service;

import com.just.emp.po.*;

/**
 * author ： 周鑫
 */
public interface FIleService {
    int updateheadImg(String path,String uid);
    int updateWorkInfo(EnterInfo enterInfo, String type);
    int insertResume(Resume resume);

    int updateMyempImg(Employment employment);
    int insertMyempInfoImg(Employment employment);
}
