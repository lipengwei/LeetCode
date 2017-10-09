
public class Tests {

	public static void main(String[] args) {
		String str = "24.56";
		String [] ar = str.split("\\.");
		for(int i=0;i<ar.length;i++){
			System.out.println(ar[i]);	
		}
		
	}
	
	public static void next(char[] a){
		int[] b = new int[12];
		b[1] = 0;
		int j=1,k=0;
		while(j<a[0]){
			if((k==0 ||a[j]==a[k])){
				j++;
				k++;
				b[j]=k;
			}else{
				k=b[k];
			}
		}
		for(int i=1;i<=12;i++){
			System.out.println(b[i]);
		}
	}
}
