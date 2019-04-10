package com.wkc.work.Day05_ExceptionAndThread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: WKC
 * @description: 05
 * @author: Freeze Wu
 * @create: 2019-04-08 11:23
 **/

public class Homework05 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        try {
            Date date = format.parse("2018-04-03");
            System.out.println("程序正常");

        } catch (ParseException e) {
            System.out.println("程序异常");
        }

        System.out.println("------------------------------------------");

        //每一个学生(Student)都有学号,姓名和分数,分数永远不能为负数
        //如果老师给学生赋值一个负数,抛出一个自定异常
//        try {
////            Student s1 = new Student("101", "aaa",99 );
////            Student s2 = new Student("102", "bbb",-99 );
////
////        } catch(Exception e) {
////            e.printStackTrace();
////        }
////        finally {
////            try {
////                new Student("101", "aaa",99 ).setGrade(-1);
////            }
////            catch (Exception e){
////                e.printStackTrace();
////            }
////        }
////
////        System.out.println("------------------------------------------");
////
////        //创建多线程对象，开启多线程。在子线程中输出1-100之间的偶数，主线程输出1-100之间的奇数。
////        SubThread subThread = new SubThread("aaa");
////
////        for (int i = 1; i <= 100 ; i+=2) {
////            System.out.print(i + ", ");
////
////        }
////        System.out.println();
////        subThread.start();
////        System.out.println("------------------------------------------");

        //在一款角色扮演游戏中,每一个人都会有名字和生命值;角色的生命值不能为负数
        //要求:当一个人物的生命值为负数的时候需要抛出自定的异常


//        Character DemonHunter = new Character("DemonHunter", 100);
//        DemonHunter.setHP(0);
//
//
//        System.out.println("666");

        System.out.println("------------------------------------------");

        //创建三个子线程，在每个线程中开启10万次的循环，
        // 线程1循环中将循环自增变量i赋值给Integer类型变量 a，
        // 线程2循环中将字符串"黑马程序员"赋值给String类型变量b,
        // 线程3循环中将字符串"黑马程序员"和循环自增变量i拼接后赋值给String类型变量c
        //分别计算三个线程完成任务所用的毫秒值
        Thread1 t1 = new Thread1("t1");
        Thread2 t2 = new Thread2("t2");
        Thread3 t3 = new Thread3("t3");

        //long t1_start = System.currentTimeMillis();
        t1.start();
        //long t1_end = System.currentTimeMillis();
        t3.start();
        //long t2_start = System.currentTimeMillis();
        t2.start();
        //long t2_end = System.currentTimeMillis();

        //long t3_start = System.currentTimeMillis();

        //long t3_end = System.currentTimeMillis();

//        System.out.println("t1花费时间：" + (t1_end - t1_start) + "ms");
//        System.out.println("t2花费时间：" + (t2_end - t2_start) + "ms");
//        System.out.println("t3花费时间：" + (t3_end - t3_start) + "ms");
//        System.out.println("t2花费时间：" + ((t2_end - t2_start) / 1000.0) + "s");
//        System.out.println("t3花费时间：" + ((t3_end - t3_start) / 1000.0) + "s");


    }
}

class Thread1 extends Thread{
    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        long t1_start = System.currentTimeMillis();
        String b = "";
        for (int i = 0; i < 100000; i++) {
            b = "黑马程序员";
        }
        long t1_end = System.currentTimeMillis();
        System.out.println("t1花费时间：" + (t1_end - t1_start) + "ms");
    }
}

class Thread2 extends Thread{
    public Thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        long t2_start = System.currentTimeMillis();
        Integer a = 0;
        for (int i = 0; i < 100000; i++) {
            a = i;
        }
        long t2_end = System.currentTimeMillis();
        System.out.println("t2花费时间：" + (t2_end - t2_start) + "ms");
    }
}

class Thread3 extends Thread{
    public Thread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        long t3_start = System.currentTimeMillis();
        Integer a = 0;
        String b = "";
        String c = "";
        for (int i = 0; i < 100000; i++) {
            c = "黑马程序员" + i;
        }
        long t3_end = System.currentTimeMillis();
        System.out.println("t3花费时间：" + (t3_end - t3_start) + "ms");
    }
}

class NegativeException extends Exception{
    public NegativeException(String message) {
        super(message);
    }
}

class Student{
    private String id;
    private String name;
    private int grade;

    public Student(String id, String name, int grade) throws NegativeException {
        if(grade < 0){
            throw new NegativeException("构造时分数不能小于0！");
        }

        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws NegativeException {
        if(grade < 0){
            throw new NegativeException("设置时分数不能小于0！");
        }

        this.grade = grade;
    }
}

class SubThread extends Thread{
    public SubThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("SubThread is Running:");
        for (int i = 2; i <= 100 ; i+=2) {
            System.out.print(i + ", ");
        }
    }
}

//自定义异常继承于RuntimeException，可以不手动处理可能发生异常的代码
class NoLifeException extends RuntimeException{
    public NoLifeException(String message) {
        super(message);
    }
}

class Character{
    private String name;
    private int HP;

    public Character(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if(HP <= 0){
            throw new NoLifeException("设置HP不能小于0！");
        }

        this.HP = HP;
    }
}
