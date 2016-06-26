package lessen6;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class LCS {

	public static int LCS(String x,String y){
		int an=0;
		int s =-1;
		for (int i = 0; i < x.length(); i++) {
			for (int j = s+1; j < y.length(); j++) {
				if(x.charAt(i)==y.charAt(j)){
					an++;
					s=j;
					break;
				}
			}
		}
		return an;
	}

	public static int maxLCS(String x,String y){
		return Math.max(LCS(y, x),LCS(x, y));

	}
	/////////////קוונטר בינארי= 1 לקחנו 0 לא לקחנו
	public static void plus(int [] arr){
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]==0){
				arr[i]++;
				break;	
			}
			else{
				arr[i]=0;
				continue;
			}
		}
	}
	//בלולאה אלו תתי הקבוצות של מחרוזת
	public static String [] Tatai_kvozot(String s){
		int times = (int)(Math.pow(2,(int) s.length()))-1;
		String [] an = new String [(int)(Math.pow(2,(int) s.length()))];
		int [] arr = new int [s.length()];
		String t="";
		an[0]="";
		while(times>0){
			t="";
			plus(arr);
			for(int i=0;i<arr.length;i++){
				if(arr[i]==1)
					t = t+s.charAt(i);
			}
			an[times--]=t;
		}
		return an;
	}
	///////////////////////תתי הקבוצות של מחרוזת ברקורסיה
	public static void Tatai_kvozotRC(String s){
		Vector<String> arr = new Vector<String>();
		Tatai_kvozotRC(s,0,arr,"");
		System.out.println(arr.toString());
	}
	private static void Tatai_kvozotRC(String s,int i,Vector<String> arr,String t){
		if(i==s.length()){
			arr.add(t);
			return;}
		Tatai_kvozotRC(s,i+1,arr,t);
		Tatai_kvozotRC(s,i+1,arr,t + s.charAt(i));
	}
	////////////////////////////////////////////////////////////////////////////

	//מציאת LSC דרך היסטוגרפיה
	public static int HisLCS(String x,String y){
		int [] his= new int[26];
		makeHis(x, his);
		int an=0,s=-1;
		for(int i=0;i<y.length();i++){
			for(int j=s+1;j<x.length();j++){
				if(his[return_int_from_char(y.charAt(i))]==0)
					break;
				else{
					if(y.charAt(i)==x.charAt(j)){
						his[return_int_from_char(y.charAt(i))]--;
						an++;
						s=j;
						break;
					} 
				}
			}
		}
		return an;
	}
	private static int return_int_from_char(char a){
		if(a>='a' && a<='z')
			return a- 'a' +1;

		if(a>='A' && a<='Z')
			return a- 'A' +1;

		return -1;
	}
	private static void makeHis(String x, int [] his){
		for(int i=0;i<x.length();i++){
			if(x.charAt(i)>='a' && x.charAt(i)<='z')
				his[return_int_from_char(x.charAt(i))]++;

			if(x.charAt(i)>='A' && x.charAt(i)<='Z')
				his[return_int_from_char(x.charAt(i))]++;


		}
	}
	public static int maxHisLCS(String x,String y){
		return Math.max(HisLCS(x , y), HisLCS(y,x));
	}

	public static void nember_of_pepole(){
		System.out.println("enter nember of pepole:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 1;
		boolean light_on = true;
		int x=0;
		while(a<n){
			x++;
			int enter_now = (int)(Math.random()*n +1);
			if(enter_now==a && light_on){
				a++;
				light_on = false;
			}
			else
				light_on = true;
		}
		System.out.println("finish on:" + x);

		sc.close();
	}


	public static void main(String[] args) {
		//nember_of_pepole();
	
	}
}