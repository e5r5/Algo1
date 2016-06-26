package lessen2;

public class two {

	public static int robot_by_arr(int [] arr){
		
		
		int enter=0,k=enter+1;
		int x= 1;
		int p= arr[enter];
		while(true){
			if(arr[k%arr.length]!=p){
				x++;
				k++;
				continue;
			}
			else{
				arr[k%arr.length] = -1;
				if(arr[enter % arr.length]==-1)
					return x;
				else{
					k++;
					x++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int [] arr ={3,4,2,6,7,8,2,10,12,44,3,66,8,4,2,5,7,2,3};
		System.out.println(robot_by_arr(arr));
     System.out.println(arr.length);
	}

}
