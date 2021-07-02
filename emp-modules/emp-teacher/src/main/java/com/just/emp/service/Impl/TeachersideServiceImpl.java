package com.just.emp.service.Impl;


import com.just.emp.mapper.TeachersideMapper;
import com.just.emp.po.*;
import com.just.emp.service.TeachersideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeachersideServiceImpl implements TeachersideService {
    @Autowired
    private TeachersideMapper teachersideMapper;

    public TeacherInfo selectInfo(String uid) {
        return teachersideMapper.selectInfo(uid);
    }

    public int updateInfo(String type, String chang, String uid) {
        return teachersideMapper.updateInfo(type, chang, uid);
    }

    public List<EchartsMagor> selectClass(String cla) {
        return teachersideMapper.selectClass(cla);
    }

    public List<EchartsMagor> selectEmpInfo(String major) {
        return teachersideMapper.selectEmpInfo(major);
    }

    public Map<String,Object> selectClassStuInfo(String _currenpag, String _rows, String cla, String sex, String gc) {
        Map<String,Object> result = new HashMap<String, Object>();
        int currrenpag = Integer.parseInt(_currenpag);//当前页码
        if (currrenpag < 0) {
            currrenpag = 1;
        }
        int rows = Integer.parseInt(_rows);
        //调用enterpriseWorkMapper查询总记录条数
        int totalCount = teachersideMapper.findTotalLikeReBycla(cla);
        //查询通过的
        int status = teachersideMapper.findTotalLikeReByemp(cla);
        int start = (currrenpag -1)*rows;
        List<StudentInfo> list = teachersideMapper.selectLikeStuInfo(start,rows,sex,gc,cla);
        result.put("list",list);
        result.put("total",totalCount);
        result.put("tg",status);
        return result;
    }
    public Map<String,Object> selectMagorStuInfo(String _currenpag, String _rows, String major, String sex,String gc) {
        Map<String,Object> result = new HashMap<String, Object>();
        int currrenpag = Integer.parseInt(_currenpag);//当前页码
        if (currrenpag < 0) {
            currrenpag = 1;
        }
        int rows = Integer.parseInt(_rows);

        int status = teachersideMapper.findTotalLikeMaByemp(major);
        int start = (currrenpag - 1) * rows;
        int totalCount = 0;
        totalCount = teachersideMapper.findTotalLikeMaBycla(major);
        List<StudentInfo> list = teachersideMapper.selectLikeMajorInfo(start,rows,sex,gc,major);
        result.put("list",list);
        result.put("total",totalCount);
        result.put("tg",status);
        return result;
    }

    public int updatetouximg(String imgpath, String uid) {
        return teachersideMapper.updatetouximg(imgpath,uid);
    }

    public int updatePwd(String uid, String newPwd) {
        return teachersideMapper.updatePwd(uid,newPwd);
    }

    public Employment SelectEpmStuInfo(String uid) {
        return teachersideMapper.SelectEpmStuInfo(uid);
    }
}
