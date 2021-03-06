package com.shenpotato.springaop.impl;

import javafx.beans.binding.ObjectExpression;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 此AOP类比proxydemo包中的动态代理进行理解
 * Created by Shen_potato on 211/26.
 */
//将这个类声明为切面：需要把该类放入IOC容器中，再声明为切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {

    //重用切面表达式
    //定义一个方法，用于声明切入点表达式，该方法中不添加其他代码，通过@Pointcut注解实现
    //后面的其他通知用方法名实现
    @Pointcut("execution(public int com.shenpotato.springaop.impl.ArithmeticCalculatorImpl.*(..))")
    public void declareLoggingAspectExpression(){
    }

    //声明该方法是一个前置通知：在目标方法开始执行之前
    @Before("declareLoggingAspectExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object>args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins"+args);
    }

    //后置通知：在目标方法执行之后执行（无论方法执行是否异常），都执行
    //在后置通知中不能返回目标方法的结果，要在返回通知中才能访问
    @After("declareLoggingAspectExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends ");
    }



    //返回通知，是在方法正常结束后执行的代码，可以返回返回值
    @AfterReturning(value="declareLoggingAspectExpression()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + "ends with " + result);
    }


    //异常通知，在发生异常时进行的通知
    //并且可以指定在某一异常发生时进行代码执行
    @AfterThrowing(value="declareLoggingAspectExpression()",throwing = "ex")
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
