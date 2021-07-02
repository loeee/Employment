package com.just.emp.conv;

/**
 * author ： 张俊飞
 */
public class Stringconversion {
    public String rep(String ostr){
        String nstr = null;
        if(ostr!=null&&ostr.indexOf("\n")!=-1){
            if(ostr.indexOf("\r\n")!=-1){
                nstr = ostr.replace("\r\n","<br/>");

            }else{
                nstr = ostr.replace("\n","<br/>");

            }
        }else {
            nstr = ostr;
        }
        return nstr;
    }
    public String nrep(String nrep){
        String nstr = null;
        if(nrep!=null&&nrep.indexOf("<br/>")!=-1){
            nstr = nrep.replace("<br/>", "\r\n");
        }else {
            nstr = nrep;
        }

        return nstr;
    }
}
