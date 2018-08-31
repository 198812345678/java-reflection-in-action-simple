package com.will.simple.java.reflection.in.action.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MetaObjUtil {

    public static Method[] getDeclaredMethods(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        return declaredMethods;
    }

    public static Object invokeNoneParam(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Object result = null;
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 0) {
                try {
                    result = method.invoke(obj, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
