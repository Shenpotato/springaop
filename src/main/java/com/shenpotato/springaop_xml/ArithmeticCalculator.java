package com.shenpotato.springaop_xml;

import org.springframework.stereotype.Component;

/**
 * Created by Shen_potato on 2018/11/23.
 */
@Component
public interface ArithmeticCalculator {
    int add(int i, int j);

    int sub(int i, int j);

    int mul(int i, int j);

    int div(int i, int j);

    int addd(int i, int j, int o);

}
