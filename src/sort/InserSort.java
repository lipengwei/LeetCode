package sort;

import java.util.Scanner;

/*
 * 排序算法
 * 插入排序
 * 基础模板
 * 思路：为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位(其实就是第一位不动，从第二个位置开始遍历)
 * 每次都要把新元素和已经排好的元素进行比较并移动，所有最坏的情况是(移动次数) 1+2+3+4+5+...+n = o(n2)
 */
public class InserSort {
	// 排序主函数
	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=1;i<n;i++){  // 将a[i] 插入到 a[i-1] a[i-2] a[i-3] 之中 
			for(int j=i;j>0&&less(a[j], a[j-1]);j--){   // 比较移动已经排好的前i个元素
				exch(a,j,j-1);
			}
		}
	}
	// 小于
	public static boolean less(Comparable v,Comparable w){
		return (v.compareTo(w) < 0);
	}
	// 交换
	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	// 展示
	public static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	// 是否有序
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i], a[i-1])){
				return false;
			}
		}
		return true;
	}
	//
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ast = in.nextLine();
		String[] a = ast.split(" ");
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
