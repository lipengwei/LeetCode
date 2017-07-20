package easy;

/*
 * ��֤listnode�Ƿ��ǻ���
 * leetcode 234
 */
public class PalindromeListNode {

	public static void main(String[] args) {
		ListNode t = new ListNode(1);
		ListNode t2 = new ListNode(4);
		ListNode t3 = new ListNode(-1);
		ListNode t4 = new ListNode(-1);
		ListNode t5 = new ListNode(4);
		ListNode t6 = new ListNode(1);
		t.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;
//		t5.next = t6;
//		while(t != null){
//			System.out.println(t.val);
//			t = t.next;
//		}
		System.out.println(isPalindrome(t));
	}
	
	public static boolean isPalindrome(ListNode head){
		if(head == null || head.next == null) return true;
		// �����м�ڵ� �� slow �� ��slow��next�ڵ㿪ʼ �������
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		// ����һ�� ��벿�ֵ������
//		ListNode target = null;
//		ListNode tt = null;
//		slow = slow.next;
//		while(slow != null){
//			tt = slow.next;
//			slow.next = target;
//			target = slow;
//			slow = tt;
//		}
//		while(target != null){
//			if(head.val == target.val){
//				target = target.next;
//				head = head.next;
//				continue;
//			}else{
//				return false;
//			}
//		}
//		return true;
		
		// ������ 
		slow = slow.next;
		ListNode prev = null;
		ListNode latter = slow.next;
		while(slow != null){
			slow.next = prev;
			prev = slow;
			slow = latter;
		}
		return false;
	}
}
