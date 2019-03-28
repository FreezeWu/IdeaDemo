package com.wkc.demo;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Day07 {

    //最大输入尝试次数
    static final int MAX_INPUT_TIMES = 5;

    public static void main(String[] args) {
        String username = "admin";
        String password = "admin";

//        String userInput = "";
//        String pwdInput = "";

//        StringBuilder userInput = new StringBuilder();
//        StringBuilder pwdInput = new StringBuilder();

        int attempt = 0;

        Scanner sc = new Scanner(System.in);

        //input(sc, userInput,pwdInput);

        System.out.println("请输入用户名：");
        String userInput = sc.nextLine();
        System.out.println("请输入密码：");
        String pwdInput = sc.nextLine();

        if(userInput.equals(username) && pwdInput.equals(password)){
            System.out.println("登陆成功");
            return;
        }

        while(!userInput.equals(username) || !pwdInput.equals(password)){
            attempt++;
            if(attempt == MAX_INPUT_TIMES){
                System.out.println("用户名或密码错误， 您已用尽今天的输入次数，请明天再试。");
                return;
            }
            System.out.println("用户名或密码错误， 您还有" + (MAX_INPUT_TIMES - attempt) + "次机会...");
            //input(sc, userInput,pwdInput);

            System.out.println("请输入用户名：");
            userInput = sc.nextLine();
            System.out.println("请输入密码：");
            pwdInput = sc.nextLine();

            if(userInput.equals(username) && pwdInput.equals(password)){
                System.out.println("登陆成功");
                break;
            }


        }
    }

//    public static void input(Scanner sc, StringBuilder userInput, StringBuilder pwdInput){
//        System.out.println("请输入用户名：");
//        userInput.append(sc.nextLine());
//        System.out.println("请输入密码：");
//        pwdInput.append(sc.nextLine());
//    }

    public static Map input(Scanner sc, String userInput, String pwdInput){
        System.out.println("请输入用户名：");
        userInput = sc.nextLine();
        System.out.println("请输入密码：");
        pwdInput = sc.nextLine();

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(userInput, pwdInput);

        return hashtable;
    }
}
