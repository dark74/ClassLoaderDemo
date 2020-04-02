package com.dk;

import com.dk.loader.MyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("D:/Codes/ClassLoaderDemo/src");

        try {
            Class clz = myClassLoader.loadClass("com.dk.test.Test");//加载类
            Object objectInstance = clz.newInstance();//调用类方法
            Method sayMethod = clz.getDeclaredMethod("say", String.class);
            sayMethod.invoke(objectInstance, "hello");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
