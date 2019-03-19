import java.io.*;
import java.util.*;

public class IsNod {
	public boolean isNod(int a) {
		return (a & 1) == 1;	//位运算比取余效率高
		//return a % 2 == 1;	//编译器自动将取余运算转换为位运算
	}
	
	public static void main(String args[]) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input a number: ");
		int num = sc.nextInt();
		
		//int num = br.read();
		
		System.out.println(num);
		
		IsNod in = new IsNod();
		if(in.isNod(num))
			System.out.println("the number is nod.");
		else
			System.out.println("the number is not nod.");
		
		
	}

}
