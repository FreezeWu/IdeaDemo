package com.wkc.work.Day07_ThreadPoolAndLambda;

/**
 * @program: WKC
 * @description: lambda
 * @author: Freeze Wu
 * @create: 2019-04-10 11:23
 **/

public class LambdaExpression {
    public static void main(String[] args) {
        invokeCook(() -> {
            System.out.println("I make some pizza.");
            System.out.println("Come on!");
        });

        System.out.println("------------------------------------------");

        //lambda，自定义计算规则并输出a和b的计算结果
        invokeCalc(10, 20, (a, b) -> a + a * b);
    }

    public static void invokeCook(Cook cook){
        cook.makefood();
    }

    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}

interface Cook{
    void makefood();
}

interface Calculator {
    int calc(int a, int b);
}