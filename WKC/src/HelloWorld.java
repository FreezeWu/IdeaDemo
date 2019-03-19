import java.io.*;

public class HelloWorld {
	public static void main(String args[]) throws IOException {
//		System.out.println("Hello World!");
//		
//		Animal a = new Animal("a");
//		a.eat();
//		Carnivores c = new Carnivores("c");
//		c.eat();
//		
//		Tiger t = new Tiger("xiaohu", 1000);
//		t.getWeight();
//		t.howls();
//		
//		int i = 10;
//		int j = (i == 10)? 20: 30;
//		System.out.println("b = " + j);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input an Array: ");
		String str = br.readLine();
		String[] strArr = str.split(",");
		int[] intArr;
		intArr = new int[strArr.length];
		
		for(int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		
		QuickSort qs = new QuickSort();
		qs.quickSort(0, intArr.length - 1, intArr);
		qs.print(intArr);
		
		System.out.println("Please input a Search key: ");
		int num = (int)br.read();
		
		System.out.println("Searching " + num + "...");
		
		ArrayTest at = new ArrayTest();
		num = at.d2Array();
		
		int pos = at.binarySearch(intArr, num);
		System.out.println("The position of key is: " + pos);
	    
	}

}
