package com.shenpotato.springaop.impl;

import com.shenpotato.springaop.proxydemo.ArithmeticCalculator;
import org.springframework.stereotype.Component;

/**
 * Created by Shen_potato on 2018/11/23.
 */
@Component("arithmeticCalculatorImpl")
public class ArithmeticCalculatorImpl implements com.shenpotato.springaop.impl.ArithmeticCalculator{
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override

    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }

    @Override
    public int addd(int i, int j,int o) {
        int result = i+j+o;
        return result;
    }



}
