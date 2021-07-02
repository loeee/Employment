package com.just.emp.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author : 郭欣华 徐鑫祥 罗发逊
 */
/*
简历表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    private Integer id;
    private String infomation; //回馈信息
    private String status; //状态
    private String tid;
    private String wid;
    private String uid;
    private String tuid;
    private String resumefile;//简历文件路径
    private String gc;
    private String gw;
    private String type;
}
