package com.will.simple.java.reflection.in.action.common;

public class ClassUtil {

    private static Class clazz_int = int.class;

    private static Class clazz_void = void.class;

    /**
     * 由于自动装箱，这里的参数可能已经是包装类型了
     * @param object
     * @return
     */
    @Deprecated
    public static boolean isPrimitive(Object object) {
        Class<?> clazz = object.getClass();
        return clazz.isPrimitive();
    }

    public static boolean isPrimitive(Class clazz) {
        return clazz.isPrimitive();
    }


    public static boolean isInterface(Class clazz) {
        return clazz.isInterface();
    }

    /**
     * 获取数组元素的class对象
     * 多维数组的本质是数组的数组，所以元素是数组，返回数组的class对象
     * @param clazz
     * @return
     */
    public static Class getArrComponentClass(Class clazz) {
        if (clazz.isArray()) {
            return clazz.getComponentType();
        }
        return null;
    }

    /**
     * 不能递归
     * @param clazz
     * @return
     */
    public static Class[] getInterface(Class clazz) {
        return clazz.getInterfaces();
    }
}
