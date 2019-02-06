package com.shenpotato.springaop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Shen_potato on 211/26.
 */
//将这个类声明为切面：需要把该类放入IOC容器中，再声明为切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    //声明该方法是一个前置通知：在目标方法开始执行之前
    @Before("execution(public int com.shenpotato.springaop.impl.ArithmeticCalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object>args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins"+args);
    }

    //后置通知：在目标方法执行之后执行（无论方法执行是否异常），都执行
    //在后置通知中不能返回目标方法的结果，要在返回通知中才能访问
    @After("execution(public int com.shenpotato.springaop.impl.ArithmeticCalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends ");
    }
}
