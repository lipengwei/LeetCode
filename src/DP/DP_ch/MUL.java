package DP.DP_ch;

import java.util.Scanner;

public class MUL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int [] a = new int[t];
		for(int i=0;i<t;i++){
			a[i] = sc.nextInt();
		}
		
		for(int j=0;j<t;j++){
			judge(a[j]);
		}
	}
	
	public static void judge(int n){
		if(n%2 == 1){
			System.out.println("No");
		}else{
			int i = 2;
			while((n/i)%2 == 0){
				i=i*2;
				n =n/2;
			}
			System.out.println((n/i)+ " " + i);
		}
	}
	
	public static void gets(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] ints = new long[n];
        for(int i=0;i<n;i++){
            ints[i] = sc.nextLong();
        }

        for (long x : ints){
            if (x%2 == 0){
                long init = x ;
                long ext = 2;
                while ((x/2) % 2==0){
                    ext = ext *2;
                    x = x/2;
                }
                System.out.println( (init / ext)+" "+ ext);
            }else {
                System.out.println("No");
            }

        }
	}
}
