package com.will.simple.java.reflection.in.action.ch5;

public class StackTraceSolution {

    public static StackTraceElement[] getStackTraceEle() {
        StackTraceElement[] stackTraceElement = null;
        try {
            throw new Exception("");
        } catch (Exception e) {
            stackTraceElement = e.getStackTrace();
        }
        return stackTraceElement;
    }

    public static StackTraceElement[] getThreadStackTraceEle() {
        return Thread.currentThread().getStackTrace();
    }
}
