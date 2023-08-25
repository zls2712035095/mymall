package com.zls.mall.consumer.aop;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.sun.corba.se.spi.ior.ObjectKey;
import com.zls.api.common.IpInfoUtil;
import com.zls.api.common.ThreadPoolUtil;
import com.zls.mall.api.annotation.SystemLog;
import com.zls.mall.api.model.UmsAdmin;
import com.zls.mall.api.model.UmsLog;
import com.zls.mall.api.service.ITokenService;
import com.zls.mall.api.service.IUserLogService;
import com.zls.mall.api.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Aspect
@Component
@Slf4j
public class SystemLogAspect implements HandlerInterceptor {

    private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<>("ThreadLocal BeginTime");

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

    @Reference(
            version = "1.0.0",
            interfaceName = "com.zls.mall.api.service.IUserLogService",
            interfaceClass = IUserLogService.class,
            timeout = 1200000
    )
    private IUserLogService logService;
    @Pointcut("@annotation(com.zls.mall.api.annotation.SystemLog)")
    public void controllerAspect(){
        System.out.println("植入了我的日志代码");
    }

    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint){
        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);
    }

    @AfterReturning("controllerAspect()")
    public void after(JoinPoint joinPoint){
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            String token = request.getHeader("Authorization");
            if(token == null){
                throw new RuntimeException("无token, 请重新登录！");
            }

            token = token.split("@")[1];
            UmsAdmin admin = userService.findByAdmin(token);

            if(admin == null){
                throw new RuntimeException("用户不存在,请重新登录！");
            }
            //验证token
            if(!tokenService.checkToken(token, admin.getPassword())){
                throw new RuntimeException("token验证失败！");
            }

            //存储日志
            //模拟多个用户ID
            final Random random = new Random();
            int userid = random.nextInt(100);
            UmsLog log = new UmsLog();
            log.setUserid(userid);

            String description = getControllerMethodInfo(joinPoint).get("description").toString();
            Integer type = Integer.parseInt(getControllerMethodInfo(joinPoint).get("type").toString());

            //日志标题
            log.setName(description);
            log.setLogType(type);
            //日志url
            log.setRequestUrl(request.getRequestURI());
            //请求方法
            log.setRequestType(request.getMethod());
            Map<String, String[]> requestParams = request.getParameterMap();
            //请求参数
            String str = (JSON.toJSONString(requestParams).replace(",", "&&"));

            //前端的双引变成单引，以json格式能够存储到数据库中
            log.setRequestParam(str.replace("\"", "\'"));
            //IP地址
            log.setIp(IpInfoUtil.getIpAddr(request));

            log.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            log.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

            //请求开始时间
            long beginTime = beginTimeThreadLocal.get().getTime();
            long endTime = System.currentTimeMillis();

            //请求耗时
            Long costTime = endTime - beginTime;
            log.setCostTime(costTime.intValue());

            //多线程存储日志数据
            ThreadPoolUtil.getPool().execute(new SaveSystemLogThread(log, logService));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String, Object> getControllerMethodInfo(JoinPoint joinPoint) throws Exception{
        Map<String, Object> map = new HashMap<>(16);
        //目标类name
        String targetName = joinPoint.getTarget().getClass().getName();
        //方法name
        String methodName = joinPoint.getSignature().getName();
        //方法参数
        Object[] args = joinPoint.getArgs();
        //生成类的对象
        Class targetClass = Class.forName(targetName);
        //获取所有方法
        Method[] methods = targetClass.getMethods();
        String description = "";
        Integer type = null;

        for (Method method: methods){
            if(!method.getName().equals(methodName)){
                continue;
            }
            Class[] clazz = method.getParameterTypes();
            if(clazz.length != args.length){
                continue;
            }
            description = method.getAnnotation(SystemLog.class).description();
            type = method.getAnnotation(SystemLog.class).type().ordinal();//取出枚举元素在枚举类中的索引序号

            map.put("description", description);
            map.put("type", type);
        }
        return map;
    }
}
