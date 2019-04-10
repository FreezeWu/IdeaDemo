package com.wkc.rookie;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        //栈，后进先出，继承于Vector类
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack);

//        stack.push(666);
//        stack.push(777);
//        stack.push(666);
//        stack.push(888);
        pushStack(stack, 666);
        pushStack(stack, 777);
        pushStack(stack, 666);
        pushStack(stack, 888);

        System.out.println(stack);

        System.out.println("The top of Stack is " + stack.peek());

//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
        popStack(stack);
        popStack(stack);
        popStack(stack);
        popStack(stack);

        System.out.println(stack);


    }

    static void pushStack(Stack<Integer> stack, int a){
        stack.push(a);
        System.out.println("Push " + a + " into Stack" );
    }

    static void popStack(Stack<Integer> stack){
        int num = stack.pop();
        System.out.println("Pop " + num + "out to Stack");
    }
}
