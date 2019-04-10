import java.util.Random;

/**
 * @program: WKC
 * @description: 1st subject
 * @author: Freeze Wu
 * @create: 2019-03-30 09:49
 **/

public class RandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = new int[8];
        for(int i = 0; i < ints.length ; i++) {
            ints[i] = random.nextInt(10) + 1;
        }

        System.out.println("随机生成的数组为：");

        for (int i = 0; i < ints.length - 1; i++) {
            System.out.print(ints[i] + ", ");
        }

        System.out.println(ints[ints.length - 1]);

        int sum = 0;

        for(int i = 0; i < ints.length ; i++) {
            sum += ints[i];
        }

        double avg = sum / (ints.length + 0.0) ;

        System.out.println("平均值为: "+avg);
    }
}
