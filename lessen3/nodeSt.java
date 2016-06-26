package lessen3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class nodeSt {
private int data;
Stack<Integer> st ;

public nodeSt(int x){
	data = x;
	st = new Stack<Integer>();
}

public int getData() {
	return data;
}

public void setData(int data) {
	this.data = data;
}

public int pop() {
	return st.pop();
}

public void push(int x){
	st.push(x);
}

}
