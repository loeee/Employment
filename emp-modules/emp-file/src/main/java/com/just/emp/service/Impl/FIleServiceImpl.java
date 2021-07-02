package com.just.emp.service.Impl;

import com.just.emp.mapper.FileMapper;
import com.just.emp.po.Employment;
import com.just.emp.po.EnterInfo;
import com.just.emp.po.Resume;
import com.just.emp.service.FIleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author ： 周鑫
 */
@Service
public class FIleServiceImpl implements FIleService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public int updateheadImg(String path, String uid) {
        return fileMapper.updateheadImg(path,uid);
    }

    @Override
    public int updateWorkInfo(EnterInfo enterInfo, String type) {
        int i = 0;
        if(type!=null && type.equals("logo")){
            i = fileMapper.updateLogo(enterInfo);
        }else if(type!=null && type.equals("lic")){
            i = fileMapper.updateLic(enterInfo);
        }
        return i;
    }

    @Override
    public int insertResume(Resume resume) {
        int i = fileMapper.insertResume_en(resume);
        int j = fileMapper.insertResume_stu(resume);
        if(i > 0 && j >0){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int updateMyempImg(Employment employment) {
        return fileMapper.updateMyempImg(employment);
    }

    @Override
    public int insertMyempInfoImg(Employment employment) {
        return fileMapper.insertMyempInfoImg(employment);
    }

}
