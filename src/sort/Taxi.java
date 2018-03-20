package sort;

public class Taxi {

	public static void main(String[] args) {
		int [] a = {1,2,4,3,3,2,1,2};
		int no_1 = 0;
		int no_2 = 0;
		int no_3=0,no_4=0;
		int no = 0;
		for(int i=0;i<a.length;i++){
			if(a[i] == 1){
				no_1 += 1;
			}else if(a[i] == 2){
				no_2 += 1;
			}else if(a[i] == 3){
				no_3 += 1;
			}else if(a[i] == 4){
				no_4 += 1;
			}
		}
		no += no_4;
		if((no_3 - no_1) > 0){
			no += no_3;
			if(no_2 % 2 == 0){
				no = no + no_2/2;
			}else{
				no = no + no_2/2 + 1;
			}
		}else{
			no += no_3;
			no_1 -= no_3;
			if(no_2 % 2 == 0){
				no += no_2/2;
				no = no + no_1 / 4 + (no_1 % 4 == 0?0:1) ; 
			}else{
				if(no_1 > 2){
					no = no + 1 + no_1 / 4 + (no_1 % 4 == 0?0:1);
				}else{
					no += 1;
				}
			}
			
		}	
		System.out.println(no);
	}
	
}
