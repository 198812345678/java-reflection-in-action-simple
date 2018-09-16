package com.will.simple.java.reflection.in.action.ch1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

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

    public static Field[] getInstanceVariables(Class cls) {
        List accum = new LinkedList();
        while (cls != null) {
            Field[] fields = cls.getDeclaredFields();
            for (int i=0; i<fields.length; i++) {
                if (!Modifier.isStatic(fields[i].getModifiers())) {
                    accum.add(fields[i]);
                }
            }
            cls = cls.getSuperclass();
        }
        Field[] retvalue = new Field[accum.size()];
        return (Field[]) accum.toArray(retvalue);
    }
}
