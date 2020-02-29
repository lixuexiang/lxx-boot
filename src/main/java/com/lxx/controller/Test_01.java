package com.lxx.controller;

import java.util.concurrent.locks.LockSupport;

public class Test_01 {

    static  Thread t1 = null , t2 = null;

    public static void main(String[] args) {

        char[] a1 = "123456".toCharArray();
        char[] a2 = "ABCDEF".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c : a1){
                    System.out.println("t1:"+c);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c :a2){
                    LockSupport.park();
                    System.out.println("t2:"+c);
                    LockSupport.unpark(t1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
