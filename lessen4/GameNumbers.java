package lessen4;

import java.util.Arrays;
import java.util.Scanner;



public class GameNumbers {

	private int [] arr;
	private int even=0, odd=1;


	public GameNumbers(int [] arr2){
		this.arr= arr2;
	}



	//מה לבחור זוגי או אי זוגי
	public int algo1(){
		int sum1=0,sum0=0;
		for (int i = 0; i<arr.length ;i++) {
			if(i%2==0)
				sum0=sum0+arr[i];
			else
				sum1=sum1+arr[i];
		}
		if(sum1>sum0)
			return 1;
		else
			return 0;
	}
	public int algo2(int a,int b){
		int sum1=0,sum0=0;
		for (int i = a+1; i<=b ;i++) {
			if(i%2==0)
				sum0=sum0+arr[i];
			else
				sum1=sum1+arr[i];
		}
		if(sum1>sum0)
			return 1;
		else
			return 0;
		
	}
	public void the_game(){
		
		Scanner n = new Scanner(System.in);
		int man=0,comp=0,x;
		int a=1;
		int b=arr.length;
		
		while(a<b){
			int as = algo2(a-1,b-1);
			printArr(a-1,b-1);
			if(as==0){
				if(a%2==0 && b%2!=0){
					System.out.println("the comp chase: " + arr[a-1]);
					comp = comp + arr[a-1];
					a++;	
					
				}
				else if(b%2==0&& a%2!=0){
					System.out.println("the comp chase: " + arr[b-1]);
					comp=comp+arr[b-1];
					b--;	
					
				}
			}
			else{
				if(a%2!=0&& b%2==0){
					System.out.println("the comp chase: " + arr[a-1]);
					comp = comp + arr[a-1];
					a++;	
					
				}
				else if(b%2!=0&& a%2==0){
					comp=comp+arr[b-1];
					System.out.println("the comp chase: " + arr[b-1]);
					b--;
				}
				}
				printArr(a-1,b-1);
				System.out.println("enter the nember you went: ");
				x=n.nextInt();

				man= man+x;

				if(x==arr[a-1])
					a++;

				if(x==arr[b-1])
					b--;


			
		}
		
		System.out.println("man: " + man + " comp: " + comp);
		if(man==comp)
		System.out.println("tiko!!");
		else
			System.out.println("comp win!");
		
		n.close();
	}



private void printArr(int a,int b){
	for(int i=a;i<=b;i++){
		System.out.print(arr[i] + ",");
	}
	System.out.println();
}


	public static void main(String[] args) {
int [] arr = {3,7,4,6,0,10,18,2};
GameNumbers n = new GameNumbers(arr);
n.the_game();
	}
}
