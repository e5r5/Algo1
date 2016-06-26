package lessen3;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class max1max2 {

	public static double max1max0(int [] arr){//השוואת זוגות 1.5 אן
		int an=1;
		if(arr.length==1||arr.length==2)
			return 1;
		int max1=arr[1];
		int max2 = arr[0];
		an++;
		if(max1<max2){
			max1 = arr[0];
			max2 = arr[1];
		}

		for(int i=2;i<arr.length-1;i=i+2){
			an++;
			if(arr[i]>arr[i+1]){
				an++;
				if(arr[i]>max1){
					an++;
					if(arr[i+1]>max1){
						max2=arr[i+1];
						max1 = arr[i];
					}
					else{
						max2 = max1;
						max1=arr[i];
					}
				}
				else if(arr[i]>max2)
					max2=arr[i];
			}
			else{
				an+=2;
				if(arr[i+1]>max1){
					an++;
					if(arr[i]>max1){
						max1=arr[i+1];
						max2 = arr[i];
					}
					else{
						max2=max1;
						max1=arr[i+1];
					}
					}
                           
				else if(arr[i+1]>max2)
					max2 = arr[i+1];	
			}

		}
		an++;
		if(arr.length%2!=0){
			an++;
			if(arr[arr.length-1] >max1){
				max2=max1;
				max1 =arr[arr.length-1];}
			
				else if(arr[arr.length-1]>max2){
					max2 =arr[arr.length-1];
					an++;
				}

			}

	//	System.out.println("Max1 = " + max1 + " , Max2 = " + max2 + " , Comparisons = " + an);
		//	System.out.println("max1: " + max1 + "  "+ "max2: " + max2   );
		return an;///(double)arr.length;

	}
	
	public static int max1max(int [] arr){
		int[] an = new int [1];
		an[0]=0;
		nodeSt [] nodes =new nodeSt[arr.length];
		for(int i=0;i<arr.length;i++){
			nodes[i]=new nodeSt(arr[i]);
		}
		nodeSt top = max1max(nodes,0,nodes.length-1,an);
	int max1 = top.getData();
		int max2 = top.pop();
		while(!top.st.isEmpty()){
			int x = top.pop();
			if(max2<x)
				max2=x;
			
		}
	//	System.out.println("Max1 = " + max1 + " , Max2 = " + max2 + " , Comparisons = " + an[0]);
		return an[0];
	}
	private static nodeSt max1max(nodeSt [] arr ,int a,int b, int [] an){
		an[0]++;
		if(a==b)
			return arr[a];
		else{
			int m = (a+b)/2;
			nodeSt maxL=max1max(arr,a,m,an);
			nodeSt maxR=max1max(arr,m+1,b,an);
			an[0]++;
			if(maxR.getData()>maxL.getData()){
				maxR.push(maxL.getData());
				return maxR;
			}
			else{
					maxL.push(maxR.getData());	
				return maxL;
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	public static int max1max2(int [] a){
		nodeSt top=new nodeSt(a[0]);
		int an=0;
		ArrayList<nodeSt> arr = new ArrayList<nodeSt>();
		for(int i=0;i<a.length;i++){
		
			arr.add(new nodeSt(a[i]));
		}
		int i=0;
		while(arr.size()!=1){
			an++;
			if(arr.get(i).getData()>arr.get(i+1).getData()){
				arr.get(i).push(arr.get(i+1).getData());
				arr.remove(i+1);
				i=i+2;
			}
			else{
				arr.get(i+1).push(arr.get(i).getData());
				arr.remove(i);
				i=i+2;
			}
		an++;
		if(arr.size()-1<=i )
			i=0;
		}
		top=arr.get(0);
		int max1 = top.getData();
		int max2 = a[0];
		while(!top.st.isEmpty()){
			int x= top.st.pop();
		
			if(max2<x)
				max2=x;
			
		}
	//	System.out.println("Max1 = " + max1 + " , Max2 = " + max2 + " , Comparisons = " + an);
		return an;
	}
	
	public static void comper(double x){
		double an1=0,an2=0,an3=0;
		int [] arr= new int [(int)x];
		for(int i=0;i<arr.length;i++){
			for (int j = 0; j < arr.length; j++) {
				arr[j] = (int)(Math.random()*(1000));
			}
			an1 = an1 + (double)max1max0(arr)/(double)arr.length;
			an2 = an2 + (double)max1max(arr)/(double)arr.length;
			an3 = an3 + (double)max1max2(arr)/(double)arr.length;
		}
		System.out.println("an1 :" + an1/x+ "  an2: "+ an2/x + "  an3:  "+ an3/x);
	}
public static void main(String[] args) {
	int [] arr= {5,9,12,5,8,0,33,5,7,235,457,58,555,78,666};
	//max1max0(arr);
      //max1max(arr);
     // max1max2(arr);
      comper(1000);
}

}
