package com.zls.mall.consumer.aop;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zls.mall.api.annotation.UserLoginToken;
import com.zls.mall.api.model.UmsAdmin;
import com.zls.mall.api.service.ITokenService;
import com.zls.mall.api.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IUserService",
            interfaceClass = IUserService.class,
            timeout = 1200000
    )
    private IUserService userService;

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.ITokenService",
            interfaceClass = ITokenService.class,
            timeout = 1200000
    )
    private ITokenService tokenService;

    @Override//前置增强
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String token=request.getHeader("Authorization");//从http头部取出token
        //判断该方法是否经过了token注解的修饰 如果不是映射的token注解进行修饰
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //是经过了修饰
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        //判断是否经过了UserLoginToken注解的修饰
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken=method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){//判断是否使用了其属性 required 为true
                //执行认证
                if(token==null){
                    throw new RuntimeException("无token，请重新登录！");

                }
                token=token.split("@")[1];

                UmsAdmin admin=userService.findByAdmin(token);
                if(admin==null){
                    throw new RuntimeException("用户没有登录，请重新登录！");
                }
                //验证token
                if(tokenService.checkToken(token,admin.getPassword())){
                    return true;
                }else{
                    throw new RuntimeException("token验证失败！");
                }
            }
        }

        return true;
    }

    @Override//执行阶段
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//执行完毕
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after");
    }
}
