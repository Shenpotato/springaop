package com.shenpotato.springaop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Shen_potato on 2018/11/26.
 */
@Order(1) //使用order指定切面优先级，值越小优先级越高
@Aspect
@Component
public class ValidateAspect {

    @Before("execution(public int com.shenpotato.springaop.impl.ArithmeticCalculatorImpl.*(..))")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("Validate"+ Arrays.asList(joinPoint.getArgs()));
    }
}
