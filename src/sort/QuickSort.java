package sort;

public class QuickSort {

	public static void main(String[] args) {
		int [] a = {55, 41, 59, 26, 53, 58 ,97, 93};
		quickSort(a, 0, a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	
	public static void quickSort(int[] a, int left, int right){
		if(left >= right){
			return ;
		}
		int m = left;
		int t = a[left];
		for(int i=left+1;i<=right;i++){
			if(a[i] < t){
				int key = a[m];
				a[m] = a[i];
				a[i] = key;
				m++;
			}
		}
		System.out.println(m);
		quickSort(a, 0, m-1);
		quickSort(a, m+1, right);
	}

}
