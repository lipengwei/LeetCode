package AlgorithmPractice;

/*
 * leetcode 80
 */
public class removeDuplicates {

	public static void main(String[] args) {
		int [] a = {1,1,1,1,2,2,2,2,3};
		System.out.println(removeDuplicates(a));
	}
	
	public static int removeDuplicates(int[] nums) {
		int i = 0;
        for(int no:nums){
        	// 太精辟了  多看多看
        	if(i < 2 || no > nums[i-2]){
        		nums[i++] = no;
        	}
        }
        return i;
    }
}
