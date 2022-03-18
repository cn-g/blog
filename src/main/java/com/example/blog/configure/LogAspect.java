package com.example.blog.configure;

import com.alibaba.fastjson.JSON;
import com.gcp.basicproject.response.CommonException;
import com.gcp.basicproject.response.ResponseCode;
import com.gcp.basicproject.util.ParamUtil;
import com.gcp.basicproject.util.RedisUtil;
import com.gcp.basicproject.util.RequestUtil;
import com.gcp.basicproject.util.ToolsUtil;
import com.google.common.collect.Lists;
import lombok.Synchronized;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * 打印接口调用日志
 * @author Admin
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private static List<String > noToken;

    @Resource
    RedisUtil redisUtil;

    @Pointcut("execution(* com.example.blog.controller.*.*.*(..))")
    @Synchronized
    public void controllerMethod(){}

    @Before("controllerMethod()")
    public void logRequestInfo(JoinPoint joinPoint){
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttribute).getRequest();
        // 打印请求内容
        log.info("----------------------------------------------------------接口调用发起----------------------------------------------------------");
        log.info("接收到请求，请求方式={},请求地址={},请求IP={},请求方法名称={},请求参数={}",request.getMethod(),request.getRequestURL().toString(),
                ToolsUtil.getServerIp(),joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        //添加需要过滤的接口
        List<String > noToken = Lists.newArrayList();
        noToken.add("addUser");
        noToken.add("queryUserPage");
        //过滤接口
//        if(!ParamUtil.equals(joinPoint.getSignature().getName(),noToken)){
//            //接口之前,权限校验
//            String key = "cache_token_"+ RequestUtil.getUserId();
//            if(ParamUtil.empty(redisUtil.get(key))){
//                log.info("接口调用失败:返回结果=" + ResponseCode.NoAuthor.toString());
//                log.info("----------------------------------------------------------接口调用结束----------------------------------------------------------");
//                throw new CommonException(ResponseCode.NoAuthor.getMessage(),ResponseCode.NoAuthor.getMessage_en(),ResponseCode.NoAuthor.getErrorCode());
//            }
//            if(!Objects.equals(RequestUtil.getToken(), redisUtil.get(key))){
//                log.info("接口调用失败:返回结果=" + ResponseCode.NOPOWER.toString());
//                log.info("----------------------------------------------------------接口调用结束----------------------------------------------------------");
//                throw new CommonException(ResponseCode.NOPOWER.getMessage(),ResponseCode.NOPOWER.getMessage_en(),ResponseCode.NOPOWER.getErrorCode());
//            }
//            //刷新token存活时间
//            redisUtil.expire(key,4*60*60);
//        }
    }

    /**
     * 进入方法请求执行后
     * @param o
     * @throws Exception
     */
    @AfterReturning(returning = "o", pointcut = "controllerMethod()")
    public void logResultInfo(Object o){
        log.info("接口调用成功:返回结果=" + JSON.toJSONString(o));
        log.info("----------------------------------------------------------接口调用结束----------------------------------------------------------");
    }

    /**
     * 该切面发生异常信息时进行拦截
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerMethod()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("接口调用失败，连接点方法为：" + methodName + ",参数为：" + args + ",异常为：" + e);
        log.info("----------------------------------------------------------接口调用结束----------------------------------------------------------");
    }

}
