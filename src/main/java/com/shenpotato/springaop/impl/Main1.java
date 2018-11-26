package com.shenpotato.springaop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Shen_potato on 2018/11/26.
 */
public class Main1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ArithmeticCalculatorImpl arithmeticCalculatorImpl = (ArithmeticCalculatorImpl) applicationContext.getBean("arithmeticCalculatorImpl");

        int result = arithmeticCalculatorImpl.add(3,6);
        System.out.println(result);

        result =  arithmeticCalculatorImpl.div(4,2);
        System.out.println(result);

        result = arithmeticCalculatorImpl.addd(1,2,3);
        System.out.println(result);

    }
}
