package com.wkc.demo;

import java.util.ArrayList;

public class ArrayTest {
    public static class Car{
        private String name;
        private int price;

        public Car(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Car[] cars = {new Car("Taxi",10000 ), new Car("Tank", 100000), new Car("Benz", 50000)};

        for(Car element : cars){
            System.out.println(element.getName() + " " + element.getPrice());
        }

//        int[][] array = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
//
//        for(int[] element : array){
//            for (int elements : element){
//                System.out.println(elements);
//            }
//        }

//        Integer[] integers = {new Integer(1), new Integer("1111"),};
//
//        for(Integer element : integers){
//            System.out.println(element);
//        }
//
        Integer i = new Integer(5);



        ArrayTest arrayTest = new ArrayTest();
        arrayTest.passInteger(i);

        System.out.println(i);

        int[] array = {1};
        arrayTest.passArray(array);
        for(Integer element : array){
            System.out.println(element);
        }

    }

    public void passInteger(Integer i){
        i = 10;
    }

    public void passArray(int[] array){
        array[0] = 4;
    }


}
