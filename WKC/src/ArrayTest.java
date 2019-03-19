
public class ArrayTest {
	public void CreateArr() {
		int[] a;
		a = new int[5];
		int[] b = {1, 2, 3, 5, 4};
		String[] s = {"a", "b", "c"};
		
		double d = Double.parseDouble(s[0]);
		
	}
	
	public int binarySearch(int[] a, int num) {
		if(a.length == 0)
			return -1;
		
		int startPos = 0;
		int endPos = a.length - 1;
		int m = (startPos + endPos) / 2;
		
		while(startPos <= endPos) {
			if(a[m] == num) {
				return m;
			}
			if(a[m] > num) {
				endPos = m - 1;
			}
			if(a[m] < num) {
				startPos = m + 1;
			}
			
			m = (startPos + endPos) / 2;
		}
		
		return -1;
		
		
		
	}
	
	public int d2Array() {
		int[][] a = {{1,2}, {3,4,5}, {6,7}};
		
		int num = a[0][0];
		
		return num;
	}
	
	public void arrayCopy() {
		String[] s = {"Taeyeon", "Tiffany", "Seoyeon"};
		
		String[] sCopy = new String[4];
		
		System.arraycopy(s, 0, sCopy, 0, s.length);
	}

}
