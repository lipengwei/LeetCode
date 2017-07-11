package easy;

/*
 * 在linkedlist 中删除一个节点
 */
public class DeleteNode237 {

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ListNode ln6 = new ListNode(6);
		ListNode ln7 = new ListNode(7);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
		ln6.next = ln7;
		deleteNode(ln3);
	}
	
	public static void deleteNode(ListNode node) {
		ListNode preNode = new ListNode(0);
		if(node.next == null){
			System.out.println("只有一个节点");
		}else{
			while(node.next != null){
	        	node.val = node.next.val;
	        	preNode = node;
	        	node = node.next;
	        }
			preNode.next = null;
		}
    }
	
	public void delete_node(ListNode node){
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
