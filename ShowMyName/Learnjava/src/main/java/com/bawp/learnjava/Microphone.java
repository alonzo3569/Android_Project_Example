package com.bawp.learnjava;

import java.math.BigInteger;

public class Microphone {
    private Object obj = new Object().toString();
    private int a ;
    private BigInteger num = new BigInteger("-10");


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Microphone() {
        System.out.println("This is " + num.abs());
    }


}
