package StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 二叉树的广度优先搜索 层次遍历 使用队列的数据结构
 */
public class BFS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		
		root.left = root2;
		root.right = root3;
		
		root2.left = root4;
		root2.right = root5;
		System.out.println(levelOrder(root));
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<List<TreeNode>> q = new LinkedList<List<TreeNode>>();
		if(root == null){
			return list;
		}
		// 加入第一个元素
		List<TreeNode> li = new ArrayList<TreeNode>();
		li.add(root);
		q.offer(li);
		//
		List<Integer> listVal = new ArrayList<Integer>();
		listVal.add(root.val);
		list.add(listVal);
		
		while(!q.isEmpty()){
			// 出对列
			List<TreeNode> listTn = q.poll();
			List<TreeNode> childNodes = new ArrayList<TreeNode>();
			//
			List<Integer> listVals = new ArrayList<Integer>();
			for(TreeNode tn:listTn){
				if(tn.left != null){
					childNodes.add(tn.left);
					listVals.add(tn.left.val);
				}
				if(tn.right != null){
					childNodes.add(tn.right);
					listVals.add(tn.right.val);
				}
			}
			//入队
			if(childNodes.size() != 0){
				q.offer(childNodes);
				list.add(listVals);
			}
		}
		
        return list;
    }

}
