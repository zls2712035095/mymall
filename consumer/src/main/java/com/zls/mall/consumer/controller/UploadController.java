package com.zls.mall.consumer.controller;

import com.zls.api.common.CommonResult;
import com.zls.api.common.ConstVar;
import com.zls.api.common.UploadFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@CrossOrigin
@Api(tags = "UploadController", description = "公共上传图片管理")
@RestController
@RequestMapping("/upload")
public class UploadController {
    //上传单个与多个文件通用
    @ApiOperation("添加商品相册，品牌logo等照片")
    @PostMapping("/pics")
    @ResponseBody
    public CommonResult upload(String name, HttpServletRequest request){

        if(request instanceof MultipartHttpServletRequest){//是否是上传文件格式
            MultipartHttpServletRequest mulrequest = (MultipartHttpServletRequest)request;
            List<MultipartFile> files = mulrequest.getFiles("file");//前端控件的名字
            Iterator<MultipartFile> iterator = files.iterator();

            while(iterator.hasNext()){
                MultipartFile photo = iterator.next();

                if(photo != null){
                    try {
                        //文件名字
                        String filename = UUID.randomUUID().toString();
                        //上传文件的文件夹
                        File fileDir = UploadFile.getImgDirFile();
                        System.out.println(fileDir.getAbsolutePath());

                        //判断文件后缀
                        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1);//XX.jpg

                        if(ConstVar.IMG_TYPE_JPEG.equals(suffix.toUpperCase()) ||
                            ConstVar.IMG_TYPE_GIF.equals(suffix.toUpperCase()) ||
                            ConstVar.IMG_TYPE_DMG.equals(suffix.toUpperCase()) ||
                            ConstVar.IMG_TYPE_PNG.equals(suffix.toUpperCase()) ||
                            ConstVar.IMG_TYPE_SVG.equals(suffix.toUpperCase()) ||
                            ConstVar.IMG_TYPE_JPG.equals(suffix.toUpperCase())){
                            //构建文件路径
                            File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename + "." + suffix);
                            //上传到指定路径
                            photo.transferTo(newFile);
                            Map<String, String> result = new HashMap<>(16);

                            result.put("contentType", photo.getContentType());
                            result.put("suffix", suffix);
                            result.put("fileName", filename);
                            result.put("fileSize", photo.getSize() + "");
                            result.put("nav", ConstVar.SHOW_IMAGE_PATH + File.separator + filename + "." +suffix);
                            return CommonResult.success(result);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return CommonResult.failed("上传文件失败，类型不匹配");
                }
            }
        }
        return CommonResult.failed("上传文件失败");
    }
}
