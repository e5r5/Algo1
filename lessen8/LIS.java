package lessen8;

import java.util.Arrays;

import javax.swing.text.DefaultEditorKit.CopyAction;

public class LIS {

	public static int[] LIS(int [] a){
		int n = a.length;
		int[][] arr= new int [n][n];
		arr[0][0] = a[0]; // עושים השמה למערך הראשון באורך 1
		int len=1; //אורך השורה שעובדים עליה כאילו עד איפה במערך
		for(int i=1;i<n;i++){
			int index = search(arr,len, a[i]);
			if(len==index){
				len++;}//פתיחת שורה חדשה אם האורך של השורה שעובדים עליה שווה לאינדקס החדש שחיילנו
			arr[index][index] = a[i];
			copy(arr,index); //מעתיקים תמיד מהאפס עד האורך השורה בבמטריצה באופן חח"ע
		}
		int [] ans= new  int [len];
		for(int i=0;i<ans.length;i++){
			ans[i] = arr[len-1][i];
		}
		return ans;
	}
	public static void copy(int [][]mat ,int index ){
		for(int i=0;i<index;i++){
			mat[index][i] = mat[index-1][i];
		}	
	}
	public static int search(int [][] arr,int len, int x){
		if(x<arr[0][0])return 0;
		if(x>=arr[len-1][len-1])return len;
		return binarySearch(arr,x,0,len);
	}
	private static int binarySearch(int [][] arr,int x,int i,int j){
		if(i==j){
			return i;
		}
		else{
			int m = (i+j)/2;		
			if(arr[m][m]>=x)
			return binarySearch(arr, x,i,m);
			else
				return binarySearch(arr, x, m+1, j);
		}
	}
	
	public static void main(String[] args) {
	//int [] arr = {1,100,101,2,3,4,5};
	//	int [] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		int [] arr = {4,5,7,8,111,2,4,55,99,88};
	System.out.println(Arrays.toString(LIS(arr)));
 //System.out.println(search(arr, len, x));
	}

}
