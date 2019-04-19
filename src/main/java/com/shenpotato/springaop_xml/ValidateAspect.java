package com.shenpotato.springaop_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Shen_potato on 2018/11/26.
 */

public class ValidateAspect {
    public  ValidateAspect(){}
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("Validate"+ Arrays.asList(joinPoint.getArgs()));
    }
}
