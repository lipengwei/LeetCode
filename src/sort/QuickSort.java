package sort;

public class QuickSort {

	public static void main(String[] args) {
//		int [] a = {55, 41, 59, 26, 53, 58 ,97, 93};
		int [] a = {0,53,17,78,9,45,65,87,32};
//		quickSort(a, 0, a.length-1);
		heapSort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
//		int[] b = new int[a.length + 1];
//		for(int i=0;i<b.length-1;i++){
//			b[i] = a[i];
//		}
//		b[a.length] = 92;
//		adjustUp(b,b.length-1);
//		for(int i=0;i<b.length;i++){
//			System.out.println(b[i]);
//		}
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
	
	public static void selectSort(int [] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[j] < a[i]){
					int t = a[j];
					a[j] = a[i];
					a[i] = t;
				}
			}
		}
	}
	
	public static void heapSort(int [] a){

//		for(int i=(a.length-1)/2;i>0;i--){
//			adjustDown(a,i,a.length-1);
//		}
		
		for(int i=(a.length-1);i>=0;i--){
			adjustUp(a,i);
		}
	}
	//元素k的向下调整
	public static void adjustDown(int[] a, int k, int len){
		a[0] = a[k];
		for(int i=2*k;i<=len;i*=2){
			if(i<len&&a[i]<a[i+1]){
				i++;
			}
			if(a[0] >= a[i]) break;
			else{
				a[k] = a[i];
				k=i;
			}
		}
		a[k] = a[0];
	}
	
	//元素k的向上调整
	public static void adjustUp(int[] a,int k){
		a[0] = a[k];
		int i= k/2;
		while(i>0 && a[i]<a[0]){
			a[k] = a[i];
			k = i;
			i = k/2;
		}
		a[k] = a[0];
	}

}
