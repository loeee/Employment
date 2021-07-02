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

public class EchartsMagor {
    private String cla;//班级
    private Integer total;//专业总人数
    private Integer ytotal;
    private Integer utotal;
    private String sex;
}
