package com.wkc.work.Day06_ThreadAndSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: WKC
 * @description: 模拟4个窗口同时卖100张票的场景
 * @author: Freeze Wu
 * @create: 2019-04-09 11:38
 **/

public class SellTickets {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket, "窗口一");
        Thread t2 = new Thread(ticket, "窗口二");
        Thread t3 = new Thread(ticket, "窗口三");
        Thread t4 = new Thread(ticket, "窗口四");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //System.exit(0);
    }
}

class Ticket implements Runnable{
    private int ticketNum = 100;

    //static Object lock = new Object();  //共享锁

    Lock lock = new ReentrantLock();    //创建lock对象

    @Override
    public void run() {
        //这种方法会导致线程不安全
//        while (true){
//            if(ticketNum > 0){  //有票时可以出票
//                try {
//                    Thread.sleep(100);  //使用sleep模拟出票过程
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                //输出当前线程出票的信息，出票后票数--
//                String name = Thread.currentThread().getName();
//                System.out.println(name + "正在出票" + ticketNum--);
//            }
//        }

        //方式1：使用同步代码块解决线程安全问题
//        while (true) {
//            synchronized (lock) {
//                if (ticketNum > 0) {  //有票时可以出票
//                    try {
//                        Thread.sleep(50);  //使用sleep模拟出票过程
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    //输出当前线程出票的信息，出票后票数--
//                    String name = Thread.currentThread().getName();
//                    System.out.println(name + "正在出票" + ticketNum--);
//                }
//            }
//        }

//        //方式2：使用同步方法来解决线程安全问题
//        while (true){
//            sellTicket();
//        }

        //方式3：使用同步锁解决线程安全（After JDK 1.5）
        while (true) {
            //上锁，互斥锁，只能让一个线程进来
            lock.lock();

            if (ticketNum > 0) {  //有票时可以出票
                try {
                    Thread.sleep(50);  //使用sleep模拟出票过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //输出当前线程出票的信息，出票后票数--
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在出票" + ticketNum--);
            }
            //释放锁，相当于开门
            lock.unlock();
        }
    }


        //使用synchronized关键字将方法标记为同步方法
        //当A线程执行该方法时，其他线程只能在方法外等着
        private synchronized void sellTicket () {
            if (ticketNum > 0) {  //有票时可以出票
                try {
                    Thread.sleep(50);  //使用sleep模拟出票过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //输出当前线程出票的信息，出票后票数--
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在出票" + ticketNum--);
            }
        }
}