package com.just.emp.email;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author ： 彭德学
 */

public class SendMail {

    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    public Boolean sendMail(String name,String gc,String gw,String text,String mail){
        MimeMessage mm=javaMailSender.createMimeMessage();
        MimeMessageHelper smm=new MimeMessageHelper(mm);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        try {
            smm.setFrom("just_nu@foxmail.com");//发送人的邮件
            smm.setTo(mail);//接收的邮箱的地址
            smm.setSubject("注册消息");//邮件的标题
            smm.setText("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"> <html lang=\"en\"> <head> <meta charset=\"UTF-8\"> <title>邮件提醒</title> 　　 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>  </head> <body style=\"margin: 0; padding: 0;\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\"> 　 <tr> <td> <div style=\"margin: 20px;text-align: center;margin-top: 50px\"></div> </td> </tr> <tr> <td> <div style=\"border: #36649d 1px dashed;margin: 30px;padding: 20px\"> <label style=\"font-size: 22px;color: #36649d;font-weight: bold\">恭喜您，您投递的简历已被受理！</label> <p style=\"font-size: 16px\">亲爱的&nbsp;<label style=\"font-weight: bold\">"+name+"先生/女士</label>&nbsp; 您好！通过受理您的简历，我司决定于 </p> <p style=\"font-size: 16px\">"+text+"</p> </div> </td> </tr> 　 <tr> <td>  </div> </td> </tr>   <tr> <td> <div align=\"right\" style=\"margin: 40px;border-top: solid 1px gray\" id=\"bottomTime\"> <p style=\"margin-right: 20px\">"+gc+"-"+gw+"</p> <label style=\"margin-right: 20px\">"+date+"</label> </div> </td> </tr> </table> </body> </html>",true);//邮件的内容  true 是代表的html格式生效
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        javaMailSender.send(mm);//发送邮件
        return true;
    }
    public void sendfMailCode(String email,String code,String title){
        MimeMessage mm=javaMailSender.createMimeMessage();
        MimeMessageHelper smm=new MimeMessageHelper(mm);
        try {
            smm.setFrom("just_nu@foxmail.com");//发送人的邮件
            smm.setTo(email);//接收的邮箱的地址
            smm.setSubject(title);//邮件的标题
            smm.setText("\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <base target=\"_blank\" />\n" +
                    "    <style type=\"text/css\">::-webkit-scrollbar{ display: none; }</style>\n" +
                    "    <style id=\"cloudAttachStyle\" type=\"text/css\">#divNeteaseBigAttach, #divNeteaseBigAttach_bak{display:none;}</style>\n" +
                    "    <style id=\"blockquoteStyle\" type=\"text/css\">blockquote{display:none;}</style>\n" +
                    "    <style type=\"text/css\">\n" +
                    "        body{font-size:14px;font-family:arial,verdana,sans-serif;line-height:1.666;padding:0;margin:0;overflow:auto;white-space:normal;word-wrap:break-word;min-height:100px}\n" +
                    "        td, input, button, select, body{font-family:Helvetica, 'Microsoft Yahei', verdana}\n" +
                    "        pre {white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;white-space:-o-pre-wrap;word-wrap:break-word;width:95%}\n" +
                    "        th,td{font-family:arial,verdana,sans-serif;line-height:1.666}\n" +
                    "        img{ border:0}\n" +
                    "        header,footer,section,aside,article,nav,hgroup,figure,figcaption{display:block}\n" +
                    "        blockquote{margin-right:0px}\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body tabindex=\"0\" role=\"listitem\">\n" +
                    "<table width=\"700\" border=\"0\" align=\"center\" cellspacing=\"0\" style=\"width:700px;\">\n" +
                    "    <tbody>\n" +
                    "    <tr>\n" +
                    "        <td>\n" +
                    "            <div style=\"width:700px;margin:0 auto;border-bottom:1px solid #ccc;margin-bottom:30px;\">\n" +
                    "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"700\" height=\"39\" style=\"font:12px Tahoma, Arial, 宋体;\">\n" +
                    "                    <tbody><tr><td width=\"210\"></td></tr></tbody>\n" +
                    "                </table>\n" +
                    "            </div>\n" +
                    "            <div style=\"width:680px;padding:0 10px;margin:0 auto;\">\n" +
                    "                <div style=\"line-height:1.5;font-size:14px;margin-bottom:25px;color:#4d4d4d;\">\n" +
                    "                    <strong style=\"display:block;margin-bottom:15px;\">尊敬的用户：<span style=\"color:#f60;font-size: 16px;\"></span>您好！</strong>\n" +
                    "                    <strong style=\"display:block;margin-bottom:15px;\">\n" +
                    "                        您正在进行<span style=\"color: red\">"+title+"</span>操作，请在验证码输入框中输入：<span style=\"color:#f60;font-size: 24px\">"+code+"</span>，以完成操作。\n" +
                    "                    </strong>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div style=\"width:700px;margin:0 auto;\">\n" +
                    "                <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                    "                    <p>此为系统邮件，请勿回复<br>\n" +
                    "                        请保管好您的邮箱，避免账号被他人盗用\n" +
                    "                    </p>\n" +
                    "                    <p>Code_Farmer团队</p>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>\n" +
                    "</body>",true);//邮件的内容  true 是代表的html格式生效
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mm);//发送邮件
        System.out.println("发送成功");
    }

}