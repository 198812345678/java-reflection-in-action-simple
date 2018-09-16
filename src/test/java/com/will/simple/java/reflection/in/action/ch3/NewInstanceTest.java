package com.will.simple.java.reflection.in.action.ch3;

import org.junit.Test;

public class NewInstanceTest {

    @Test
    public void test() {
        int[] dim = new int[]{2,3};
        Object o = NewInstanceUtil.newArrayInstance(String.class, new int[]{2, 3});
        System.out.println(o);

        /**
         * 多维数组，维度参数从外往里生效
         */
        Object o1 = NewInstanceUtil.newArrayInstance(String[].class, new int[]{2, 3});
        System.out.println(o1);
    }
}
