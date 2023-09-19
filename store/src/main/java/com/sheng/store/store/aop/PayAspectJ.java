package com.sheng.store.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PayAspectJ {

//    @DeclareParents(value = "com.sheng.store.store.aop.WechatPay", defaultImpl = WechatPayEnhance.class)
//    public IPayEnhance wechatPayEnhance;

//    @DeclareParents(value = "com.sheng.store.store.aop.WechatPay", defaultImpl = ZhiFuBaoPayEnhance.class)
//    public IPayEnhance zhiFuBaoPayEnhance;


    @Pointcut("execution(* com.sheng.store.store.aop.IPay.*(..))")
    public void iPayPointcut() {
    }

    @Around("iPayPointcut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("before...");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            //
        }
        System.out.println("after...");
    }

}
