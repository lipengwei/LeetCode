package sort;

import java.util.Scanner;

/*
 * ѡ������
 * �����ҵ�������Ԫ����С���Ǹ�Ԫ�أ�
 * ��Σ�����������ĵ�һ��Ԫ�ؽ���λ��(�����һ��Ԫ�ؾ�����СԪ����ô���ͺ��Լ�����)
 * �ٴΣ���ʣ�µ�Ԫ�����ҵ���СԪ�أ������͵ڶ���Ԫ�ؽ���λ�ã����������ֱ��������������
 */
public class SelectSort {

	// ����������
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
	// С��
	public static boolean less(Comparable v,Comparable w){
		return (v.compareTo(w) < 0);
	}
	// ����
	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	// չʾ
	public static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	// �Ƿ�����
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
