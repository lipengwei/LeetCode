package easy.day2;

/*
 * leetcode 273
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglish {

	public static void main(String[] args) {
        System.out.println(numberToWords(123456789).trim());
	}
	
	public static String numberToWords(int num) {
		int[] intDict = {1000000000, 1000000, 1000, 100};
		int[] smallDict = {90, 80, 70, 60, 50, 40, 30, 20};
		String[] romanDict = {"Billion", "Million", "Thousand", "Hundred", };
		String[] smallEn = {"Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty"};
		String[] singleEn = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		if(0 <= num && num < 20){
			for(int k=1;k<=19;k++){
				if(k == num){
					return " " + singleEn[k-1];
				}
			}
		}else if(20 <= num && num < 100){
			for(int j=0;j<smallDict.length;j++){
				if(smallDict[j] <= num){
					return " " + smallEn[j] + numberToWords(num % smallDict[j]);
				}
			}
		}else{
			for(int i=0;i<intDict.length;i++){
	        	if(intDict[i] <= num){
	        		int del = num / intDict[i];
	        		return numberToWords(del) + " " + romanDict[i] + "" + numberToWords(num % intDict[i]);
	        	}
	        }
		}
		return "";
    }
}
