package com.will.simple.java.reflection.in.action.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodUtil {

    /**
     * static方法，invoke的第一个参数是null
     * @param clazz
     * @param methodName
     * @param paramClazz
     * @param params
     */
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

    /**
     * 返回值是void的方法，invoke的返回值不用特殊处理
     * @param target
     * @param methodName
     * @param paramClazz
     * @param params
     * @return
     * @throws Exception
     */
    public static Object invokeVoidMethod(Object target, String methodName, Class[] paramClazz, Object[] params) throws Exception {
        Class<?> clazz = target.getClass();
        Method method = null;
        try {
            method = clazz.getMethod(methodName, paramClazz);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Object invoke;
        try {
            return method.invoke(target, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new Exception("fdfd");
    }
}
