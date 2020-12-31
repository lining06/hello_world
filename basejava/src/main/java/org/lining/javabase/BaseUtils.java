package org.lining.javabase;

import org.junit.gen5.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseUtils {


    /**
     * 判断字符串是否合法
     */
    public static boolean isStringLegal(String str){
        if (StringUtils.isBlank(str)){
            return false;
        }
        // 拦截特殊字符
        String regEx="^[\\u4E00-\\u9FA5a-zA-Z0-9]+$";
        return str.matches(regEx);
    }

    /**
     * 判断字符串包含表情
     * @param value
     * @return
     */
    public static boolean containsEmoji(String value){
        boolean flag = false;
        try {
            Pattern p = Pattern
                    .compile("[^\\u0000-\\uFFFF]");
            Matcher m = p.matcher(value);
            flag = m.find();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
