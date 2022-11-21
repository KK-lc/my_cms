package com.article.manager.common;

public class StringUtil {
    private  StringUtil(){

    }
    public static  boolean isEmpty(String str){
        /*if (str == null || "".equals(str)){
            return true;
        }
        return false;*/
        return str==null || "".equals(str.trim());
    }
}
