package lessen3;

public class maxMin {

	public static int one(int [] arr){  //שני אן השוואות
		//System.out.println("O(2n):");
		int an=1;
		int min=arr[0];
		int max=arr[1];
		if(arr[0]>arr[1]){
			max =arr[0];
			min = arr[1];
		}

		for(int i=0;i<arr.length;i++){
			an++;
			if(arr[i]>max)
				max=arr[i];
			else {
				an++;
				if(arr[i]<min)
					min = arr[i];
			}
		}
		//System.out.println("max: " + max  +"   "+ "min: " + min);
		//	System.out.println("if is : "+ an +" times");
		//System.out.println();
		return an;
	}
	//אלגוריתם הזוגות, 1.5 אן!
	public static int two(int [] arr){
		//System.out.println("O(1.5n)");
		if(arr.length ==1){//הטרווילי
			System.out.println("max and min is :" + arr[0]);
			return 0;	
		}
		int min=arr[0];///בודקים את הראשון
		int max=arr[1];
		int an=1;
		if(arr[0]>arr[1]){
			max =arr[0];
			min = arr[1];
		}
		for(int i=2;i<((arr.length-1));i=i+2){
			an++;
			if(arr[i]<arr[i+1]){
				an++;
				if(arr[i+1]>max)
					max=arr[i+1];
				an++;
				if(arr[i]<min)
					min = arr[i];
			}
			else{
				an++;
				if(arr[i]>max)
					max=arr[i];
				an++;
				if(arr[i+1]<min)
					min = arr[i+1];

			}
		}
		an++;
		if(arr.length%2!=0){//אם אי זוגי נבדוק את האחרון
			an++;
			if(arr[arr.length-1]>max)
				max= arr[arr.length-1];

			an++;	
			if(arr[arr.length-1]<min)
				min = arr[arr.length-1];
		}
		//System.out.println("max: " + max  +"   "+ "min: " + min);
		//	System.out.println("if is : "+ an +" times");
		//System.out.println();
		return an;
	}

	public static void three(){
		double sum=0;
		int [] arr = new int [10000];
		double [] an = new double [arr.length];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				arr[j] = (int)(Math.random()*1000);
			}
			// sum=sum+(double)one(arr)/(double)arr.length;
			sum=sum+(double)two(arr)/(double)arr.length;
		}
		//System.out.println("one - 2n : " + sum/(double)arr.length);
		System.out.println("two - 1.5n : " + sum/(double)arr.length);

	}

	public static void getAverageofMethod(int method,int checks,int max_size) {
		int[] arr;
		double sum = 0;
		for (int i = 0; i < checks; i++) {
			arr = new int[(int)(Math.random()*max_size+10)];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = (int)(Math.random()*max_size*10+1);
			}
			if(method == 1) sum += (double)one(arr)/arr.length;
			if(method == 2) sum += (double)two(arr)/arr.length;
		}
		System.out.println("avarage: " + sum/checks);
	}


	public static void main(String[] args) {
		int [] arr= {8,5,0,-3,1,44,5,-9,55,4,-55};
		//one(arr);
		//two(arr);
		three();
		System.out.println("1:");
		getAverageofMethod(1,10000,1000);
		System.out.println("2:");
		getAverageofMethod(2,10000,1000);
	}
}
