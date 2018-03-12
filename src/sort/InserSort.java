package sort;

import java.util.Scanner;

/*
 * �����㷨
 * ��������
 * ����ģ��
 * ˼·��Ϊ�˸�Ҫ�����Ԫ���ڳ��ռ䣬������Ҫ����������Ԫ���ڲ���֮ǰ�������ƶ�һλ(��ʵ���ǵ�һλ�������ӵڶ���λ�ÿ�ʼ����)
 * ÿ�ζ�Ҫ����Ԫ�غ��Ѿ��źõ�Ԫ�ؽ��бȽϲ��ƶ���������������(�ƶ�����) 1+2+3+4+5+...+n = o(n2)
 */
public class InserSort {
	// ����������
	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=1;i<n;i++){  // ��a[i] ���뵽 a[i-1] a[i-2] a[i-3] ֮�� 
			for(int j=i;j>0&&less(a[j], a[j-1]);j--){   // �Ƚ��ƶ��Ѿ��źõ�ǰi��Ԫ��
				exch(a,j,j-1);
			}
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
