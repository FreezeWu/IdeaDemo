package com.wkc.rookie;

public class ExceptionTest {
    public static void main(String[] args){
        try {
            int i = 5 / 0;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("退出程序");
        }

    }
}
