import java.util.ArrayList;
import java.util.Random;

public class SendRedpoc {
//    class Group{
//        String name;
//        int UsersNum;
//
//        public Group(String name, int usersNum) {
//            this.name = name;
//            UsersNum = usersNum;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getUsersNum() {
//            return UsersNum;
//        }
//
//        public void setUsersNum(int usersNum) {
//            UsersNum = usersNum;
//        }
//    }


    public static class Users{
        String username;
        double money;


        public Users(String username, double money) {
            this.username = username;
            this.money = money;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }
    }

    public static class Sender extends Users{
        public Sender(String username, double money) {
            super(username, money);
        }

        //普通红包
        public ArrayList<Double> sentCommonRedpoc(double sendMoney, int redpocNums){
            System.out.println(getUsername() + "给你发了一个普通红包，点击领取...");

            this.money -= sendMoney;

            ArrayList<Double> list = new ArrayList<>();

            double avg = sendMoney / redpocNums;
            //double mod = avg + sendMoney % redpocNums;

            for(int i = 0; i < redpocNums - 1; i++)
            {
                list.add(avg);
                sendMoney -= avg;
            }

            list.add(sendMoney);


            return  list;
        }

        //拼手气红包
        public ArrayList<Double> sentRandomRedpoc(double sendMoney, int redpocNums){
            System.out.println(getUsername() + "给你发了一个拼手气红包，点击领取...");

            this.money -= sendMoney;

            ArrayList<Double> list = new ArrayList<>();

            //double[] dArray = new double[redpocNums];

            double leftMoney = sendMoney;

            for(int i = 0; i < redpocNums - 1; i++)
            {
                list.add(i, 0.01 + (leftMoney - 0.01) * new Random().nextDouble());
                leftMoney -= list.get(i);
            }

            list.add(redpocNums - 1, leftMoney);


            return list;
        }
    }

    public static class Recivers extends Users{

        public Recivers(String username, double money) {
            super(username, money);
        }

        //收红包
        public ArrayList<Double> recRedpoc(ArrayList<Double> list){

            Double sum = 0d;
            Random r = new Random();
            int index = r.nextInt(list.size());

            while(list.get(index) == 0d)
                index = r.nextInt(list.size());

            double recMoney = list.get(index);

            this.money += recMoney;

            System.out.println(getUsername() + " 领了" + recMoney + "元, 剩余零钱" + this.money + "元");

            list.set(index, 0d);

            for(int i = 0; i < list.size(); i++)
                sum += list.get(i);

            if(sum == 0d)
                System.out.println("红包已被领完！");


            return list;


        }
    }

    public static void main(String[] args) {
        Users us = new Users("Yoshina", 1000.00);
        Sender toka = new Sender("Toka", 5000.00);

        ArrayList<Double> list = new ArrayList<>();

        list = toka.sentCommonRedpoc(200.00, 3);
        Recivers kurumi = new Recivers("Kurumi", 0);
        Recivers onigami = new Recivers("Onigami", 320);
        Recivers kotoni = new Recivers("Kotoni", 10000);
        kurumi.recRedpoc(list);
        onigami.recRedpoc(list);
        //kotoni.recRedpoc(list);


        list.clear();

        list = toka.sentRandomRedpoc(100, 3);
        kurumi.recRedpoc(list);
        onigami.recRedpoc(list);
        kotoni.recRedpoc(list);


//        System.out.println("toka send a 100 redpoc, money = " + toka.getMoney());
//        System.out.println("kurumi rec the redpoc, money = " + kurumi.getMoney());
//        System.out.println("onigami rec the redpoc, money = " + onigami.getMoney());
//        System.out.println("kotoni rec the redpoc, money = " + kotoni.getMoney());

    }
}
