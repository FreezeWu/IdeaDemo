package com.wkc.demo;

import java.util.Scanner;

class TV{
    String name;

    public TV() {
    }

    public TV(String name) {
        this.name = name;
    }

    void play(String channel){
        System.out.println(name + " 电视正在播放" + channel + "节目");
    }
}


interface RedRay{
    void ContorlTV(TV tv);

    default void connecting(){
        System.out.println("外接设备,连接成功, 可以使用红外线");
    };


}

class RemoteControl implements RedRay{
    @Override
    public void ContorlTV(TV tv) {
        System.out.println("遥控器控制电视");
        System.out.println("请输入节目名称");
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();

        tv.play(msg);
    }
}

class Phone implements RedRay{
    @Override
    public void ContorlTV(TV tv) {
        System.out.println("手机开启红外功能,控制电视");
        System.out.println("请输入节目名称");
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();

        tv.play(msg);
    }
}


public class TVtest {
    public static void main(String[] args) {
        TV tv = new TV("海尔");
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.ContorlTV(tv);
        Phone phone = new Phone();
        phone.connecting();
        phone.ContorlTV(tv);
    }
}
