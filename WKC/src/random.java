import java.util.*;
public class random {
	public static void main(String args[]) {
		Random r = new Random();
		int key = r.nextInt(100);
		
		System.out.println("please input a number:");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num < 0 && num >= 100)
			System.out.println("num is out of range");
		
		
		while(num != key) {
			if(num > key)
				System.out.println("num too big, please re-input");
			else
				System.out.println("num too small, please re-input");
			
			num = sc.nextInt();
		}
		
		
		System.out.println("You are Right! The key is " + key);
	}

}
