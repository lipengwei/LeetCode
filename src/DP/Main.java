package DP;

import java.util.Scanner;
import java.util.regex.Pattern;
/*
 * 阿里在线编程题，压缩数据发，停车场同时停车数量
 */
public class Main {

    private static final String carSplit =";";
    private static final String timeSplit =",";
    private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";
    
    public static void main(String[] args) {
        String inString = null;
        // 数据输入
        Scanner in = new Scanner(System.in);
        inString = in.nextLine();
        //字符串数组格式校验
        Pattern pat = Pattern.compile(regress);
        if(inString == null || inString.trim().equals("")||!pat.matcher(inString).matches()){
            System.out.println("输入错误!");
            return;
        }
        Main sol = new Main();
        int countCars = sol.countCars(sol.convertToArray(inString));
        System.out.println(countCars);
    }

    //输入字符串转数组
    public int[][] convertToArray(String str) {
        String[] strArray = str.split(carSplit);
        int row = strArray.length;
        int col = 2;
        // 字符转数组判断
        int[][] carArray = new int[row][col];
        int start,end;
        for (int i = 0; i < row; i++) {
            start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
            end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
            if(start>end){
                continue;
            }
            carArray[i][0] = start;
            carArray[i][1] = end;
        }
        return carArray;
    }
    //核心算法实现
    public int countCars(int[][] carArray) {
        int ans = 0;
        int [] array = new int[12];
        int [] maxArray = new int[12];
        for(int i=0;i<carArray.length;i++){
        	int startTime = carArray[i][0];
        	int endTime = carArray[i][1];
        	for(int j=startTime;j<endTime;j++){
        		array[j]++;
        		if(maxArray[j] < array[j]){
        			maxArray[j] = array[j];
        		}
        	}
        }
        ans = maxArray[0];
        for(Integer a:maxArray){
        	if(a > ans){
        		ans = a;
        	}
        }
        return ans; // 返回计算结果
    }
}