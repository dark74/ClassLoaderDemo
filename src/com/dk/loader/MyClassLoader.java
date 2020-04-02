package com.dk.loader;

import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {
    private String baseClassPath;

    public MyClassLoader(String baseClassPath) {
        this.baseClassPath = baseClassPath;
    }


    public byte[] loadClassByte(String className) throws Exception {
        className = className.replaceAll("\\.", "/");
        String realClassPath = baseClassPath + "/" + className + ".class";
        FileInputStream fis = new FileInputStream(realClassPath);//读取完整的class路径
        int length = fis.available();
        byte[] classBytes = new byte[length];
        fis.read(classBytes);
        fis.close();
        return classBytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = loadClassByte(name);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
