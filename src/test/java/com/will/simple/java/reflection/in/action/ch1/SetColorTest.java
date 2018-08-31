package com.will.simple.java.reflection.in.action.ch1;

import org.junit.Test;

public class SetColorTest {

    @Test
    public void test() {
        SetColorUtil.setColor(new Component1(), new Color());
    }

    @Test
    public void test2() {
        SetColorUtil.setBaseColor(new Component1(), new Color());
    }
}
