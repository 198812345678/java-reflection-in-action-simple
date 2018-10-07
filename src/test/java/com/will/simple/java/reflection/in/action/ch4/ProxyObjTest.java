package com.will.simple.java.reflection.in.action.ch4;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ProxyObjTest {

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        ProxyObj.printToString(new TargetObj());
    }

    @Test
    public void test_2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ProxyObj.clone(new CloneTargetObj());
    }
}
