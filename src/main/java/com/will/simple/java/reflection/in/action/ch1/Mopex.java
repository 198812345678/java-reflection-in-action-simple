package com.will.simple.java.reflection.in.action.ch1;

import java.lang.reflect.Method;

public class Mopex {

    /**
     * 递归的查找继承关系链上的方法
     */
    public static Method getSupportedMethod(Class clazz, String methodName, Class[] params) throws NoSuchMethodException {
        if (clazz == null) {
            throw new NoSuchMethodException();
        }

        Method declaredMethod = null;
        try {
            declaredMethod = clazz.getDeclaredMethod(methodName, params);
        } catch (NoSuchMethodException e) {
            return getSupportedMethod(clazz.getSuperclass(), methodName, params);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        if (declaredMethod == null) {
            return getSupportedMethod(clazz.getSuperclass(), methodName, params);
        }

        return declaredMethod;
    }
}
