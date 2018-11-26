package com.shenpotato.springaop.proxydemo;

/**
 * Created by Shen_potato on 2018/11/24.
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator{
    @Override
    public int add(int i, int j) {
        System.out.println("The method add begins with["+i+","+j+"]");
        int result = i + j;
        System.out.println("The method add ends with"+result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The method sub begins with["+i+","+j+"]");
        int result = i - j;
        System.out.println("The method sub ends with"+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("The method mul begins with["+i+","+j+"]");
        int result = i * j;
        System.out.println("The method muls ends with"+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("The method div begins with["+i+","+j+"]");
        int result = i / j;
        System.out.println("The method div ends with"+result);
        return result;
    }
}
