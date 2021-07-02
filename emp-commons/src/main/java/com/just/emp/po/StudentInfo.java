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
public class StudentInfo{
   private String uid;
   private String name;//姓名
   private String nat;//籍贯
   private String sex;//性别
   private String nation;//民族
   private String birthday;
   private String time;//毕业时间
   private String school;
   private String major;
   private String experience;//工作经历
   private String awards;//在校获奖
   private String skills;//个人技能
   private String evaluation;//自我评价
   private String studentcard;//学生证
   private String department;//院系
   private String cla;//班级
   private String email;
   private String telephone;
   private String xli;
   private String timg;
   private String diploma;
   private Employment employment;
   private Resume resume;
   private String educational;
}
