package DP.DP_ch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import StackQueue.TreeNode;


/*
 * leetcode 337
 */
public class HouseRobber3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode root2 = new TreeNode(1);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		
		root.left = root2;
		root.right = root3;
		
//		root2.left = root4;
		root2.right = root4;
//		System.out.println(Math.max(rob2(root), robbor(root)));
//		System.out.println(ro(root));
		int[] res = robSub(root);
	    System.out.println(Math.max(res[0], res[1]));
	}
	
	private static int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}
	
	public static int ro(TreeNode root){
		Map<TreeNode,Integer> mp = new HashMap<TreeNode,Integer>();
		return rob2(root,mp);
	}
	// 递归
	public static int rob2(TreeNode root, Map<TreeNode,Integer> mp){
		int sum = 0;
		if(root == null){
			return sum;
		}else{
			if(root.left != null){
				if(!mp.containsKey(root.left.left)){
					mp.put(root.left.left, rob2(root.left.left, mp));
				}
				if(!mp.containsKey(root.left.right)){
					mp.put(root.left.right, rob2(root.left.right, mp));
				}
				sum += mp.get(root.left.left) + mp.get(root.left.right);
			}
			if(root.right != null){
				if(!mp.containsKey(root.right.left)){
					mp.put(root.right.left, rob2(root.right.left, mp));
				}
				if(!mp.containsKey(root.right.right)){
					mp.put(root.right.right, rob2(root.right.right, mp));
				}
				sum += mp.get(root.right.left) + mp.get(root.right.right);
			}
		}
		
		if(!mp.containsKey(root.left)){
			mp.put(root.left, rob2(root.left, mp));
		}
		if(!mp.containsKey(root.right)){
			mp.put(root.right, rob2(root.right, mp));
		}
		return Math.max(root.val + sum, mp.get(root.left) + mp.get(root.right));
	}
	
	// 层次遍历
	public static int robbor(TreeNode root) {
		List<Integer> list = rob1(root);
		if(list.size() == 0){
			return 0;
		}
		if(list.size() == 1){
			return list.get(0);
		}
		if(list.size() == 2){
			return Math.max(list.get(0), list.get(1));
		}
		int [] dp = new int[list.size()];
		dp[0] = list.get(0);
		dp[1] = Math.max(dp[0], list.get(1));
		for(int i= 2;i<list.size();i++){
			dp[i] = Math.max(dp[i-2] + list.get(i), dp[i-1]);
		}
		return dp[list.size() - 1];
		
    }
	
	public static List<Integer> rob1(TreeNode root) {
        Queue<List<TreeNode>> q = new LinkedList<List<TreeNode>>();
        List<Integer> list = new ArrayList<Integer>();
        
        if(root != null){
        	List<TreeNode> li = new ArrayList<TreeNode>();
        	li.add(root);
        	q.offer(li);
        }
        
        while(!q.isEmpty()){
        	int sum = 0;
        	List<TreeNode> tree = q.poll();
        	List<TreeNode> tns = new ArrayList<TreeNode>();
        	for(TreeNode tn:tree){
        		//求上一层的和
        		sum += tn.val;
        		//存下一层的值
        		if(tn.left != null){
        			tns.add(tn.left);
        		}
        		if(tn.right != null){
        			tns.add(tn.right);
        		}
        	}
        	if(tns.size() != 0){
        		q.offer(tns);
        	}
        	if(sum != 0){
        		list.add(sum);
        	}
        }
		return list;
    }
	
}
