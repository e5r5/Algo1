package lessen10;

public class QfromTest {

	int [][]mat;
	int [][]mat2;

	public QfromTest(){
//		int [][] temp = {
//				{1,0,1,0,0},
//				{0,0,1,0,1},
//				{0,0,0,0,0},
//				{0,0,0,1,1},
//				{1,1,0,1,1}
//		};
		int [][] temp ={
				{1,0,0,0,0},
				{1,0,1,1,0},
				{0,0,1,1,0},
				{1,0,0,0,0},
				{1,0,0,1,1}
		};
		this.mat = temp;
		mat2 = new int [mat.length+1][mat[0].length+1];
	}
	public void makeMat2(){
		int n= mat2.length;
		int m = mat2[0].length;
		int an=0;
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				if(mat[i-1][j-1]==1){
					if(mat2[i-1][j]==0 && mat2[i][j-1]==0)
						mat2[i][j] = an++;	
					else if(mat2[i][j-1]!=0 && mat2[i-1][j]==0)
						mat2[i][j] =mat2[i][j-1];
					else //if(mat2[i-1][j]!=0 && mat2[i][j-1]==0){
						mat2[i][j] = mat2[i-1][j];
				}
			}
		}
		System.out.println("ans: "+ an);
	}
	public static void main(String[] args) {
		QfromTest m = new QfromTest();
		m.makeMat2();

	}

}
