package easy;

public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[j] == target - nums[i]){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2,7,11,16};
		int target = 9;
		Two_Sum ts = new Two_Sum();
		int[] res = ts.twoSum(nums, target);
		System.out.println(res[0] +","+ res[1]);
//		for (int j=0;j<nums.length;j++){
//			for(int i=j+1;i<nums.length;i++){
//				if (nums[i] == target-nums[j]){
//					System.out.println(j +","+i);
// 				}
//			}
//		}
	}
}