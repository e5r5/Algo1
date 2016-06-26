package lessen5;

public class pow {

	public static int pow1(int x,int n){ // O(n)
		if(n==0)
			return 1;
		else
			return x*pow1(x,n-1);
		
	}
	public static int pow2 (int x ,int n){ ///log n רקורסיה
		if(n==0)
			return 1;
		else{
			if(n%2==0)
				return  pow2(x*x,n/2);
			else
			return	x* pow2(x*x,(n-1)/2);
		}
	}
	
	public static int pow3(int x , int n){ //log n
		if(n==0)
			return 1;
		else{
			int an=1;
			while(n!=0){
				if(n%2!=0)
				an=an*x;
				
					x =x*x;
				     n=n/2;
			}
			return an;
		}
	}
	
	public static void parmo(int [] arr ,int size){ ///O(!n)
		if(size==1){
			for(int i=0;i<arr.length;i++){
				System.out.print( arr[i] + " ,");
			}
			System.out.println();
			return;
		}
		else{
			for(int i=0;i<size;i++){
				swap(arr,i,size-1);
				parmo(arr, size-1);
				swap(arr,i,size-1);
			}
			
		}
	}
	
	public static void swap(int [] arr ,int i,int j){//(O(1))
	int t = arr[i];
	arr[i]=arr[j];
	arr[j]=t;
	}
	
	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,6,7,8,9};
		parmo(arr, arr.length);
	}
}
