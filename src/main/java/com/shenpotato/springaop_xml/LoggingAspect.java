package com.shenpotato.springaop_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 此AOP类比proxydemo包中的动态代理进行理解
 * Created by Shen_potato on 211/26.
 */

public class LoggingAspect {

    public LoggingAspect(){}

    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object>args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins"+args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends ");
    }

    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + "ends with " + result);
    }

    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + "ocurrs exception with " + ex);
    }

    /*
    * aroundMethod模拟动态代理的过程,必须携带ProceedingJointPoint参数
    * 必须有返回值，返回值即为目标方法的返回值
    * */
/*
    @Around(value="execution(public int com.shenpotato.springaop.impl.ArithmeticCalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result=0;
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("The method " + methodName + " ocurrs with " + throwable);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends ");
        return result;
    }
*/


}
