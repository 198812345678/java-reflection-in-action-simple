package com.will.simple.java.reflection.in.action.ch1;

import org.junit.Test;

public class PrintNameTest {

    @Test
    public void test() {
        SubClass1 subClass1 = new SubClass1();
        subClass1.printName();

        SubClass2 subClass2 = new SubClass2();
        subClass2.printName();
    }
}
