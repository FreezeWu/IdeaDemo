package com.wkc.demo;

public class ObjectTest {
    public static void main(String[] args) {
        Singer taeyeon = new Singer("KimTaeyeon");

        Singer.publicstMethod();

        System.out.println(taeyeon.getName());
        System.out.println(taeyeon.getNum());

        Singer.num++;
        System.out.println(taeyeon.getNum());
    }
}

class Singer{
    String name;
    static int num = 29;

    public Singer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        Singer.num = num;
    }

    private static void staticMethod(){
        System.out.println("This is a private static Method");
    }

    public void publicMethod(){
        System.out.println("This is a public Method");
    }

    public static void publicstMethod(){
        System.out.println("This is a public static Method");
    }
}
