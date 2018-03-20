package Graph;

import java.util.Scanner;

/*
 * ���������Ȩͼ
 * �洢�ṹΪ�ڽӱ�
 */
public class CreateGraph {
	
	public static void main(String[] args) {
		Scanner xx = new Scanner( System.in );
		System.out.print("���붨������");
		int number = xx.nextInt();
		int [][] vx = new int[number][number];
		System.out.print("����u,v,c����");
		for(int i=number-1;i>0;i--){
			Scanner xx1 = new Scanner( System.in );
			String st = xx1.nextLine();
			int x = Integer.parseInt(st.split(" ")[0]);
			int y = Integer.parseInt(st.split(" ")[1]);
			int w = Integer.parseInt(st.split(" ")[2]);
			vx[x-1][y-1] = w;
			vx[y-1][x-1] = w;
		}
		getVx(vx);
		for(int j=5;j>0;j--){
			String st = new Scanner(System.in).nextLine();
			int x = Integer.parseInt(st.split(" ")[0]);
			int y = Integer.parseInt(st.split(" ")[1]);
			printVx(vx,x-1,y-1);
		}
		
	}
	public static void getVx(int [][] vx){
		for(int i = 0;i<vx[0].length;i++){
			for(int j=0;j<vx[i].length;j++){
				System.out.print(vx[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printVx(int[][] vx,int x,int y){
		System.out.println(vx[x][y]);
	}

}
