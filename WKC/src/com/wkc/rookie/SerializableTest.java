package com.wkc.rookie;

import java.io.*;

//序列化，又称为持久化，将其写入磁盘中
//请注意，一个类的对象要想序列化成功，必须满足两个条件：
//
//该类必须实现 java.io.Serializable 对象。
//
//该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。

public class SerializableTest {
    public static void main(String[] args){
        Employee e = new Employee();
        e.name = "Yoshina";
        e.address = "Tokyo, Japan";
        e.SSN = 11122333;
        e.number = 101;

        String filePath = "E:\\idea-workspace\\WKC\\src\\com\\wkc\\rookie\\tmp\\employee.ser";
        File file = new File(filePath);

        try{
            SerializeObject(filePath, e);
            if(!file.exists()){
                System.out.println("Serialize Object failed!");
                return;
            }

            Employee ee = (Employee)DeserializeObject(filePath);
            System.out.println(ee.name);
            System.out.println(ee.address);
            System.out.println(ee.SSN);
            System.out.println(ee.number);
            ee.mailCheck();

        }
//        catch (IOException ioex){
//            ioex.printStackTrace();
//        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //将一个对象序列化并保存到指定路径
    static void SerializeObject(String filePath, Object obj){
        try {
            FileOutputStream fo = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(obj);
            oos.close();
            fo.close();
            System.out.println("Serialized data is saved in \"" + filePath + "\"");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //将一个.ser文件反序列化得到对象
    static Object DeserializeObject(String filePath){
        Object obj = 0;
        try {
            FileInputStream fi = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fi);
            obj = ois.readObject();
            ois.close();
            fi.close();

            System.out.println("Deserialized file \"" + filePath + "\" succeed.");

        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex2){
            ex2.printStackTrace();
        }

        return obj;
    }
}

//对于一个实体类，不想将所有的属性都进行序列化，有专门的关键字 transient
//当对该类序列化时，会自动忽略被 transient 修饰的属性

class Employee implements java.io.Serializable{
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck(){
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}