package lessen10;

public class matrix {

	int [][] mat ;
	int [][] mat2;
	public matrix(){
		//mat= new int [5][5];
		mat2 =new int [5][5];
		//
		int [][] matNEW ={
				{1,1,0,0,0},
				{1,1,1,1,0},
				{0,1,1,1,1},
				{1,1,1,1,0},
				{0,0,1,0,0}
		};
		this.mat = matNEW;


	}
	public void print_matrix1(){
		for(int i=0;i<mat.length;i++){
			System.out.println();
			for(int j =0;j<mat[0].length;j++){
				System.out.print(mat[i][j] + "    ");
			}
		}
		System.out.println();
	}
	public void print_matrix2(){
		for(int i=0;i<mat2.length;i++){
			System.out.println();
			for(int j =0;j<mat2[0].length;j++){
				System.out.print(mat2[i][j] + "    ");
			}
		}
		System.out.println();
	}

	public static int min(int a,int b,int c){
		int min = Math.min(a, b);
		return Math.min(min, c);
	}
	public void make_mat2(){
		int n = mat2.length;
		int m = mat2[0].length;
		int max=mat[0][0];
		int ii=0,jj=0;
		for(int i=0;i<n;i++){
			mat2[i][0] = mat[i][0];
		}
		for(int i=0;i<m;i++){
			mat2[0][i]= mat[0][i];
		}

		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				
				if(mat[i][j]==1){
					mat2[i][j]= min(mat2[i-1][j-1],mat2[i][j-1],mat2[i-1][j]) +1 ;
					if(mat2[i][j]>max){
						max = mat2[i][j];
						ii=i;
						jj=j;
					}
				}
			}
		}
		System.out.println("The max is:  "+ max + "  the index" + "(" + ii + "," + jj+")" );
	}

	public static void main(String[] args) {
		matrix m = new matrix();
		m.make_mat2();
		m.print_matrix1();
		m.print_matrix2();
	}
}
