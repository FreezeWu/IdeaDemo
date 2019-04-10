package com.wkc.work.Day06_ThreadAndSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: WKC
 * @description: 06
 * @author: Freeze Wu
 * @create: 2019-04-09 17:18
 **/

public class Homework06 {

    public static void main(String[] args) {
        //编写程序，创建两个线程对象，
        // 一根线程循环输出“播放背景音乐”，
        // 另一根线程循环输出“显示画面”，
        // 要求线程实现Runnable接口，且使用匿名内部类实现
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    System.out.println("播放背景音乐");
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                System.out.println("显示画面");
//                }
//            }
//        }).start();

        //new Thread(() -> System.out.println("显示画面")).start();
        System.out.println("------------------------------------------");


        //编写一个Java程序，要求在同一个类中除main线程外，再开启一个线程，2个线程都循环执行20次。

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println("播放背景音乐");
//                }
//            }
//        }).start();


        //使用lambda表达式创建线程
        new Thread(()->{for (int i = 0; i < 20; i++) {
            System.out.println("播放背景音乐");
        }}).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("显示画面");
        }

        System.out.println("------------------------------------------");

        //请按要求编写多线程应用程序，模拟多个人通过一个山洞：
        //1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
        //2.随机生成10个人，同时准备过此山洞，并且定义一个变量用于记录通过隧道的人数。显示每次通过山洞人的姓名，和通过顺序；

        CH_Man man = new CH_Man("过山洞的精灵们");

        //创建10个子线程对象，并开启
//        for (int i = 1; i <= 10 ; i++) {
//            Thread t = new Thread(man, "T" + i);
//            t.start();
//        }

        //创建实现runnable接口类时只需创建一个对象即可实现资源共享
        //以下代码多余
//        CH_Man m02 = new CH_Man("夜刀神十香");
//        CH_Man m03 = new CH_Man("四糸乃");
//        CH_Man m04 = new CH_Man("时崎狂三");
//        CH_Man m05 = new CH_Man("鸢一折纸");
//        CH_Man m06 = new CH_Man("八舞耶俱矢");
//        CH_Man m07 = new CH_Man("八舞夕弦");
//        CH_Man m08 = new CH_Man("诱宵美九");
//        CH_Man m09 = new CH_Man("七罪");
//        CH_Man m10 = new CH_Man("本条二亚");
//        CH_Man m11 = new CH_Man("星宫六喰");
//        CH_Man m12 = new CH_Man("崇宫澪");

        //使用匿名内部类直接创建线程并start
        //以下代码执行多次的顺序相同，因为一个线程执行时间太短以至于在下个线程new出来并start之前已经执行完毕
        //实际上跟实名创建Thread再start是相同的
//        new Thread(man, "五河琴里").start();
//        new Thread(man, "夜刀神十香").start();
//        new Thread(man, "四糸乃").start();
//        new Thread(man, "时崎狂三").start();
//        new Thread(man, "鸢一折纸").start();
//        new Thread(man, "八舞耶俱矢").start();
//        new Thread(man, "八舞夕弦").start();
//        new Thread(man, "诱宵美九").start();
//        new Thread(man, "七罪").start();
//        new Thread(man, "本条二亚").start();
//        new Thread(man, "星宫六喰").start();
//        new Thread(man, "崇宫澪").start();

        //一次性把线程创建好，再逐个start
        //所有线程抢占时调度，过山洞顺序可能不同
//        Thread t01 = new Thread(man, "五河琴里");
//        Thread t02 = new Thread(man, "夜刀神十香");
//        Thread t03 = new Thread(man, "四糸乃");
//        Thread t04 = new Thread(man, "时崎狂三");
//        Thread t05 = new Thread(man, "鸢一折纸");
//        Thread t06 = new Thread(man, "八舞耶俱矢");
//        Thread t07 = new Thread(man, "八舞夕弦");
//        Thread t08 = new Thread(man, "诱宵美九");
//        Thread t09 = new Thread(man, "七罪");
//        Thread t10 = new Thread(man, "本条二亚");
//        Thread t11 = new Thread(man, "星宫六喰");
//        Thread t12 = new Thread(man, "崇宫澪");
//
//        t01.start();
//        t02.start();
//        t03.start();
//        t04.start();
//        t05.start();
//        t06.start();
//        t07.start();
//        t08.start();
//        t09.start();
//        t10.start();
//        t11.start();
//        t12.start();

        //使用线程池调度
        //使用线程池一般是为了减少创建线程的数量，因此不太适用于这一题的解决方案
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10 ; i++) {
            //Thread t = new Thread(man);
            //pool.submit(t);
            pool.submit(man);
        }

        pool.shutdown();
    }


}

class CH_Man implements Runnable{
    private String name;

    private static int nums = 0;

    Lock lock = new ReentrantLock();

    public CH_Man(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        lock.lock();

        //nums++;

        System.out.println("第" + ++nums + "个精灵——" + Thread.currentThread().getName() + "正在通过山洞.....");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //CrossHole();

        lock.unlock();
    }

//    public synchronized void CrossHole() {
//
//        nums++;
//
//        System.out.println("第" + nums + "个人——" + Thread.currentThread().getName() + "正在通过山洞.....");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
}
