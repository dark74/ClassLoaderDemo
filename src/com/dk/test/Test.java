package com.dk.test;

public class Test {
    public void say(String msg) {
        System.out.println(getClass().getClassLoader().getClass() + " load the - Test.class.say:" + msg);
    }
}
