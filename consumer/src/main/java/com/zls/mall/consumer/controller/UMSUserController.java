package com.zls.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baidu.aip.face.AipFace;
import com.zls.api.common.AIFactoryUtil;
import com.zls.api.common.CommonResult;
import com.zls.mall.api.annotation.LogType;
import com.zls.mall.api.annotation.SystemLog;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.dto.AIBaiduFaceBean;
import com.zls.mall.api.dto.AIFaceBean;
import com.zls.mall.api.dto.UmsAdminLoginParam;
import com.zls.mall.api.model.UmsAdmin;
import com.zls.mall.api.service.ITokenService;
import com.zls.mall.api.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
@CrossOrigin//跨端口或域名访问
@Api(tags = "UMSUserController", description = "后台用户管理")
public class UMSUserController {


    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IUserService",
            interfaceClass = IUserService.class,
            timeout = 1200000
    )
    private IUserService service;

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.ITokenService",
            interfaceClass = ITokenService.class,
            timeout = 1200000
    )
    private ITokenService tokenservice;

    private AipFace aipFace = AIFactoryUtil.getAipFace();
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    @ResponseBody
    @SystemLog(description = "登录",type= LogType.USER_LOGIN)
    public CommonResult login(@RequestBody UmsAdminLoginParam user){
        UmsAdmin admin = service.findByUsername(user.getUsername());

        if(admin == null){
            return CommonResult.validateFailed("用户名不存在");
        }else{
            if(!admin.getPassword().equals(user.getPassword())){
                Map<String, String> map = new HashMap<>();
                map.put("error_code", "500");
                return CommonResult.failed(map);
            }else{
                String token = tokenservice.getToken(admin.getId().toString(), admin.getPassword());
                Map<String, String> map = new HashMap<>();
                map.put("error_code", "200");
                map.put("token", token);
                map.put("tokenHead", tokenHead);
                return CommonResult.success(map);
            }
        }
    }

    @ApiOperation("注册")
    @PostMapping("/reg")
    @ResponseBody
    @SystemLog(description = "注册新用户", type = LogType.USER_REG)
    public CommonResult reg(@RequestBody UmsAdmin admin){
        if(service.findByUsername(admin.getUsername())!=null){
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("error_code", "500");
            return CommonResult.failed(tokenMap);
        }
        String groupId = "login";
        UmsAdmin umsAdmin;
        umsAdmin = service.reg(admin);
        String userId = umsAdmin.getId().toString();
        HashMap<String, String> options = new HashMap<>();
        options.put("user_info", admin.getPassword());
        //data:image/png:base64,
        String b64 = admin.getPic().substring(22);

        JSONObject resultobject = aipFace.addUser(b64, "BASE64", groupId, userId, options);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("error_code", "200");
        return CommonResult.success(tokenMap);
    }
    @GetMapping("/info")
    @ApiOperation("获取当前登录用户信息主界面")
    @ResponseBody
    @UserLoginToken
    @SystemLog(description = "登录成功主界面", type = LogType.USER_INFO)
    public CommonResult getAdminInfo(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        UmsAdmin admin = service.findByAdmin(token.split("@")[1]);

        Map<String, Object>map = new HashMap<>();
        map.put("username", admin.getUsername());
        map.put("roles", new String[]{"TEST"});
        map.put("icon", admin.getIcon());
        return CommonResult.success(map);
    }

    @PostMapping("/logout")//@RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation("登出功能")
    @ResponseBody
    @UserLoginToken
    @SystemLog(description = "登出", type = LogType.USER_LOGIN_OUT)
    public CommonResult logout(HttpServletRequest request){
        return CommonResult.success(null);
    }

    @PostMapping("/flogin")
    @ApiOperation("脸部登录以后返回token")
    @ResponseBody
    @SystemLog(description = "人脸登录", type = LogType.USER_LOGIN)
    public CommonResult flogin (@RequestBody AIFaceBean faceBean){
        Map<String, String> tokenMap = new HashMap<>();
        //部分人脸信息
        //设定百度人脸识别用户组
        String groupList = "login";
        JSONObject resultObject = aipFace.search(faceBean.getImgdata(), "BASE64", groupList, null);

        AIBaiduFaceBean faceSearchResponse = JSON.parseObject(resultObject.toString(), AIBaiduFaceBean.class);

        if(faceSearchResponse.getError_code().equals("0") && faceSearchResponse.getError_msg().equals("SUCCESS")){
            //score大于80，代表是同一个人
            if(faceSearchResponse.getResult().getUser_list().get(0).getScore() > 80f){
                faceBean.setError_code(faceSearchResponse.getError_code());
                faceBean.setError_msg(faceSearchResponse.getError_msg());
                //用来作为图片的唯一索引
                String userId = faceSearchResponse.getResult().getUser_list().get(0).getUser_id();
                UmsAdmin admin = service.findById(Long.parseLong(userId));

                String password = admin.getPassword();
                String username = admin.getUsername();
                //生成token
                String token = tokenservice.getToken(userId, password);

                tokenMap.put("error_code", faceBean.getError_code());
                tokenMap.put("token", token);
                tokenMap.put("tokenHead", tokenHead);
                tokenMap.put("username", username);
                tokenMap.put("password", password);
                return CommonResult.success(tokenMap);
            }
        }

        tokenMap.put("error_code", faceBean.getError_code());
        return CommonResult.failed(tokenMap);
    }
}
