package DP;

public class DynamicProgram {
	public static void main(String[] args) {
		int [] array = {31,-41,59,26,-53,58,97,-93,-23,84};
		System.out.println(dynamicP_1(array));
		System.out.println(dynamicP_2(array));
		System.out.println(dynamicP_3(array, 0, array.length -1));
		System.out.println(dynamicP_4(array));
	}
	
	public static int dynamicP_1(int [] a){
		int maxSum = 0;
		int sum;
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				sum = 0;
				for(int k=i;k<=j;k++){
					sum += a[k];
				}
				if(sum > maxSum){
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
	
	public static int dynamicP_2(int [] a){
		int maxSum = 0;
		int sum;
		for(int i=0;i<a.length;i++){
			sum = 0;
			for(int j=i;j<a.length;j++){
				sum += a[j];
				if(sum > maxSum){
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
	
	public static int dynamicP_3(int [] a, int left, int right){
		if(left == right){
			if(a[left] > 0) return a[left];
			else return 0;
		}
	    // 递归, 二分法的结构
		int center = (left + right) >> 1;
	    int maxLeftSum = dynamicP_3(a, left, center);
	    int maxRightSum = dynamicP_3(a, center+1, right);
	    
	    int maxLeftBorderSum = 0;
	    int leftBorderSum = 0;
	    
	    for(int i=center; i>= left; i--){
	    	leftBorderSum += a[i];
	    	if(maxLeftBorderSum < leftBorderSum){
	    		maxLeftBorderSum = leftBorderSum;
	    	}
	    }
	    
	    int maxRightBorderSum = 0;
	    int rightBorderSum = 0;
	    
	    for(int i = center+1; i <= right;i++){
	    	rightBorderSum += a[i];
	    	if(maxRightBorderSum < rightBorderSum){
	    		maxRightBorderSum = rightBorderSum;
	    	}
	    }
	    
	    int maxBorderSum = maxLeftBorderSum + maxRightBorderSum;
	    
		return maxBorderSum > maxLeftSum ? (maxBorderSum > maxRightSum ? maxBorderSum:maxRightSum) :
			(maxLeftSum > maxRightSum?maxLeftSum:maxRightSum);
	}
	
	public static int dynamicP_4(int [] a){
		if(a.length == 0){
			return 0;
		}
		if(a.length == 1){
			if(a[0] < 0) return 0;
			else return a[0];
		}
		int sum = 0;
		int maxSum = 0;
		for(int i=0;i<a.length;i++){
			sum += a[i];
			if(maxSum < sum){
				maxSum = sum;
			}else if(sum < 0){
				sum = 0;
			}
		}
		return maxSum;
	}
}
