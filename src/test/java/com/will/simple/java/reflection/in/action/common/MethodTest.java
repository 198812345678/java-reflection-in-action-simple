package com.will.simple.java.reflection.in.action.common;

import com.will.simple.java.reflection.in.action.ch1.BaseClass;
import org.junit.Test;

public class MethodTest {

    @Test
    public void test() {
        MethodUtil.invokeStaticMethod(BaseClass.class, "staticMethod", null, null);
    }
}
