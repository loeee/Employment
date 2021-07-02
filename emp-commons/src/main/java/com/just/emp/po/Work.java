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
public class Work {
    private String wid;
    private String wname;
    private String salary;
    private String category;
    //岗位
    private String telephone;
    private String principal;
    private String uid;
    private Address address;
    private OfferPath offerPaths;

}
