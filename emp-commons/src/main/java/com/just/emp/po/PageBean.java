package com.just.emp.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页
 * @param <T>
 */

/**
 * author : 郭欣华 徐鑫祥 罗发逊
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private int totalCount;//总记录条数
    private int totalpag;
    private List<T> list;
    private int currentPage;//当前页码
    private int rows;//每页显示的记录条数
    private Integer status;
}
