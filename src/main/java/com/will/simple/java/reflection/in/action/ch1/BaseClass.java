package com.will.simple.java.reflection.in.action.ch1;

public class BaseClass {

    public static int i;

    public void printName() {
        System.out.println("======");
        System.out.println(this.getClass().getName());
        System.out.println("======");
    }

    public Integer getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private void privMethod() {

    }

    protected void protMethod() {

    }

    public static void staticMethod() {
        System.out.println("invoke BaseClass's staticMethod");
    }
}
