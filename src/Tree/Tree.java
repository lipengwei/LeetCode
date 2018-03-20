package Tree;

import java.util.Scanner;

public class Tree {
	
	public static void main(String[] args) {
		System.out.println("输入N：");
		int n = new Scanner(System.in).nextInt();
		int [][] vx = new int[n][3];
		showTree(vx);
		for(int i=0;i<n-1;i++){
			String st = new Scanner(System.in).nextLine();
			int x = Integer.parseInt(st.split(" ")[0]);
			int y = Integer.parseInt(st.split(" ")[1]);
			int w = Integer.parseInt(st.split(" ")[2]);
			int parent = x<y?x:y;
			int child = x<y?y:x;
			generateTree(vx, parent, child, w, i);
		}
		showTree(vx);
		System.out.println("开始调用：");
		for(int j=0;j<n;j++){
			String st = new Scanner(System.in).nextLine();
			int x = Integer.parseInt(st.split(" ")[0]);
			int y = Integer.parseInt(st.split(" ")[1]);
			int parent = x<y?x:y;
			int child = x<y?y:x;
			System.out.println(getTreeW(vx,child,parent));
		}
	}

	public static void generateTree(int [][] vx, int parent, int child, int w, int i){
		if(i == 0){
			vx[i][0] = parent;
			vx[i][1] = -1;
			vx[i][2] = 0;
			if(i+1 <= vx.length){
				vx[i+1][0] = child;
				vx[i+1][1] = i;
				vx[i+1][2] = w;
			}
		}else{
			if(i+1 <= vx.length){
				vx[i+1][0] = child;
				vx[i+1][1] = i;
				vx[i+1][2] = w;
			}
		}
	}
	
	public static int GetParentIndex(int [][] vx, int data){
		int index = -1;
		for(int i=0;i<vx.length;i++){
			if(vx[i][0] == data){
				index = i;
			}
		}
		return index;
	}
	
	public static void showTree(int [][] vx){
		for(int i=0;i<vx.length;i++){
			System.out.print(i + ":" + vx[i][0] + " " + vx[i][1] + " " +vx[i][2]);
			System.out.println();
		}
	}
	
	public static int getTreeW(int[][] vx, int u, int v){
		int w = 0;
		int u_index = 0;
		// 假设 u > v
		for(int i=0;i<vx.length;i++){
			if(vx[i][0] == u){
				u_index = i;
			}
		}
		w = vx[u_index][2];
		while(vx[vx[u_index][1]][0] != v){
			u_index = vx[u_index][1];
			w = w>vx[u_index][2]?w:vx[u_index][2];
		}
		w = w>vx[u_index][2]?w:vx[u_index][2];
		
		return w;
	}
}
