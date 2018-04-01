package AlgorithmPractice;

public class AddDigit {

	public static void main(String[] args) {
//		System.out.println(addDigit(78));
//		System.err.println(isUgly(15));
		int[] a = {1,7,9,0,2,0,4,5,0};
//		int[] b = {3 , 5 ,7};
//		merge(a,3,b,3);
//		System.out.println(isPowerOfTwo(1028));
//		System.out.println(hammingWeight(2147483647));
		moveZeroes(a);
	}
	/*
	 * ���ָ�λ��� ��Ӻ�������Ǵ�����λ���������ӣ�ֱ����󷵻�һ��ֵ
	 */
	public static int addDigit(int num){
		int sum = 0;
		while(num >= 10){
			sum += num %10;
			num = num / 10;
		}
		sum += num;
		if(sum >= 10){
			sum = addDigit(sum);
		}
		return sum;
	}
	/*
	 * �Ƿ��ǳ���
	 */
	public static boolean isUgly(int num){
		while(num > 1){
			if(num % 2 == 0){
				num = num/2;
			}else if(num % 3 == 0){
				num = num/3;
			}else if(num % 5 == 0){
				num = num/5;
			}else{
				return false;
			}
		}
		if(num == 1){
			return true;
		}
		return false;
	}
	/*
	 * �ϲ�������������
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int [] num = new int[m+n];
		int i = 0;
		int j = 0;
		int k;
		for(k=0;k<num.length;k++){
			if(i < m && j < n){
				if(nums1[i] >= nums2[j]){
					num[k] = nums2[j++];
				}else{
					num[k] = nums1[i++];
				}
			}else{
				break;
			}
			
		}
		while(i < m){
			num[k++] = nums1[i++];
		}
		while(j < n){
			num[k++] = nums2[j++];
		}
		for(int x=0;x<n+m;x++){
			nums1[x] = num[x];
		}
    }
	/*
	 * �ж�һ�����Ƿ���2�ĳ˷�
	 */
	public static boolean isPowerOfTwo(int n) {
		if(n<=0){return false;}
        while(n%2 == 0){
        	n = n/2;
        }
        if(n == 1){
        	return true;
        }
		return false;
    }
	/*
	 * ȱʧ����,
	 * ������������� - sum(int[])
	 * ��������飬����Ϊnums.length +1 , ������±��� ֵΪ �±�� num[i]
	 */
	public static int missingNumber(int[] nums) {
//        int[] a = new int[nums.length + 1];
//        for(int i=0;i<nums.length;i++){
//        	a[nums[i]]++;
//        }
//        for(int j=0;j<a.length;j++){
//        	if(a[j] == 0){
//        		return j;
//        	}
//        }
		int n = nums.length;
		int sum = ((1 + n)*n)/2;
		System.out.println(sum);
		for(int i=0;i<nums.length;i++){
			sum -= nums[i];
		}
		return sum;
    }
	/*
	 * λ1�ĸ���
	 */
	public static int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
        	if((n & 1) == 1){
	        	count++;
	        }
        	n = (n >> 1);
        }
		return count;
    }
	/*
	 * �ƶ������е�0
	 */
	public static void moveZeroes(int[] nums) {
//        int zeros = 0;
//        for(int i=0;i<nums.length;i++){
//        	if(zeros > 0){
//        		nums[i-zeros] = nums[i];
//        	}
//        	if(nums[i] == 0){
//        		zeros++;
//        	}
//        }
//		for(int i = zeros; i>0;i--){
//			nums[nums.length - i] = 0;
//		}
//		for(int i=0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
		int i=0;
		int j=0;
		for(;i<nums.length;i++){
			if(nums[j] != 0){
				j++;
			}else{
				if(nums[i] != 0){
					int t = nums[j];
					nums[j] = nums[i];
					nums[i] = t;
					j++;
				}
			}
		}
		for(int k=0;k<nums.length;k++){
			System.out.println(nums[k]);
		}
    }
}
