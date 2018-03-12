package easy.day2;
/*
 * 归并算法的流程
 * 先写好框架
 * 在讨论一般状况 a[low...mid] a[mid+1...hign]的逆序数统计方法
 * 这里面的关键是：从数组的最有一个元素开始计算，两个子序列都是有序的，如果左边大于右边中间一个元素，那么剩下的mid+1..中间 的就不用计算了，直接就能得到逆序数
 * 递归算法，还是要熟悉
 */
public class InverseRairs {
	public static int count = 0;
	
	public static void main(String[] args) {
		int [] a = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
//		int [] a = {6,3,4,9,2};
		int [] b = new int[a.length];
		
		for(int n=0;n<a.length;n++){
			b[n] = a[n];
		}
		
		System.out.println(InversePairs(a));
		System.out.println(mergeSort(a, b, 0, a.length-1));
	}
	
	public static int InversePairs(int [] array){
		int sum1 = 0;
		for (int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[j] > array[i]){
					sum1+= 1;
				}
			}
		}
		return sum1;
	}
	
	public static int merge(int[] a, int [] b, int start, int mid, int end){
		int sum = 0;
		int i,j,k;
		//求逆序数对
		for(i=mid,j=end,k=end;i>=start && j>=mid+1;k--){
			if(b[i] < b[j]){
				a[k] = b[j--];
			}else{
				sum += j-mid;
				// 这里可能会溢出，所以这里是关键啊，要小心
				if(sum >=1000000007){
                    sum %=1000000007;
                }
				a[k] = b[i--];
			}
		}
		while(i>=start) a[k--] = b[i--];
		while(j>mid) a[k--] = b[j--];
		//排序
//		for(i=start,j=mid+1,k=i;i<=mid && j<=end;k++){
//			if(b[i] < b[j]){
//				a[k] = b[i++];
//			}else{
//				a[k] = b[j++];
//			}
//		}
//		while(i <= mid){
//			a[k++] = b[i++];
//		}
//		while(j <= end) a[k++] = b[j++];
		//排序好的a赋值给b
		for(int n=0;n<a.length;n++){
			b[n] = a[n];
		}
		return sum;
	}

	public static int mergeSort(int[] a, int [] b, int start, int end){
		if(start == end) return 0;
        int mid = (start + end)/2;
        
        int left = mergeSort(a,b,start,mid);
        int right = mergeSort(a,b,mid+1,end);
        int sum = 0;
        int i,k,j;
        
        for(i=mid,j=end,k=end;i>=start && j>=mid+1;k--){
            if(a[i] < a[j]){
                b[k] = a[j--];
                // a[k] = b[j--];
            }else{
                sum += j-mid;
                b[k] = a[i--];
            }
        }
        
        while(i>=start) b[k--] = a[i--];
        while(j>mid) b[k--] = a[j--];
        for(int n=0;n<a.length;n++){
            a[n] = b[n];
        }
        return (left + right + sum);
	}
}
