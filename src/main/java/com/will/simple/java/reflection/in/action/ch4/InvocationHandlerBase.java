package com.will.simple.java.reflection.in.action.ch4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public abstract class InvocationHandlerBase implements InvocationHandler {

    protected Object nextTarget;
    protected Object realTarget;

    public InvocationHandlerBase(Object target) throws NoSuchFieldException, IllegalAccessException {
        nextTarget = target;
        if (nextTarget != null) {
            realTarget = findRealTarget(nextTarget);
            if (realTarget == null) {
                throw new RuntimeException("findRealTarget failure");
            }
        }
    }

    protected Object getRealTarget() {
        return realTarget;
    }

    protected static Object findRealTarget(Object t) throws NoSuchFieldException, IllegalAccessException {
        if (!Proxy.isProxyClass(t.getClass())) {
            return t;
        }

        InvocationHandler invocationHandler = Proxy.getInvocationHandler(t);
        if (invocationHandler instanceof InvocationHandlerBase) {
            return ((InvocationHandlerBase)invocationHandler).getRealTarget();
        }

        Field target = invocationHandler.getClass().getDeclaredField("target");
        target.setAccessible(true);
        Object innerTarget = target.get(invocationHandler);
        return findRealTarget(innerTarget);
    }
}
