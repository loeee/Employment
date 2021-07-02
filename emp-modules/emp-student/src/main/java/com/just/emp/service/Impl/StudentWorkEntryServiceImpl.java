package com.just.emp.service.Impl;


import com.just.emp.mapper.StudentWorkEntyMapper;
import com.just.emp.po.*;
import com.just.emp.service.StudentWorkEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentWorkEntryServiceImpl implements StudentWorkEntryService {
    @Autowired
    private StudentWorkEntyMapper studentWorkEntyMapper;

    public List<WorkInfo> selectWorkAll(String keyword, String type) {
        return studentWorkEntyMapper.selectWorkAll(keyword,type);
    }

    public List<WorkInfo> selectFavorite(String uid) {
        return studentWorkEntyMapper.selectFavorite(uid);
    }

    public List<Work> selectWork(String uid) {
        return studentWorkEntyMapper.selectWork(uid);
    }

    public int insertWork(Work work) {
        return studentWorkEntyMapper.insertWork(work);
    }

    public int insertImage(OfferPath offerPath) {
        return studentWorkEntyMapper.insertImage(offerPath);
    }

    public int updateWork(Work work) {
        return studentWorkEntyMapper.updateWork(work);
    }

    public int updateImage(OfferPath offerPath) {
        return studentWorkEntyMapper.updateImage(offerPath);
    }

    public int deleteWork(String wid) {
        return studentWorkEntyMapper.deleteWork(wid);
    }
    public int deleteCollect(String wid,String tid,String uid){
        return studentWorkEntyMapper.deleteCollect(wid,tid,uid);
    }
    public int insertCollect(String wid,String tid,String uid){
        return studentWorkEntyMapper.insertCollect(wid,tid,uid);
    }

    // 查看投递的简历 -分页、模糊
    public Map<String,Object> selectResume(String statu,String name,String uid, String _currenpag, String _rows) {
        Map<String,Object> result = new HashMap<String, Object>();
        int currrenpag = Integer.parseInt(_currenpag);//当前页码
        if(currrenpag < 0){
            currrenpag = 1;
        }
        int rows = Integer.parseInt(_rows);
        //调用enterpriseWorkMapper查询总记录条数
        int totalCount = studentWorkEntyMapper.findTotal(uid,statu,name);
        //查询通过的
        int status = studentWorkEntyMapper.findTotalReBystatu(uid,"通过",name);
        int start = (currrenpag -1)*rows;
        List<WorkInfo> list = studentWorkEntyMapper.selectResume(uid,start,rows,statu,name);
        result.put("list",list);
        result.put("total",totalCount);
        result.put("tg",status);
        return result;
    }
    public Resume resumeInfo(String tid, String wid, String uid) {
        return studentWorkEntyMapper.resumeInfo(tid,wid,uid);
    }

    public int delResume(String tid, String wid, String uid) {
        return studentWorkEntyMapper.delResume(tid,wid,uid);
    }

    public PageBean<Resume> selectLikeResume(String _currenpag, String _rows, String name, String uid, String statu) {
        int currrenpag = Integer.parseInt(_currenpag);//当前页码
        if(currrenpag < 0){
            currrenpag = 1;
        }
        int rows = Integer.parseInt(_rows);
        PageBean<Resume> pb = new PageBean<Resume>();
        //封装参数
        pb.setCurrentPage(currrenpag);
        pb.setRows(rows);
        //调用enterpriseWorkMapper查询总记录条数
        int status = studentWorkEntyMapper.findTotalLikeReBystatu(uid,name);
        pb.setStatus(status);
        int start = (currrenpag -1)*rows;
        int totalCount = 0;
        if(statu.equals("通过")){
            totalCount = studentWorkEntyMapper.findTotalLikeCountByuid(uid,name,"Y");
            pb.setTotalCount(totalCount);
            List<Resume> list = studentWorkEntyMapper.selectLikeResume(name,uid,start,rows,"Y");
            pb.setList(list);
        }else if(statu.equals("未通过")){
            totalCount = studentWorkEntyMapper.findTotalLikeCountByuid(uid,name,"N");
            pb.setTotalCount(totalCount);
            List<Resume> list = studentWorkEntyMapper.selectLikeResume(name,uid,start,rows,"N");
            pb.setList(list);
        }else{
            totalCount = studentWorkEntyMapper.findTotalLikeCountBytol(uid,name);
            pb.setTotalCount(totalCount);
            List<Resume> list = studentWorkEntyMapper.selectLikeResumetol(name,uid,start,rows);
            pb.setList(list);
        }

        //计算总页码
        int totalPage = totalCount % rows ==0 ?totalCount/rows:totalCount/rows+1;
        pb.setTotalpag(totalPage);
        return pb;
    }

    //查看投递的简历
    public Employment selectMyEmployment(String uid){
        return studentWorkEntyMapper.selectMyEmployment(uid);
    }

    public int insertMyemp(Employment employment) {
        return studentWorkEntyMapper.insertMyemp(employment);
    }
    public int updateMyemp(Employment employment) {
        return studentWorkEntyMapper.updateMyemp(employment);
    }

    public int delMyemp(String uid) {
        return studentWorkEntyMapper.delMyemp(uid);
    }

    public WorkInfo InfoMe(String gc) {
        return studentWorkEntyMapper.InfoMe(gc);
    }

    public int UploadsResume(String wid, String tid, String uid,String resumefile) {
        return studentWorkEntyMapper.insertUploadsResume(wid,tid,uid,resumefile);
    }

    public WorkInfo SelectWorkInfo(String wid, String tid) {
        return studentWorkEntyMapper.SelectWorkInfo(wid,tid);
    }


    public int MycllockInfo(String wid, String tid,String uid) {
        return studentWorkEntyMapper.SelectMycllockInfo(wid,tid,uid);
    }


}
