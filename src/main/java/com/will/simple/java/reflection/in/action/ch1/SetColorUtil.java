package com.will.simple.java.reflection.in.action.ch1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SetColorUtil {

    public static void setColor(Object obj, Color color) {
        Class<?> aClass = obj.getClass();
        Method setColorMethod = null;
        try {
            setColorMethod = aClass.getMethod("setColor", new Class[]{color.getClass()});
        } catch (NoSuchMethodException e) {//obj没有setColor方法
            e.printStackTrace();
        }

        try {
            setColorMethod.invoke(obj, color);
        } catch (IllegalAccessException e) {
            e.printStackTrace();//只能访问obj的public方法
        } catch (InvocationTargetException e) {
            e.printStackTrace();//obj的setColor方法抛异常
        }
    }

    public static void setBaseColor(Object obj, Color color) {
        Class<?> aClass = obj.getClass();
        Method setColorMethod = null;
        try {
            setColorMethod = Mopex.getSupportedMethod(aClass, "setColorBase", new Class[]{Color.class});
        } catch (NoSuchMethodException e) {//obj没有setColor方法
            e.printStackTrace();
        }

        try {
            setColorMethod.invoke(obj, color);
        } catch (IllegalAccessException e) {
            e.printStackTrace();//只能访问obj的public方法
        } catch (InvocationTargetException e) {
            e.printStackTrace();//obj的setColor方法抛异常
        }
    }
}
