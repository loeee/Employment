package com.just.emp.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * author : 郭欣华 徐鑫祥 罗发逊
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterInfo {
    private Integer id;
    private String uid;
    private String cname;//公司名字
    private String tel;
    private String listing;
    private String legal;
    private String principal;//岗位负责人
    private String time;
    private String money;
    private String attribute;//企业类型
    private String info;//公司信息
    private String licenseimg;//营业执照
    private String logoimg;//logo
    private String tid;
    private String status;
    private String people;
    private String touximg;
    private String email;
}
