package com.wkc.demo;

import java.util.AbstractList;
import java.util.ArrayList;

public class ExtendsTest {
    public static void main(String[] args) {
        Fu fu = new Fu();
        Zi zi = new Zi("aaa");
        System.out.println(zi.name);
    }

}

class Fu{
    String name;

    public Fu() {
    }

    public Fu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected AbstractList<String> method(){
        System.out.println("Fu method");
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }
}

class Zi extends Fu{

    public Zi(String name) {
        super(name);
    }

    @Override
    protected ArrayList<String> method() {
        System.out.println("Zi method");
        return new ArrayList<String>();
    }
}

class zi2 extends Fu{
    public zi2(String name) {
        super(name);
    }

    @Override
    protected AbstractList<String> method() {
        return super.method();
    }
}
