package com.shenpotato;

/**
 * Created by Shen_potato on 2018/11/30.
 */
public class AppSon extends  App {
    public int c;
    public AppSon(int a, int b,int c) {
        super(a, b);
        this.c=c;
    }

    @Override
    void function1() {
        super.function1();
        System.out.println("sonApp");
    }
}
