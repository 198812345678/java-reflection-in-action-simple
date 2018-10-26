package com.will.simple.java.reflection.in.action.ch6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class SimpleClassLoader extends ClassLoader {

    private String[] dirs;

    public SimpleClassLoader(ClassLoader parent, String path) {
        super(parent);
        this.dirs = path.split(File.separator);
    }

    public SimpleClassLoader(String path) {
        this.dirs = path.split(File.separator);
    }

    public void extendClassPath(String path) {
        String[] extDirs = path.split(File.pathSeparator);
        String[] newDirs = new String[dirs.length + extDirs.length];
        System.arraycopy(dirs, 0, newDirs, 0, dirs.length);
        System.arraycopy(extDirs, 0, newDirs, newDirs.length, extDirs.length);
        dirs = newDirs;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        for (String dir : dirs) {
            byte[] classData = new byte[0];
            try {
                classData = getClassData(dir, name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (classData != null) {
                defineClass(name, classData, 0, classData.length);
            }
        }

        throw new ClassNotFoundException();
    }

    private byte[] getClassData(String dir, String name) throws IOException {
        String filePath = dir + File.pathSeparator + name + ".class";
        File file = new File(filePath);
        byte[] buf = new byte[Long.valueOf(file.length()).intValue()];
        FileInputStream inputStream = new FileInputStream(file);
        try {
            inputStream.read(buf);
        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return buf;
    }
}
