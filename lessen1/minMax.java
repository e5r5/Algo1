package lessen1;

import java.util.Arrays;

public class minMax {

	public static void random(int []arr){
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*1000);
		}
	}

	public static int max(int [] arr){
		int max=arr[0];
		int c=0;
		for(int i=0;i<arr.length;i++){
			c++;
			if(arr[i]>max){
				max = arr[i];
				
			}
		}
		return c;
	}
	public static int min(int [] arr){
		int min=arr[0];
		int c=0;
		for(int i=0;i<arr.length;i++){
			c++;
			if(arr[i]<min){
				min = arr[i];
					
			}
		}
		return c;
	}
	public static int max_min_best(int [] arr){
		int x=0,min,max;
		x++;
		if(arr[0]<arr[1]){
			min=arr[0];
			max = arr[1];}
		else {
			max = arr[0];
			min =arr[1];}

		
		for(int i=1;i<(arr.length/2);i++){
			x++;
			if(arr[i*2+1]>arr[2*i]){
				x++;
				if(max<arr[i*2+1])
					max=arr[i*2+1];
				x++;
				if(min>arr[i*2])
					min=arr[i*2];
			}
			else{
				x++;
				if(max<arr[i*2])
					max=arr[i*2];
				x++;
				if(arr[i*2+1]<min)
					min=arr[i*2+1];
			}				
		}
		x++;
		if(arr.length%2!=0){
			x++;
			if(arr[arr.length-1]>max){
				max=arr[arr.length-1];}
			x++;
			if(arr[arr.length-1]<min){
				min=arr[arr.length-1];}
		}
		return x;
	}
	public static void main(String[] args) {
		double sum=0;
		int [] arr = new int [1000];
		for(int i=0;i<10000;i++){
			random(arr);
			double n = max_min_best(arr);
			sum = sum + (n/arr.length);

		}

		System.out.println("best is: " +sum/10000);


	}

}
