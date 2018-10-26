package com.will.simple.java.reflection.in.action.ch5;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class StackTraceTest {

    @Test
    public void test() {
        StackTraceElement[] stackTraceEle = StackTraceSolution.getStackTraceEle();
        System.out.println(JSON.toJSONString(stackTraceEle));
        stackTraceEle = StackTraceSolution.getThreadStackTraceEle();
        System.out.println(JSON.toJSONString(stackTraceEle));
    }
}
