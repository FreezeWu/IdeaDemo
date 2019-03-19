public class ObjectArray
{
    public static  void  main(String args[]){
        Person[] array = {new Person("FuWang", 16), new Person("ShouWang", 12),
        new Person("ZhuZai", 18)};

        System.out.println(array[0].getName());
    }
}
