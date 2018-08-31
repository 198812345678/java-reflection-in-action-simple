package com.will.simple.java.reflection.in.action.common;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldUtil {

    public static Class getDeclarClass(Field field) {
        return field.getDeclaringClass();
    }

    public static void setValue(Object obj, Field field, Object value) throws IllegalAccessException {
        field.set(obj, value);
    }

    /**
     * 一个int值代表bit vector，位标识，可以标识多个修饰符
     * @param field
     * @return
     */
    public static boolean isPublic(Field field) {
        return Modifier.isPublic(field.getModifiers());
    }

    public static boolean isStatic(Field field) {
        return Modifier.isStatic(field.getModifiers());
    }
}
