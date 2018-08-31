package com.will.simple.java.reflection.in.action.ch1;

public class Component1 extends BaseComponent{

    public void setColor(Color color) {
        System.out.println(this.getClass().getSimpleName() + ".setColor");
    }
}
