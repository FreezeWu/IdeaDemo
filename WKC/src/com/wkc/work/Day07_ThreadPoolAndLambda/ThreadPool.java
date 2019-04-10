package com.wkc.work.Day07_ThreadPoolAndLambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: WKC
 * @description: day07
 * @author: Freeze Wu
 * @create: 2019-04-09 20:47
 **/

public class ThreadPool {
    public static void main(String[] args) {
        //一般多线程使用
//        Baozi baozi = new Baozi();
//        Foodie foodie = new Foodie("吃货1", baozi);
//        BaoziStore baoziStore = new BaoziStore("包道", baozi);
//
//        foodie.start();
//        baoziStore.start();

        //创建线程池对象来调度多线程
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Baozi baozi = new Baozi();
        Foodie foodie = new Foodie("吃货1", baozi);
        BaoziStore baoziStore = new BaoziStore("包道", baozi);

        pool.submit(foodie);
        pool.submit(baoziStore);

        //一般不会特意关闭线程池
        //pool.shutdown();

        //foodie.start();
        //baoziStore.start();

        System.out.println("------------------------------------------");
    }


}

class Baozi{
    String pier;
    String xianer;
    boolean flag = false;
}

class Foodie extends Thread{
    private Baozi baozi;

    public Foodie(String name, Baozi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true){   //吃货一直在吃包子
            synchronized (baozi){   //同步代码块，用baozi对象作为锁
                if(baozi.flag == false){    //当没有包子时（flag == false），吃货线程等待
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "：走着，给包子铺老板上一课啊");
                System.out.println("吃货正在吃" + baozi.pier + baozi.xianer + "包子");
                baozi.flag = false;
                System.out.println("包子吃完了，老板赶紧上啊");
                System.out.println("------------------------------------------");
                baozi.notify();

            }
        }
    }
}

class BaoziStore extends Thread{
    private Baozi baozi;

    public BaoziStore(String name, Baozi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;

        while (true){   //包子铺不断生产包子，每生产一个包子，flag更新为true，通知吃货线程
            synchronized (baozi){   //使用锁时需使用同步代码块
                if(baozi.flag == true){     //还有包子时等待不生产
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "包子铺开始做包子");

                if(count % 2 == 0){
                    baozi.pier = "冰皮";
                    baozi.xianer = "五仁";
                }else {
                    baozi.pier = "香蕉皮";
                    baozi.xianer = "皮皮虾";
                }

                count++;

                baozi.flag = true;
                System.out.println("包子做好了：" + baozi.pier + baozi.xianer);
                System.out.println("吃货快来吃啊");
                System.out.println("------------------------------------------");
                baozi.notify();
            }
        }
    }
}

