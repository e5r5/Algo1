package lessen9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class plain {
	Node [][] mat;
	String s = "";
	int min_price;
	int Nember_path;
	public plain(int mat_ex){
		if(mat_ex==1) mat = Node.mat1();//3 x 4
		if(mat_ex==2) mat = Node.mat2();//6 x 6
		if(mat_ex==3) mat = Node.mat3();//4 x 4
		bestPrise();
		optemal2_path();
	}

	public void bestPrise(){
		mat[0][0].price=0;
		for(int i=1;i<mat[0].length;i++){
			mat[0][i].price = mat[0][i-1].price + mat[0][i-1].x;
			mat[0][i].nember_paths=1;	
		}

		for(int i=1;i<mat.length;i++){	
			mat[i][0].price=mat[i-1][0].price + mat[i-1][0].y;
			mat[i][0].nember_paths=1;	
		}

		for(int i=1;i<mat.length;i++)	{
			for(int j=1;j<mat[0].length;j++){
				int x= mat[i][j-1].price+mat[i][j-1].x;
				int y=mat[i-1][j].price+mat[i-1][j].y;
				mat[i][j].price=Math.min(x,y);


				if(x<y)
					mat[i][j].nember_paths = mat[i-1][j].nember_paths;
				else if(x>y)
					mat[i][j].nember_paths = mat[i][j-1].nember_paths;
				else if(x==y)
					mat[i][j].nember_paths = mat[i-1][j].nember_paths + mat[i][j-1].nember_paths;
			}
		}
		min_price= mat[mat.length-1][mat[0].length-1].price;
		Nember_path = mat[mat.length-1][mat[0].length-1].nember_paths;
		System.out.println("min_price" + min_price);
	}

	public void print_price2(){
		for(int i=0;i<mat.length;i++){
			System.out.println();
			for(int j =0;j<mat[0].length;j++){
				System.out.print(mat[i][j].price2 + "    ");
			}
		}
		System.out.println();
	}
	public void print_price(){
		for(int i=0;i<mat.length;i++){
			System.out.println();
			for(int j =0;j<mat[0].length;j++){
				System.out.print(mat[i][j].price + "    ");
			}
		}
		System.out.println();
	}
	public void print_nember_paths(){
		for(int i=0;i<mat.length;i++){
			System.out.println();
			for(int j =0;j<mat[0].length;j++){
				System.out.print(mat[i][j].nember_paths + "    ");
			}
		}
	}
	public void print_Node(){
		for(int i=0;i<mat.length;i++){
			System.out.println();
			System.out.println();
			for(int j =0;j<mat[0].length;j++){
				mat[i][j].printNode() ;
				System.out.print("      ");
			}
		}
	}
	//מסלול 1
	public String Npath(){
		return Npath(mat.length-1,mat[0].length-1);
	}
	public String Npath(int i,int j){
		if(i==0&&j==0)
			return "";
		else if(i>0&&j==0)//הגענו לקצה השמאלי 
			return  Npath(i-1,0) + "1";
		else if(i==0 && j>0)
			return Npath(0, j-1) + "0";
		else{
			if(mat[i][j].price==mat[i-1][j].price + mat[i-1][j].y)
				return Npath(i-1, j) + "1";
			else
				return Npath(i-1, j) + "0";
		}
	}
	//מסלול אחד אינדוקטיבי
	public String Indoctiv_nember_path(){
		String an="";
		int i=mat.length;
		int j=mat[0].length;
		while(i>0 && j>0){
			if(mat[i][j].price==mat[i-1][j].price+mat[i-1][j].y){
				an= "1"+an;
				i--;}
			else{
				an="0"+an;
				j--;}
		}
		while(i>0){
			an= "1"+an;
			i--;}

		while(j>0){
			an="0"+an;
			j--;}

		return an;
	}

	//כל המסלולים המינימלים של המטריצה רקורסיה
	public Vector<String> all_the_path(){
		Vector<String> v = new  Vector<String>();
		if(Integer.MAX_VALUE < mat[mat.length-1][mat[0].length-1].nember_paths)return null;
		else all_the_path(mat.length-1,mat[0].length-1,v,"");
		return v;
	}

	private void all_the_path(int i,int j,Vector<String> an,String s){
		if(i==0&&j==0){
			an.add(s);
			return ;
		}
		else if(i>0&&j==0)//הגענו לקצה השמאלי 
			all_the_path(i-1,0,an,s + "1");
		else if(i==0 && j>0)//החלק התחתון צריך לזוז שמאלה 
			all_the_path(0, j-1 ,an ,s + "0");
		else{
			int x= mat[i][j-1].price+mat[i][j-1].x;// המחיר אם נזוז על ציר איקס
			int y=mat[i-1][j].price+mat[i-1][j].y;//המחיר אם נזוז על ציר וואי
			if(x>y)
				all_the_path(i-1, j,an,s+"1");//אם וואי זול יותר נרד שורה
			else if(x<y)
				all_the_path(i, j-1,an,s+ "0");//אם איקס זול יותר נזוז עמודהה שמאלה
			else{
				all_the_path(i, j-1,an,s+ "0");//אם שניהם שווים נשלח את הרקורסיה פעם לשם ופעם לשם
				all_the_path(i-1, j,an,s+"1");
			}
		}	

	}
	public String Min_turn_on_min_path(){
		Vector<String> v = all_the_path();
		int [] arr = new int [v.size()];
		for(int i=0;i<v.size();i++){
			arr[i] = returns_rodes(v.get(i));
		}
		int min_index = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<arr[min_index])
				min_index=i;
		}
		return v.elementAt(min_index);

	}
	public static int returns_rodes(String s){//לפי הגדרת נוחות מחזיר את מספר הפניות במסלול מסויים
		int ans=0;
		if(s.length()==1 || s.length()==0)
			return 0;
		char a = s.charAt(0);
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)!=a){
				ans++;
				a=s.charAt(i);
			}
		}
		return ans;
	}
	public static void remove_double_int(int [] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[j]==arr[i]&&i!=j)
					arr[i]=999;
			}
		}
	}
	public void optemal2_path(){
		int n = mat.length,m = mat[0].length;
		for(int i=1;i<n;i++){
			mat[i][0].price2= mat[i-1][0].y + mat[i-1][0].price2;
		}
		for(int i=1;i<m;i++){
			mat[0][i].price2= mat[0][i-1].x + mat[0][i-1].price2;
		}

		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				int x1= mat[i][j-1].price2+mat[i][j-1].x;
				int y1=mat[i-1][j].price2 +mat[i-1][j].y;
				int x2= mat[i][j-1].price+mat[i][j-1].x ;
				int y2=mat[i-1][j].price+mat[i-1][j].y;
				int t2 = Math.min(x2, y2);
				int t1 = Math.min(x1, y1);
				int min2, min1;
				if(t1<t2){
					min1=t1;
					if(x1==t1){
						min2=Math.min(y1, t2);}
					else {
						min2 = Math.min(x1, t2);}
				}
				else{
					min1=t2;
					if(x2==t2){
						min2=Math.min(y2, t1);}
					else{
						min2=Math.min(x2, t1);}
				}
				if(min1==min2){
            	   mat[i][j].price2=Math.max(x1, y1);
            	 //  mat[i][j].price=Math.min(x1, y1);
				}
               else{
				mat[i][j].price2=min2;}
				mat[i][j].price=min1;
				if(i==1&&j==2){
					System.out.println("min1:"+min1 + "  min2:"+min2 +"  p1:"+mat[i][j].price +"   p2:"+mat[i][j].price2  );
				                System.out.println("x1:"+x1 +"  "+"y1:"+y1 +"  "+"x2:"+x2 +"  "+"y2:"+y2 +"  ");
	
				}
			}
		}
		this.print_price();
		this.print_price2();
		System.out.println("price1 : " + mat[n-1][m-1].price);
		System.out.println("price2: " + mat[n-1][m-1].price2);
	}
	public static void main(String[] args) {
		plain p= new plain(1);
		//		System.out.println(p.min_price);
		//		System.out.println(p.Nember_path);
		//		System.out.println(p.s);
		System.out.println(p.all_the_path().toString());
		//System.out.println(p.Min_turn_on_min_path());




	}
}

