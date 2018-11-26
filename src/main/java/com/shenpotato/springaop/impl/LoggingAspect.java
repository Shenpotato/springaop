package com.shenpotato.springaop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Shen_potato on 2018/11/26.
 */
//将这个类声明为切面：需要把该类放入IOC容器中，再声明为切面
@Aspect
@Component
public class LoggingAspect {
    //声明该方法是一个前置通知：在目标方法开始执行之前
    @Before("execution(public int com.shenpotato.springaop.impl.ArithmeticCalculatorImpl.*())")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object>args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins"+args);
    }
}
