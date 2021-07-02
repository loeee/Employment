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
public class Employment {
    private Integer id;
    private String uid;
    private String gc;
    private String gw;
    private String type;
    private String salary;
    private String emimg;

}
