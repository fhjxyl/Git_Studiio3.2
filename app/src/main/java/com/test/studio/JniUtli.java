package com.test.studio;

public class JniUtli {

    static {
        System.loadLibrary("jniutli");
    }

    public native static String sayHellow();
}
