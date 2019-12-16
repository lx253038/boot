package com.mybatis.boot.aspect;

import com.mybatis.boot.annotation.SysLog;
import com.mybatis.boot.model.SystemLog;
import com.mybatis.boot.service.SystemLogService;
import com.mybatis.boot.util.IpUtils;
import com.mybatis.boot.util.RequestHolder;
import com.wf.captcha.ChineseCaptcha;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author LX
 * @Date 2019/12/12 14:02
 * @Description 系统日志切面
 */
@Aspect
@Component
public class SysLogAspect {

    private final SystemLogService systemLogService;

    public SysLogAspect(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    /**
     * 注解形式切点
     */
    @Pointcut("@annotation(com.mybatis.boot.annotation.SysLog)")
    private void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        //System.out.println("前置通知：" + joinPoint.getSignature().getName() + " \t" + Arrays.asList(joinPoint.getArgs()));
        try {
            result = joinPoint.proceed(); //调用目标方法
            //System.out.println("后置通知：" + joinPoint.getSignature().getName() + " \t 结果：" + result);

        } catch (Throwable throwable) {
            //System.out.println("异常通知：" + joinPoint.getSignature().getName() + " \t" + Arrays.asList(joinPoint.getArgs()));
            throwable.printStackTrace();
        }
        long time = System.currentTimeMillis() - beginTime;
        //System.out.println("返回通知：" + joinPoint.getSignature().getName() + " \t" + Arrays.asList(joinPoint.getArgs()));
        //方法执行完后记录操作日志
        saveSysLog(joinPoint, time);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        SystemLog systemLog = new SystemLog();
        systemLog.setUserName(new ChineseCaptcha().text());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog log = method.getAnnotation(SysLog.class);
        if (log != null) {
            systemLog.setOperation(log.value());
        }
        systemLog.setTime(time);

        systemLog.setMethod(joinPoint.getTarget().getClass().getName() + "." + method.getName() + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof BeanPropertyBindingResult) {
                    BindingResult bindingResult = (BeanPropertyBindingResult) args[i];
                    params += " {" + paramNames[i] + ": " + bindingResult.getFieldErrors() + "}";

                } else {
                    params += " {" + paramNames[i] + ": " + args[i] + "}";

                }
            }
            systemLog.setParams(params);
        }


        HttpServletRequest httpServletRequest = RequestHolder.getHttpServletRequest();
        if (httpServletRequest != null) {
            systemLog.setIp(IpUtils.getIp(httpServletRequest));
        }else{
            systemLog.setIp("0.0.0.0");

        }

        systemLog.setCreateTime(new Date());

        systemLogService.save(systemLog);
    }
}
