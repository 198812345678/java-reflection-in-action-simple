package com.will.simple.java.reflection.in.action.common;

import com.will.simple.java.reflection.in.action.ch1.BaseClass;
import org.junit.Test;

import java.lang.reflect.Method;

public class MetaObjUtilTest {

    @Test
    public void test() {
        Method[] declaredMethods = MetaObjUtil.getDeclaredMethods(new BaseClass());
        System.out.println("=======");
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
        System.out.println("=======");
    }

    @Test
    public void test2() {
        Object obj = MetaObjUtil.invokeNoneParam(new BaseClass());
        System.out.println(obj);
    }
}
