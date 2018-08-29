package com.will.simple.java.reflection.in.action.ch1;

public class Component2 {

    public void setColor(Color color) {
        System.out.println(this.getClass().getSimpleName() + ".setColor");
    }
}
