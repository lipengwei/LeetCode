package easy;

/**
 * ��һ���ź����������ɾ�� �ظ�Ԫ��
 * @author ����ΰ
 * leetcode 26 27
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] nums = {3,1,1,3};
		System.out.println(removeElement(nums, 3));
//		System.out.println(removeDuplicates(nums));
	}
	
	// leetcode 26
	public static int removeDuplicates(int[] nums) {
		if (nums.length==0) {
			return 0;
		}
		int j = 0;
        for(int i=0;i<nums.length;i++){
        	if (nums[i]!=nums[j]){
        		nums[++j]=nums[i];
        	} 
        }
		return ++j;
    }
	
	// leetcode 27
	public static int removeElement(int[] nums, int val) {
		
        return 0;
    }
	
}
