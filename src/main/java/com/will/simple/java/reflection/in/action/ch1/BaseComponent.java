package com.will.simple.java.reflection.in.action.ch1;

public class BaseComponent {

    public void setColorBase(Color color) {
        System.out.println(this.getClass().getSimpleName() + ".setColorBase");
    }
}
