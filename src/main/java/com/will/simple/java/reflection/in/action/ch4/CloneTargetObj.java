package com.will.simple.java.reflection.in.action.ch4;

public class CloneTargetObj implements CloneTarget {
    @Override
    public Object clone() {
        System.out.println("com.will.simple.java.reflection.in.action.ch4.CloneTargetObj.clone");
        return new CloneTargetObj();
    }
}
