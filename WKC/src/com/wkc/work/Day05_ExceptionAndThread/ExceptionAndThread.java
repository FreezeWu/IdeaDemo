package com.wkc.work.Day05_ExceptionAndThread;

import java.util.Scanner;

/**
 * @program: WKC
 * @description: 05
 * @author: Freeze Wu
 * @create: 2019-04-08 09:57
 **/

public class ExceptionAndThread {
    static String[] names = {"Kill", "Bill", "Nill", "Hill"};

    public static void main(String[] args) {
//        int[] a = {1,2};
//        try {
//            System.out.println(a[33]);
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//            System.out.println(ex.getMessage());
//        }
//        finally {
//            System.out.println(1);
//        }

        System.out.println("------------------------------------------");

        //模拟登陆操作，使用数组模拟数据库中存储的数据，并提供当前注册账号是否存在方法用于判断
        System.out.println("创建用户名：");
        String inputName = new Scanner(System.in).next();

        try {
            checkUsername(inputName);
            System.out.println("创建用户名成功");
        } catch (LoginException e) {
            e.printStackTrace();
        }

        MyThread thread = new MyThread("WKC");
        thread.start();

    }

    public static boolean checkUsername(String userName) throws LoginException {
        for(String name : names){
            if(name.equals(userName)){
                throw new LoginException("该用户名已被注册！");
            }
        }
        return true;
    }
}

class LoginException extends Exception{
    public LoginException(String message) {
        super(message);
    }
}

class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("MyThread is Running.");
    }
}


