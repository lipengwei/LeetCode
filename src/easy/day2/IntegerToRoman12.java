package easy.day2;

/*
 * 数字转罗马数字
 * 
 */
public class IntegerToRoman12 {
	public static final int[] intDict = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] romanDict = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	public static void main(String[] args) {
		System.out.println(intToRoman_1(3898));
	}
	
	public static String intToRoman(int num){
		String[][] RomanDict = new String[][] {
            { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
            { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
            { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
            { "", "M", "MM", "MMM", "", "", "", "", "", "", "" },
        };

        return RomanDict[3][num / 1000] + 
            RomanDict[2][num % 1000 / 100] +
            RomanDict[1][num % 100 / 10] +
            RomanDict[0][num % 10];
	}
	
	public static String intToRoman_1(int num) {
        for (int i = 0; i < intDict.length; i++) {
        	System.out.println(i + "---"+intDict[i]);
            if (intDict[i] <= num) {
                return romanDict[i] + intToRoman_1(num - intDict[i]);
            }
        }
        return ""; // Note the return statement
    }
}
