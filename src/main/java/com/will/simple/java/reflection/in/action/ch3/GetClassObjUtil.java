package com.will.simple.java.reflection.in.action.ch3;

public class GetClassObjUtil {

    public static Class forName(String className) throws ClassNotFoundException {
        try {
            Class<?> aClass = Class.forName(className);
            return aClass;
        } catch (ClassNotFoundException e) {
            switch (className) {
                case "int":
                    return int.class;
                case "boolean":
                    return boolean.class;
                case "byte":
                    return byte.class;
                case "short":
                    return short.class;
                case "long":
                    return long.class;
                case "double":
                    return double.class;
                case "float":
                    return float.class;
                case "char":
                    return char.class;
                default:
                    throw e;
            }
        }

    }
}
