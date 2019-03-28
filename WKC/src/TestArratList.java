import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestArratList {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();

        Random r = new Random();
        for(int i = 0; i <= 6; i++)
            list.add(r.nextInt(33) + 1);



        System.out.println(list);

        int[] array = {1,2,3,4};
        String str = strTest(array);
        System.out.println(str);

        Scanner sc = new Scanner(System.in);
        String str2 = sc.next();
        types(str2);

    }

    public static String strTest(int[] array){
        String str = "[";
        for(int i = 0; i <= array.length - 1; i++)
        {
            if(i != array.length - 1)
                str += "word" + array[i] + "#";
            else
                str += "word" + array[i] + "]";

        }

        return str;
    }

    public static void types(String str){
        int countLower = 0,countUpper = 0,countNum = 0,countChar = 0;

        String[] strArray;
        strArray = str.split("");
        for(int i = 0; i <= strArray.length - 1; i++){
            if(strArray[i].matches("[A-Z]"))
                countUpper++;
            else if(strArray[i].matches("[a-z]"))
                countLower++;
            else if(strArray[i].matches("[0-9]"))
                countNum++;
            else
                countChar++;

        }

        System.out.println("The String contains UpperCase characters: " + countUpper);
        System.out.println("The String contains LowerCase characters: " + countLower);
        System.out.println("The String contains Number characters: " + countNum);
        System.out.println("The String contains Char characters: " + countChar);
    }

}
