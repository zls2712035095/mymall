package com.zls;

import java.util.*;

public class Main {
    static int num = 1;
    static Object block = new Object();
    public static void OK(List a){
        a.set(0, 1);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(2);
        list.add(3);
        
        OK(list);
        System.out.println(list.get(0));
        Map<String, Integer> map = new HashMap<>();
        Iterator iterator = map.entrySet().iterator();
        Thread thread = new Thread(){
            @Override
            public void run() {
                synchronized (block){
                    while(num <= 10){
                        if(num % 2 == 1){
                            System.out.println(currentThread().getName() + " " + num);
                            num ++;
                            block.notify();
                        }else{
                            try {
                                block.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }


            }
        };

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (block){
                    while(num <= 10){
                        if(num % 2 == 0){
                            System.out.println(currentThread().getName() + " " + num);
                            num ++;
                            block.notifyAll();

                        }else{
                            try {
                                block.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }


                    }
                }


            }
        };

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.start();
        thread.start();
        System.out.println("Hello world!");
    }
}