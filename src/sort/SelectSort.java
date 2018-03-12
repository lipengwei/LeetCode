package sort;

import java.util.Scanner;

/*
 * 选择排序
 * 首先找到数组中元素最小的那个元素，
 * 其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)
 * 再次，在剩下的元素中找到最小元素，将它和第二个元素交换位置，如此往复，直到整个数组排序
 */
public class SelectSort {

	// 排序主函数
	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int min = i;
			for(int j=i+1;j<n;j++){
				if(less(a[j], a[min])){
					min = j;
				}
			}
			exch(a, i, min);
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
