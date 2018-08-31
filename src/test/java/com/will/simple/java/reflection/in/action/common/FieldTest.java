package com.will.simple.java.reflection.in.action.common;

import com.will.simple.java.reflection.in.action.ch1.BaseClass;
import com.will.simple.java.reflection.in.action.ch1.BaseComponent;
import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    public void test() {
        Field[] declaredFields = BaseClass.class.getDeclaredFields();
        System.out.println("=========");
        for (Field field : declaredFields) {
            Class declarClass = FieldUtil.getDeclarClass(field);
            System.out.println(declarClass.getName());
        }
        System.out.println("=========");
    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        BaseClass baseClass = new BaseClass();
        Field[] declaredFields = BaseClass.class.getDeclaredFields();
        for (Field field : declaredFields) {
            FieldUtil.setValue(baseClass, field, 1);
        }
        System.out.println("=======");
        System.out.println(baseClass.getI());
        System.out.println("=======");
    }

    @Test
    public void test3() {
        BaseClass baseClass = new BaseClass();
        Field[] declaredFields = BaseClass.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(FieldUtil.isPublic(field));
            System.out.println(FieldUtil.isStatic(field));
        }
    }
}
