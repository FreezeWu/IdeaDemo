package com.wkc.work.Day06_ThreadAndSynchronized;

/**
 * @program: WKC
 * @description: day06
 * @author: Freeze Wu
 * @create: 2019-04-09 10:14
 **/

public class ThreadAndSynchronized {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程正在执行。。。");

        SubThread st = new SubThread("邪恶势力");

        //使用实现Runnable接口的线程可用于资源共享
        Thread t1 = new Thread(st, "天辉军团");
        Thread t2 = new Thread(st, "夜魇军团");
        Thread.sleep(1000);
        System.out.println("main线程休眠了1秒");
        t1.start();


        t2.start();

        System.out.println("------------------------------------------");

        //使用匿名内部类创建线程

        //多线程实现方式一,创建Thread类子类对象,调用start方法开启一个线程,就会调用我们重写的run方法
        new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类方式一创建子线程");
            }
        }.start();

        //方式二,通过Thread类对象调用构造方法,传入接口实现类对象,
        //Thread类对象调用start方法去开启一个线程,就会调用我们重写的run方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类方式二创建子线程");
            }
        }).start();

        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(666);
            }
        };

        t.start();

        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(888);
            }
        });

        tt.start();


    }
}

class SubThread implements Runnable{
    private String name;

    public SubThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "线程正在执行。。。");

        Thread t = Thread.currentThread();  //返回对当前正在执行的线程对象的引用
        System.out.println(t.getName());
    }
}
