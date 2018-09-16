package com.will.simple.java.reflection.in.action.ch3;

import java.lang.reflect.Array;

public class NewInstanceUtil {

    public static Object newArrayInstance(Class clazz, int[] dim) {
        return Array.newInstance(clazz, dim);
    }
}
