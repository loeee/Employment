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
public class Treatment {
    private String wx;//五险一金
    private String yx;//补充医疗保险
    private String tj;//定期体检
    private String nzj;//年终奖
    private String nj;//带薪年假
    private String cb;//餐补
    private String gp;//股票期权
    private String jt;//交通补助
    private String zf;//住房补贴
    private String bc;//包吃

}
