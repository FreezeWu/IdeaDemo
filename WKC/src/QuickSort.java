
public class QuickSort {
	public void quickSort(int low, int high, int[] a) {
		int i,j,key,temp;
		
		if(low > high)
			return;
		
		i = low;
		j = high;
		
		key = a[low];
		
		//һ�ν���
		while(i < j) {
			
			//����������С��key����
			while(a[j] >= key && i < j) {
				j--;
			}
			
			//���������Ҵ���key����
			while(a[i] <= key && i < j) {
				i++;
			}
			
			//����
			if(i < j) {
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		
		a[low] = a[i];
		a[i] = key;
		
		quickSort(low, j-1, a);
		quickSort(j+1, high, a);
		
	}
	
	public void print(int[] a) {
		for(int element: a) {
			System.out.println(element);
		}
	}
	
}
