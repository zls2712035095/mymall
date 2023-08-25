package com.zls.api.common;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公用常量
 */
public class ConstVar {
    public static final String SHOW_IMAGE_PATH="http://localhost:8080/static/upload/images/";
    public static final String SHOW_BRAND_IMAGE_PATH="http://localhost:8080/static/upload/images/brand/";//品牌
    public static final String SHOW_PRODUCT_IMAGE_PATH="http://localhost:8080/static/upload/images/pics/";//产品的商品相册

    public static String IMG_TYPE_PNG = "PNG";
    public static String IMG_TYPE_JPG = "JPG";
    public static String IMG_TYPE_JPEG = "JPEG";
    public static String IMG_TYPE_DMG = "BMP";
    public static String IMG_TYPE_GIF = "GIF";
    public static String IMG_TYPE_SVG = "SVG";


    public static String  isURL(String txt){
//        boolean isurl = false;
//        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
//                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式


        String regex="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(txt);
        boolean isMatch = matcher.matches();
        if(isMatch){
            try {

                URL url = new URL(txt.trim());
                String s=url.getFile();//s含目录
                File file=new File(s);

                return file.getName();//返回文件名字部分

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else{
            return txt;
        }


      //  Pattern pat = Pattern.compile(regex.trim());//对比
        //if(txt.matches(regex))
        {//合法 取出文件部分

        }
//        else{
//            return txt;//不是合法 返回自己
//        }
        return "";

    }

}
