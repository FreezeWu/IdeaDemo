package com.wkc.work.Day04_Map;

import java.util.*;

/**
 * @program: WKC
 * @description: 04
 * @author: Freeze Wu
 * @create: 2019-04-07 14:24
 **/

public class Homework04 {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap();
        hm.put(1, "Taeyeon");
        hm.put(2, "Tiffany");
        hm.put(3, "Seoyeon");

        for(String s : hm.values()){
            System.out.println(s);
        }

        Iterator it = hm.values().iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("------------------------------------------");

        HashMap<Car, Integer> carMap = new HashMap<>();
        Car benz = new Car("Benz", 1000000);
        Car martin = new Car("Martin", 2000000);
        Car tesila = new Car("Tesila", 800000);
        //Car类重写了equals和hashcode方法之后，name和price相同的car对象放入hashmap之后会被当作同一类型
        Car tesila2 = new Car("Tesila", 800000);

        carMap.put(benz, benz.getPrice());
        carMap.put(martin, martin.getPrice());
        carMap.put(tesila, tesila.getPrice());
        carMap.put(tesila2, tesila2.getPrice());    //覆盖原来的tesila对象Key

        Iterator carKey = carMap.keySet().iterator();
        Iterator carEntry = carMap.entrySet().iterator();

        while (carKey.hasNext()){
            System.out.println(carKey.next());
        }

        while (carEntry.hasNext()){
            System.out.println(carEntry.next());
        }

        System.out.println("------------------------------------------");

        String[] provinces = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] cities = {"哈尔滨","杭州","南昌","广州","福州"};

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < provinces.length; i++) {
            map.put(provinces[i], cities[i]);
        }

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.print(entry + ", ");
        }

        System.out.println();
        System.out.println("------------------------------------------");

        //八、定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
        //例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。

        List<String> list = new ArrayList<>();
        list.add("aabbcc");
        list.add("bbccdd");
        list.add("1234");

        Map<Character, Integer> charsMap = new LinkedHashMap<>();

        String str = "";

        Iterator<String> listIt = list.listIterator();
        while (listIt.hasNext()){
            str += listIt.next();
        }

        System.out.println(str);
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length ; i++) {
            int j = 1;  //第一次添加字符

            //如果字符已放入，获取之前的value并++
//            if(charsMap.get(chars[i]) != null) {
            if(charsMap.containsKey(chars[i])) {
                j = charsMap.get(chars[i]);
                j++;
            }
            charsMap.put(chars[i], j);
        }

        for(Map.Entry<Character, Integer> entry : charsMap.entrySet()){
            System.out.println(entry);
        }

        System.out.println("------------------------------------------");

        //九、利用Map，完成下面的功能：
        //从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队。如果该年没有举办世界杯，则输出：没有举办世界杯。
        //tips:参阅Map接口containsKey(Object key)方法

//        String[] years = {"1930", "1934", "1938", "1950", "1954", "1958",
//        "1962", "1966", "1970", "1974", "1978", "1982", "1986", "1990"};

        String[] champions = {"乌拉圭", "意大利", "意大利", "乌拉圭", "西德", "巴西", "巴西", "英格兰", "巴西", "西德",
        "阿根廷", "意大利", "阿根廷", "西德", "巴西", "法国", "巴西", "意大利", "西班牙", "德国", "法国"};

        Map<String, String> worldCup = new LinkedHashMap<>();

        worldCup.put("1930", champions[0]);
        worldCup.put("1934", champions[1]);
        worldCup.put("1938", champions[2]);

        for (int i = 3; i < champions.length; i++) {
            worldCup.put(Integer.toString(1950 + 4*(i - 3)), champions[i]);

        }

        //System.out.println(worldCup);

        Scanner sc = new Scanner((System.in));
        System.out.println("请输入一个年份: ");
        String inputYear = sc.next();

        if(worldCup.containsKey(inputYear)){
            System.out.println("这一年的世界杯冠军是: " + worldCup.get(inputYear));
        }
        else {
            System.out.println("这一年没举办世界杯");
        }

        System.out.println("请输入一个国家：");
        String inputCountry = sc.next();
        int times = 0;
        StringBuilder years = new StringBuilder();

        if(worldCup.containsValue(inputCountry)){
            for(String s : worldCup.keySet()){
                if(worldCup.get(s).equals(inputCountry)) {
                    times++;
                    years.append(s + " ");
                }
            }
            System.out.println(inputCountry + "拿过" + times + "次世界杯冠军，分别是：");
            System.out.println(years);

        }
        else {
            System.out.println("这个国家没有拿过世界杯冠军");
        }

    }
}

class Car{
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price);
    }
}
