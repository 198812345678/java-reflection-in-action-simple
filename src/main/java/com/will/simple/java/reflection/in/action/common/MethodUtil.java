package com.will.simple.java.reflection.in.action.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodUtil {

    public static void invokeStaticMethod(Class clazz, String methodName, Class[] paramClazz, Object[] params) {
        Method method = null;
        try {
            method = clazz.getMethod(methodName, paramClazz);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            method.invoke(null, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
