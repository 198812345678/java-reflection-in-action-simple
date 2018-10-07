package com.will.simple.java.reflection.in.action.ch4;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SynchronizedIH extends InvocationHandlerBase {

    public static Object createProxy(Object object) throws NoSuchFieldException, IllegalAccessException {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new SynchronizedIH(object));
    }

    public SynchronizedIH(Object target) throws NoSuchFieldException, IllegalAccessException {
        super(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        synchronized (this.getRealTarget()) {
            return method.invoke(nextTarget, args);
        }
    }
}
