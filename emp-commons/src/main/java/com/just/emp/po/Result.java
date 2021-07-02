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
public class Result {
    private Boolean status;
    private String msg;
    private String uid;
    private String name;
    private String toux;
    private String path;
}
