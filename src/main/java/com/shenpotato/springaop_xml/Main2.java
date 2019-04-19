package com.shenpotato.springaop_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Shen_potato on 2018/11/26.
 */
public class Main2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_xml.xml");

        ArithmeticCalculatorImpl arithmeticCalculatorImpl = (ArithmeticCalculatorImpl) applicationContext.getBean("arithmeticCalculatorImpl");

        int result = arithmeticCalculatorImpl.add(3,6);
        System.out.println(result);

        result =  arithmeticCalculatorImpl.div(4,0);
        System.out.println(result);

    }
}
