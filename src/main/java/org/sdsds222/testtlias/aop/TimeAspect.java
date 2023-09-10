package org.sdsds222.testtlias.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect//AOP类
public class TimeAspect {

    //抽取切入点表达式，可复用，pubiic可在外部切面类中使用，private只能在当前切面类中使用
//    @Pointcut("execution(* org.sdsds222.testtlias.service.*.*(..))")
//    public void pt() {
//    }
//
//
//    @Around("pt()")//定义当前逻辑要加在哪些方法上,execution中填写切入点表达式
//    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        //记录开始时间
//        long begin = System.currentTimeMillis();
//        //调用原始方法
//        Object result = joinPoint.proceed();
//        //记录结束时间
//        long end = System.currentTimeMillis();
//        log.info(joinPoint.getSignature() + "方法执行耗时：{}毫秒", end - begin);
//        //返回执行原始方法的返回值
//        return result;
//    }


    @Around("@annotation(org.sdsds222.testtlias.aop.TimeLog)")
    public Object recordTime2(ProceedingJoinPoint joinPoint) throws Throwable {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //调用原始方法
        Object result = joinPoint.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();
        log.info("切入{}方法", joinPoint.getSignature() );
        log.info("方法执行耗时：{}毫秒", end - begin);
        //返回执行原始方法的返回值
        return result;
    }

}
