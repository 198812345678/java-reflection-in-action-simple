package com.will.simple.java.reflection.in.action.common;

import com.will.simple.java.reflection.in.action.ch1.Component1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassTest {

    @Test
    public void test() {
        int i = 8;
        boolean primitive = ClassUtil.isPrimitive(int.class);
        boolean anInterface = ClassUtil.isInterface(Map.class);
        System.out.println("========");
        System.out.println(primitive);
        System.out.println(anInterface);
        System.out.println("========");
    }

    @Test
    public void test2() {
        int[] a = new int[]{1, 2};
        Class arrComponentClass = ClassUtil.getArrComponentClass(a.getClass());

        int[][] aa = new int[][]{{1, 2}};
        Class arrComponentClass1 = ClassUtil.getArrComponentClass(aa.getClass());

        System.out.println("===========");
        System.out.println(arrComponentClass.getName());
        System.out.println(arrComponentClass1.getName());
        System.out.println(int[].class.getName());
        System.out.println("===========");
    }

    @Test
    public void test3() {
        Class[] anInterface = ClassUtil.getInterface(List.class);
        System.out.println("=========");
        for (Class aClass : anInterface) {
            System.out.println(aClass.getName());
        }
        System.out.println("=========");
    }
}
