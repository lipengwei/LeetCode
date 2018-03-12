package easy.day2;

public class MergeSort {

	public static void main(String[] args) {
		int[] array={6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
//		int [] array = {1,1,1,1,0,1};
		System.out.println(minNumberInRotateArray(array));
	}
	
	public static int minNumberInRotateArray(int [] array) {
		if(array.length == 0) return 0;
		int left = 0;
		int right = array.length -1;
		int mid = -1;
		while(left < right){
			mid = left + (right - left)/2;
			if(array[mid] > array[right]){
				left = mid + 1;
			}else if(array[mid] == array[right]){
				right--;
			}else{
				right = mid - 1;
			}
		}
		return array[left];
	}
	 
	public static int InversePairs(int [] array) {
		if(array.length == 0||array == null){
			return 0;
		}
		int[] copy = new int[array.length];
		for(int i=0;i<array.length;i++){
			copy[i] = array[i];
		}
		int count = InversePairsCore(array, copy,0,array.length - 1)%1000000007;
		return count;
	}
	
	public static int InversePairsCore(int[] array, int [] copy, int low, int high){
		if(low == high) return 0;
		int mid = (low + high) >> 1;
		int leftCount = InversePairsCore(array, copy,low, mid)%1000000007;
		int rightCount = InversePairsCore(array, copy, mid+1, high)%1000000007;
		int count = 0;
		int i=mid;
		int j=high;
		int locCopy = high;
		while(i>= low && j>mid){
			if(array[i] > array[j]){
				count += j-mid;
				copy[locCopy--] = array[i--];
				if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
			}else{
				copy[locCopy--] = array[j--];
			}
		}
		
		for(;i>=low;i--){
			copy[locCopy--]=array[i];
		}
		for(;j>mid;j--){
			copy[locCopy--] = array[j];
		}
		for(int s = low;s<=high;s++){
			array[s] = copy[s];
		}
		return (leftCount+rightCount+count)%1000000007;
	}
}
