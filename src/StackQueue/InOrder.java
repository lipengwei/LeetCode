package StackQueue;

import java.util.ArrayList;
import java.util.List;
/*
 * ÷––Ú≈≈¡–
 */
public class InOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<Integer>();
		SaveToList(root, li);
        return li;
    }
	 
    public static void SaveToList(TreeNode root, List<Integer> list){
		if(root != null){
            SaveToList(root.left, list);
            list.add(root.val);
            SaveToList(root.right, list);
        }
	}
}
