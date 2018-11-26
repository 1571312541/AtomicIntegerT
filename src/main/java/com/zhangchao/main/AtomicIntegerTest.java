package com.zhangchao.main;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈AtomicInteger原子操作类〉
 *
 * @author zc
 * @create 2018/11/6
 */
public class AtomicIntegerTest {

    /**
     *  1、一般情况下使用num++，在多线程下可能回出现问题
     *
     */
   /* public static int num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run(){
                    for (int j = 0; j < 100; j++) {
                        System.out.println(num++);
                    }
                }
            }.start();
        }
    }*/

    /**
     *  2、使用原子类型AtomicInteger，在多线程下不会出现问题
     *
     */
    public static void main(String[] args) {
        //从内部类中访问本地变量num; 需要被声明为最终类型
        final AtomicInteger num = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run(){
                    for (int j = 0; j < 100; j++) {
                        System.out.println(num.getAndIncrement());
                    }
                }
            }.start();
        }
    }
}

