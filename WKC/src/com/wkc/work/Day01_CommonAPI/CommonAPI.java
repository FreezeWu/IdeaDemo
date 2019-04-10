package com.wkc.work.Day01_CommonAPI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @program: WKC
 * @description: Day01 -- Object类、常用API
 * @author: Freeze Wu
 * @create: 2019-04-03 09:00
 **/

public class CommonAPI {
    public static void main(String[] args) {
        Singer s1 = new Singer("Taeyeon", 30);
        Singer s2 = new Singer("Taeyeon", 30);

        System.out.println(s1);

        Dancer d1 = new Dancer("Taeyeon", 30);

        System.out.println(s1 == s2);   //false,比较地址值
        System.out.println(s1.equals(s2));  //true,因为重写了equals方法
        System.out.println(s1.equals(d1));

        System.out.println("------------------------------------------");

        //Date类一般使用默认或参数为毫秒数的构造方法，其他构造方法已过时
        Date now = new Date();
        System.out.println(now.getTime());

        Date birthdate = new Date();

        //DateFormat类为抽象类，一般使用子类SimpleDateFormat来创建实例对象
        //pattern指定DateFormat的String表现格式
        DateFormat birthday = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //parse方法尝试将一个String转化为Date类型对象
            birthdate = birthday.parse("1994-10-04");
            String myBirthday = birthday.format(birthdate);
            System.out.println(myBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println((now.getTime() - birthdate.getTime())/86400000/365);

        System.out.println("------------------------------------------");

        //Calendar类（日历类）为抽象类，一般使用getInstance()方法(使用默认时区和语言)来构造实例对象
        Calendar calendar = Calendar.getInstance();
        calendar.set(1989, 2, 9);
        Calendar calBirth = Calendar.getInstance();
        calBirth.setTime(birthdate);

        DateFormat tyBirth = new SimpleDateFormat("yyyy-MM-dd");
        String str = tyBirth.format(calendar.getTime());
        System.out.println(str);

        Calendar nowTime = Calendar.getInstance();
        DateFormat nowTimeFormat = new SimpleDateFormat("a hh:mm:ss");
        String str2 = nowTimeFormat.format(nowTime.getTime());
        System.out.println(str2);

        System.out.println("------------------------------------------");

//        long start = System.currentTimeMillis();
//        for (int i = 1; i <= 10000; i++) {
//            System.out.println(i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("print 1-10000 need " + ((end - start) / 1000.0) + "s");

        System.out.println("------------------------------------------");

        //StringBuilder类为一个可变字符序列
        StringBuilder sb1 = new StringBuilder("Taeyeon");
        StringBuilder sb2 = sb1.append(" Kim");

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb1 == sb2);

    }

}

//自定义类重写equals方法之前，任意两个类对象实例==或equals都返回false
//使用模版重新equals方法后，所有成员变量的值都相同的两个对象实例使用equals方法返回true
class Singer{
    private String name;
    private int age;

    public Singer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer singer = (Singer) o;
        return age == singer.age &&
                Objects.equals(name, singer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name=\"" + name + '\"' +
                ", age=" + age +
                '}';
    }
}

class Dancer{
    private String name;
    private int age;

    public Dancer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dancer dancer = (Dancer) o;
        return age == dancer.age &&
                Objects.equals(name, dancer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
