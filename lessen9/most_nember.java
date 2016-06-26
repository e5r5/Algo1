package lessen9;

import java.util.Arrays;

public class most_nember {

	public static double majority (double[] arr){
		int [] a = new int [arr.length];
		double temp_ans=arr[0];//המועמד להיות התשובה
		int last_index_ans=0;	//האינדקס שבו נמצא המועמד
		for(int i=0;i<arr.length;i++){
			if(a[last_index_ans]==0){//אם במערך התדירות של המועמד הוא אפס אז יש לנו מועד חדש- הזה שהבא בתור
				temp_ans = arr[i];
			}
			if(arr[i]==temp_ans){//מילוי מערך התדירות אם יש מישהו כמו המועמד תוסיף לאיי
				a[i] = a[last_index_ans]+1;
				last_index_ans =i;//תעדכן את האינקס המועמד החדש כלומר התשובה במקום האחרון
			}
			else{
				a[last_index_ans]--;//אם הוא לא כמו המועמד אז תוריד מהתדירות
			
			}
		}
		int chack=0;//בדיקה סופית שהמועמד באמת איבר הרוב
		for(int i=0;i<arr.length;i++){
			if(arr[i] == temp_ans)
				chack++;
		}
		if(chack>arr.length/2)
			return temp_ans;
		else
			return Double.NEGATIVE_INFINITY;
	}
	public static double majority2 (double[] arr){
		int [] a = new int [arr.length];
		a[0]=1;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<=i;j++){
				if(arr[i]==arr[j])
					a[i]++;
			}
		}
		int index_max=0;
		int max=a[0];
		for(int i=0;i<a.length;i++){
			if(a[i]>max){
				max = a[i];
			index_max = i;	
			}
		}
		if(max>arr.length/2)
		return arr[index_max];
		else
			return Double.NEGATIVE_INFINITY;
	}
	public static void main(String[] args) {
		double [] arr = {3.14,1.4,1.4,1.4,3.14,3.14,3.14,3.33,6.66,3.33}; //NEGATIVE_INFINITY;
		double [] arr2 = {3.14,1.4,1.4,1.4,3.14,1.4,3.14,3.33,1.4,3.33,1.4}; // 1.4
		double [] arr3 = {3.14,3.14,1.4,1.4,3.14,3.14,3.14,3.14,3.14,3.14,1.4};//3.14
		double[] arr4 = {5,5,5,2,3,3,3,3,3,2};
		System.out.println(majority(arr));
		System.out.println(majority2(arr));
	}
}
