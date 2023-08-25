package com.zls.api.common;

import org.springframework.util.ClassUtils;

import java.io.File;


public class UploadFile {
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    //E:\\DOC\\java\\MALL\\mymall\\mall-consumer\\target\\classes\\static\\upload目录必须存在 上传图片用
    public final static String IMG_PATH_PREFIX = "static/upload/images/";

    public static File getImgDirFile(){
//        ClassLoader c=ClassUtils.getDefaultClassLoader();
//        URL u=c.getResource(IMG_PATH_PREFIX);

       // String rootDirectory=System.getProperty("user.dir");

        //String fileDirPath= rootDirectory+"\\"+IMG_PATH_PREFIX;//放在class目录不要放在源程序下 否则得重启服务器加载
        //ClassLoader c=ClassUtils.getDefaultClassLoader();
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();


        String fileDirPath=path+IMG_PATH_PREFIX;
        System.out.println(fileDirPath);
        // 构建上传文件的存放 "文件夹" 路径


        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
