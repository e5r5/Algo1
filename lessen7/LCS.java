package lessen7;

import java.util.Arrays;
import java.util.Vector;

public class LCS {
	private int [][]arr;
	private int n,m;
	private int len;
	private String x , y; 

	public LCS(String a ,String b){
		x=a;
		y=b;
		n=x.length();
		m=y.length();
		arr = new int [n+1][m+1]; 
		//
		full_maatrix();
		len=num_LCS();
		System.out.println(num_LCS());
	}

	public void full_maatrix(){

		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				
				if(x.charAt(i-1)==y.charAt(j-1))
					arr[i][j] = arr[i-1][j-1]+1;
				else
					arr[i][j]= Math.max(arr[i-1][j], arr[i][j-1]);
			//	printMat();
				
			}
		}
	}
	public int num_LCS(){
		return arr[n][m];

	}
	public String return_String_from_matrix(){
		String an="";
		int len = num_LCS();
		int i = n-1;
		int j = m-1;
		while( an.length()<len){ // or arr[i][j]!=0 ||
			if(x.charAt(i)==y.charAt(j)){
				an = x.charAt(i) + an;
				i--;
				j--;
			}
			else{
				if(arr[i-1][j]>arr[i][j-1])
					j--;
				else
					i--;
			}
		}
		return an;
	}
	public void printMat(){
		for(int i=1;i<arr.length;i++){
			System.out.println();
			for(int j=1;j<arr[0].length;j++){
				System.out.print(arr[i][j] + "   ");

			}

		}
System.out.println();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Vector<String> get_All_String_On_Lcs(){
		Vector<String > ans = new Vector<String>();
		int i = n-1;
		int j = m-1;
		get_All_String_On_Lcs(i,j,len,"",ans);
		return ans;
	}

	private void get_All_String_On_Lcs(int i, int j, int len, String t,Vector<String> ans){

	    if(arr[i+1][j+1]==0  && len>0) return;

	    else if(len==0){

			if(!ans.contains(t))
			ans.add(t);

			return;}

		if(x.charAt(i)==y.charAt(j))
			get_All_String_On_Lcs(i-1,j-1,len-1,x.charAt(i)+t,ans);

		else if(arr[i-1][j]>arr[i][j-1])
			get_All_String_On_Lcs(i-1,j,len,t,ans);

		else if(arr[i-1][j]<arr[i][j-1])
			get_All_String_On_Lcs(i,j-1,len,t,ans);

		else{
			get_All_String_On_Lcs(i-1,j,len,t,ans);
			get_All_String_On_Lcs(i,j-1,len,t,ans);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
	//	String b = "abcde";
		//String a ="cbde";
			String y = "bdcaba";
			String x = "abcdef";
		LCS t = new LCS(x, y);
			t.printMat();
		
		
	//	System.out.println(t.num_LCS());
		//System.out.println(t.return_String_from_matrix());
		//System.out.println(t.get_All_String_On_Lcs().toString());
	
	}
}
