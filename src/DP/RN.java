package DP;

public class RN {

	public static void main(String[] args) {
		int n = 8;
		int m = 4;
//		System.out.println(m*m *((n/m)/2) );
		if(n%(2*m) == 0){
			int [] bl = new int[n+1];
			for(int i=1;i<=m;i++){
				bl[i] = -i;
			}
			for(int i=m+1;i<=n;i++){
				bl[i] = i;
			}
			
			for(int i=m+1;i<=n;i++){
				if(bl[i-m] > 0){
					bl[i] = -bl[i];
				}
			}
			int sum = 0;
			for(int i=0;i<n+1;i++){
				sum += bl[i];
			}
			System.out.println(sum);
		}
	}
	
	
	public static int Mach(){
		
		return 0;
	}
}
