package lessen1;
public class MyLinkedList {

	public class LLNode {

		private int data;
		private LLNode next, previous;

		public LLNode(int data) {
			this.data = data;
		}
		public void setData(int x) {
			data =x;
		}
		public int getData() {
			return data;
		}

		public LLNode getNext() {
			return next;
		}

		public void setNext(LLNode next) {
			this.next = next;
		}

		public LLNode getPrevious() {
			return previous;
		}

		public void setPrevious(LLNode previous) {
			this.previous = previous;
		}
	}

	LLNode head, tail;

//////////////////////////////////////////////////////////////////
	public LLNode add(int x) {
		LLNode newNode = new LLNode(x);

		if(head == null) {
			head = newNode;
			tail = newNode;
		}

		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		tail.setNext(head);
		head.setPrevious(tail);
		return newNode;
	}
//////////////////////////////////////////////////////////////////////
	public LLNode getH(){
		return head;
	}
}
