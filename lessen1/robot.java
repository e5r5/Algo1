package lessen1;



import lessen1.MyLinkedList.LLNode;


public class robot {
	
	
	public static void main(String[] args) {
		
		
		MyLinkedList l = new MyLinkedList();
		l.add(4);
		l.add(5);
		l.add(9);
		l.add(5);
		l.add(4);
		l.add(9);
		l.add(4);
		l.add(4);
		
		LLNode p= l.getH().getNext();
		int h=l.getH().getData();
		int c =1;
		while(-1!=p.getData()){

			if(p.getData()!=h){
				c++;
				p=p.getNext();
				continue;
			}
			else{
				p.setData(-1); 
				for(int i=0;i<c;i++){
					p= p.getPrevious();

				}
				if(p.getData()==-1){
					System.out.println(c);
					return;}
				else{
					c++;
					for(int i=0;i<c;i++){
						p= p.getNext();

					}
				}
			}
		}

	}

}
