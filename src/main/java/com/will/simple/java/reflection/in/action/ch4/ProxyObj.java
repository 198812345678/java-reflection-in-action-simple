package com.will.simple.java.reflection.in.action.ch4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObj {

    /**
     * toString方法像其他普通发放一样
     * @param targetObj
     * @param <T>
     */
    public static <T> void printToString(final T targetObj) throws InvocationTargetException, IllegalAccessException {
        Class<?> objClass = targetObj.getClass();
        Class<?>[] interfaces = objClass.getInterfaces();
        Object proxyInstance = getProxy(targetObj, objClass, interfaces);
        System.out.println(proxyInstance.toString());
    }

    public static void clone(CloneTargetObj targetObj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> objClass = targetObj.getClass();
        Class<?>[] interfaces = objClass.getInterfaces();
        Object proxyInstance = getProxy(targetObj, objClass, interfaces);
        //proxyInstance.clone() 可以用idea模拟执行，如果CloneTarget继承了cloneable，则可以调用到CloneTargetObj的clone方法，不过还是protected，这里不能调用
        //如果CloneTarget没有继承cloneable，proxyInstance.clone()是调用代理对象的方法，是继承自Object对象，会抛异常
        System.out.println();
    }

    private static <T> Object getProxy(final T targetObj, Class<?> objClass, Class<?>[] interfaces) throws IllegalAccessException, InvocationTargetException {
        return Proxy.newProxyInstance(objClass.getClassLoader(), interfaces, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object invoke = method.invoke(targetObj, args);
                    System.out.println("proxy invoke end");
                    return invoke;
                }
            });
    }
}
