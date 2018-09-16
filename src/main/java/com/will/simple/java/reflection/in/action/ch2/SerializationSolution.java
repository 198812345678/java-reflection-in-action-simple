package com.will.simple.java.reflection.in.action.ch2;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.will.simple.java.reflection.in.action.ch1.Mopex;
import org.jdom2.Document;
import org.jdom2.Element;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.Map;

public class SerializationSolution {

    public static Document serializeObject(Object source) throws IllegalAccessException {
        return serializeHelper(source, new Document(new Element("serialized")), new IdentityHashMap<>());
    }

    private static Document serializeHelper(Object source, Document target, Map table) throws IllegalAccessException {
        String id = String.valueOf(table.size());
        table.put(source, id);
        Class<?> sourceClass = source.getClass();
        Element objElt = new Element("object");
        objElt.setAttribute("class", sourceClass.getName());
        objElt.setAttribute("id", id);
        target.getRootElement().addContent(objElt);

        if (!sourceClass.isArray()) {
            Field[] fields = Mopex.getInstanceVariables(sourceClass);
            for (Field field : fields) {
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }

                Element fElt = new Element("field");
                fElt.setAttribute("name", field.getName());
                fElt.setAttribute("declaringClass", field.getClass().getName());

                Class<?> fieldType = field.getType();
                Object child = field.get(source);
                if (Modifier.isTransient(field.getModifiers())) {
                    child = null;
                }

                fElt.addContent(serializeVariable(fieldType, child, target, table));

                objElt.addContent(fElt);
            }
        } else {
            Class<?> componentType = sourceClass.getComponentType();
            int length = Array.getLength(source);
            objElt.setAttribute("length", String.valueOf(length));
            for (int i = 0; i < length; i++) {
                objElt.addContent(serializeVariable(componentType, Array.get(source, i), target, table));
            }
        }
        return target;
    }

    private static Element serializeVariable(Class fieldTye, Object child, Document target, Map table) throws IllegalAccessException {
        if (child == null) {
            return new Element("null");
        }

        if (!fieldTye.isPrimitive()) {
            Element reference = new Element("reference");
            if (table.containsKey(child)) {
                reference.setText(table.get(child).toString());
            } else {
                reference.setText(String.valueOf(table.size()));
                serializeHelper(child, target, table);
            }
        } else {
            Element value = new Element("value");
            value.setText(child.toString());
            return value;
        }

        return null;
    }
}
