package com.shenpotato.springaop.proxydemo;

/**
 * Created by Shen_potato on 2018/11/24.
 */
public class Main {
    public static void main(String[] args) {

        //不用动态代理模式，将业务代码与日志代码整合在ArithmeticCalculatorLoggingImpl中
        ArithmeticCalculator arithmeticCalculator = null;
        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();

        int result1 = arithmeticCalculator.add(1,2);
        System.out.println("-->"+result1);

        result1 = arithmeticCalculator.div(4,2);
        System.out.println("-->"+result1);

        //使用动态代理模式，封装ArithmeticCalculatorImpl;
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        int result = proxy.add(1,2);
        System.out.println("-->"+result);

        result = proxy.div(4,2);
        System.out.println("-->"+result);

    }


}
