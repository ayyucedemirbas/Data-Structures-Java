
public class Stack {
	
	class Bit{
		int binary;
		Bit(int binary){
			this.binary=binary;
		}
	}
	
	Bit[] bit;
	int size, top;
	
	Stack(int size){
		this.size=size;
		bit= new Bit[size];
		top=-1;
	}
	
	boolean isFull() {
		return top==size-1;
	}
	
	boolean isEmpty() {
		return top==-1;
	}
	void push(Bit b) {
		if(!isFull()) {
			top+=1;
			bit[top]=b;
		}
		
	}
	
	int pop() {
		if(!isEmpty()) {
			top-=1;
			return bit[top+1].binary;
		}
		return -1;
	}
	Bit olustur(int num) {
		Bit b= new Bit(num);
		return b;
	}
	
	int peek() {
		return bit[top].binary;
	}
	

}
