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
public class Enterprise {
    private Integer id;
    private String gname;//岗位名字
    private String salary;//年薪
    private String gc; //公司名字
    private String time; //工作经验
    private String xli; //学历
    private String wid;//关联地址
    private Address address;
    private Integer tid;
    private String type;
    private String gw;
    private WorkInfo workInfo;
    private String tel;
    private Resume resume;
    private String logo;
}
