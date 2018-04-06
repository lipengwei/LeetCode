package AlgorithmPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * ͼ��������� ��������㷨
 */
public class BFS_DFS {
	//5*5 ����
//	public static int [][] matrix = {{0,1,0,1,0},{1,0,1,0,1},{0,1,0,1,1},{1,0,1,0,0},{0,1,1,0,0}};
	public static int [][] matrix = {{0,1,1,0,0,0,0,0},
									{1,0,0,1,1,0,0,0},
									{1,0,0,0,0,1,1,0},
									{0,1,0,0,0,0,0,0},
									{0,1,0,0,0,0,0,1},
									{0,0,1,0,0,0,0,0},
									{0,0,1,0,0,0,0,0},
									{0,0,0,0,1,0,0,0}};
	public static int [] visited = new int[8];
	public static String[] nodes = {"a","b","c","d","e","f","g","h"};
	public static void main(String[] args) {
//		BFS(matrix, 2);
		for(int i = 0;i<8;i++){
			if(visited[i] != 1){
				DFS(matrix, i);
			}
		}
	}
	
	public static void BFS(int[][] matrix, int start){
		// linkedListʵ����queue�ӿ�
		int [] visited = new int[5];
		Queue<Integer> queue = new LinkedList<Integer>();
//		int begin = nodes[start];
		visited[start] = 1;
		// �����
		queue.offer(start);
		while(!queue.isEmpty()){
			// ������
			int e = queue.poll();
			System.out.println(e+1);
			for(int i=0;i<matrix.length;i++){
				if(matrix[e][i] == 1){
					if(visited[i] != 1){
						queue.offer(i);
						visited[i] = 1;
					}
				}
			}
		}
	}
	
	public static void DFS(int[][] matrix, int start){
		visited[start] = 1;
		System.out.println(nodes[start]);
		for(int i=0;i<matrix.length;i++){
			if(matrix[start][i] == 1 && visited[i] != 1){
				DFS(matrix,i);
			}
		}
	}
}
