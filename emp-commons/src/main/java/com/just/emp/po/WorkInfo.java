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
public class WorkInfo {
    private Integer id;
    private String opera;//工作职责
    private String treatment;//待遇
    private Address address;//详细地址
    private String tid;
    private String wid;
    private String uid;
    private String salary;
    private String exp;//经验
    private String xli;
    private String gname;
    private String gw;
    private String claim;//任职要求
    private EnterInfo enterInfo;
    private String type;
    private Resume resume;
    private String staclloct;
    private WorkImgPath workpath;
    private Employment employment;

}
