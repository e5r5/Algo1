package lessen11;

import java.util.Vector;

public class Game_dinami {

	int [][] mat;
	int n;
	public Game_dinami(int [] arr){
		this.n = arr.length;
		mat = new int [n][n];
		for(int i=0;i<n;i++){
			mat[i][i]=arr[i];
		}
		for(int i=n-1;i>=0;i--){
			for(int j=i+1;j<n;j++){
				mat[i][j] = Math.max(arr[i]-mat[i+1][j], arr[j] - mat[i][j-1]);
			}
		}

	}
	public  void printMat(){
		for(int i=0;i<n;i++){
			System.out.println();
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j]+"    ");
			}
		}	
	}
	
	public String path(){
		System.out.println();
		int i=0;
		int j =n-1;
		String t= "";
		while(j>i){
			int a = mat[i][i];
			int b = mat[j][j] ;
			int c = mat[i+1][j];
			int d =  mat[i][j-1];

			if(a-c>  b-d){
				t =  t+"=>"+mat[i][i];
				i++;
			}
			else{
				t =  t+"=>"+mat[j][j];
				j--;
			}
		}
		System.out.println(t);
		return  t+"=>"+mat[j][j];
	}
//	public Vector<String> All_path(){
//		//Vector<String> v = new Vector<String>();
//		
//	}
	public static void main(String[] args) {
//	int [] arr = {3,4,9,1,7,5};
		int [] arr = {1,3,6,1,3,6};
//	int [] arr = {1,2,3,4,5,6};
//	int [] arr = {6,5,4,3,2,1};
	//	int [] arr = {-2,1,-1,2,3,-2};
		Game_dinami g = new Game_dinami(arr);
		g.printMat();
		//System.out.println(g.path());
		System.out.println(g.mat[g.mat.length-2][g.mat[0].length-2]);
	}
}
