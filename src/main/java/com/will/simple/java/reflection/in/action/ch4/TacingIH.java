package com.will.simple.java.reflection.in.action.ch4;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TacingIH implements InvocationHandler {

    private Object target;
    private PrintWriter writer;

    public TacingIH(Object target, PrintWriter writer) {
        this.target = target;
        this.writer = writer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        writer.println(method.getName() + "(...) called");
        Object invoke = method.invoke(target, args);
        writer.println(method.getName() + " returns");
        return invoke;
    }
}
