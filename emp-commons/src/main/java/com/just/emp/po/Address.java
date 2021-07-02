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
public class Address {
    private Integer id;
    private String wid;
    private String tid;
    private String province;//省
    private String city;
    private String county;
    private String detailaddr;//详细地址
    private String location;

}
