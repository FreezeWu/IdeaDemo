package com.wkc.work.Day03_ListAndSet;

import java.util.*;

/**
 * @program: WKC
 * @description: 03
 * @author: Freeze Wu
 * @create: 2019-04-07 15:09
 **/

public class Homework03 {
    public static void main(String[] args) {
        Set<String> beauty = new LinkedHashSet<>();
        beauty.add("王昭君");
        beauty.add("王昭君");
        beauty.add("西施");
        beauty.add("杨玉环");
        beauty.add("貂蝉");

        Iterator<String > it = beauty.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for(String str : beauty){
            System.out.println(str);
        }

        System.out.println("------------------------------------------");

        //十、已知数组存放一批QQ号码，QQ号码最长为11位，
        //最短为5位String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。
        //将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，
        //将list中所有元素分别用迭代器和增强for循环打印出来。

        String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
        List<String> list = new LinkedList<>();
        for(String s : strs){
            list.add(s);
        }

        System.out.println(list);

        //通过将list存放到linkedhashset里来去重
        Set<String> set = new LinkedHashSet<>();
        set.addAll(list);

        //去重后重新存放到list中
        list.clear();
        list.addAll(set);

        System.out.println(list);

        System.out.println("------------------------------------------");

        //十一、键盘录入一个字符串，去掉其中重复字符，
        //打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd。

//        System.out.println("请输入一个字符串：");
//        String inputString = new Scanner((System.in)).next();
//        char[] chars = inputString.toCharArray();
//
//        Set<Character> charSet = new LinkedHashSet<>();
//
//        for(Character c : chars){
//            charSet.add(c);
//        }
//
//        System.out.println(charSet);
//
//        System.out.println("------------------------------------------");

        //十二、双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
        //红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）

        Set<Integer> redBalls = new LinkedHashSet<>();

        int redBall = 0;

        //生成一组随机红球号码
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            redBall = r.nextInt(33) + 1;
            if(redBalls.contains(redBall)){
                i--;
                continue;
            }else {
                redBalls.add(redBall);
            }

        }

        //将红球号码放入list中
        List<Integer> dBalls = new ArrayList<>();
        dBalls.addAll(redBalls);
        Collections.sort(dBalls);

        //生成蓝球号码
        int blueBall = new Random().nextInt(16) + 1;

        dBalls.add(blueBall);

        System.out.println(dBalls);

        System.out.println("------------------------------------------");

        //十三、分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，
        //如果成绩一样，那在成绩排序的基础上按照年龄由小到大排序。
        //姓名（String）	年龄（int）	分数（float）
        //liusan	    20	        90.0F
        //lisi	        22	        90.0F
        //wangwu	    20	        99.0F
        //sunliu	    22	        100.0F

        Student s1 = new Student("liusan",20 ,90.0F);
        Student s2 = new Student("lisi",22 ,90.0F);
        Student s3 = new Student("wangwu",20 ,99.0F);
        Student s4 = new Student("sunliu",22 ,100.0F);

        ArrayList<Student> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);

        //类内部重写CompareTo方法排序
        Collections.sort(al);
        System.out.println("成绩升序，年龄降序：");
        for(Student s : al){
            System.out.println(s);
        }

        //实现Comparator接口实现类自定义排序
        Collections.sort(al, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int i = (int)(s2.getGrade() - s1.getGrade());

                if(i == 0){
                    int j = s1.getAge() - s2.getAge();
                    return j;
                }
                else {
                    return i;
                }
            }
        });

        //使用lambda表达式实现函数式接口
//        Collections.sort(al, (o1, o2) -> (int)((o2.getGrade() - o1.getGrade() == 0) :
//        (o2.getGrade() - o1.getGrade()) ? (s2.getGrade() - s1.getGrade()));

        Collections.sort(al, (o1, o2) -> (int)(o2.getGrade() - o1.getGrade()));

        System.out.println("成绩降序，年龄升序：");
        for(Student s : al){
            System.out.println(s);
        }

    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;
    private float grade;

    public Student(String name, int age, float grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int i = (int)(this.getGrade() - o.getGrade());
        if(i == 0){
            int j = o.getAge() - this.getAge();
            return j;
        }else {
            return i;
        }

    }
}
