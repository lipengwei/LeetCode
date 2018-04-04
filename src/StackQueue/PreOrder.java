package StackQueue;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
	public static List<Integer> li = new ArrayList<Integer>();
	public static void main(String[] args) {

	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<Integer>();
		SaveToList(root, li);
        return li;
    }
	 
    public static void SaveToList(TreeNode root, List<Integer> list){
		if(root != null){
			list.add(root.val);
            SaveToList(root.left, list);
            SaveToList(root.right, list);
        }
	}
}
