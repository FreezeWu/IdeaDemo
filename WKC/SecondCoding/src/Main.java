/**
 * @program: WKC
 * @description: 2nd subject
 * @author: Freeze Wu
 * @create: 2019-03-30 10:04
 **/

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财");
        dog.goPlay();
    }
}

abstract class Animal{
    String name;

    abstract void speak(String str);
}

interface Sports{
    void swimming();
}

class Dog extends Animal implements Sports{
    public Dog(String name) {
        this.name = name;
    }

    @Override
    void speak(String str) {
        System.out.println(this.name + "说： " + str);
    }

    @Override
    public void swimming() {
        System.out.println(this.name + "狗刨中！");
    }

    void goPlay(){
        speak("！");
        swimming();
    }


}


