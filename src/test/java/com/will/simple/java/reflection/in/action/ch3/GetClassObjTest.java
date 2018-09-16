package com.will.simple.java.reflection.in.action.ch3;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GetClassObjTest {

    @Test
    public void test() throws ClassNotFoundException {
        Class aClass = GetClassObjUtil.forName(int[][].class.getName());
        System.out.println("+=============");
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println("+=============");


    }
}
