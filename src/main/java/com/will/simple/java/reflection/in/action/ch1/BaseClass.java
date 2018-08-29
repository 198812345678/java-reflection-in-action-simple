package com.will.simple.java.reflection.in.action.ch1;

public class BaseClass {

    public void printName() {
        System.out.println("======");
        System.out.println(this.getClass().getName());
        System.out.println("======");
    }
}
