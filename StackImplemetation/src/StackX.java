
public class StackX {
	private int maxSize;
	private double[] stackArray;
	private int top;
	public StackX(int s) {
		maxSize=s;
		stackArray= new double[maxSize];
		top=-1;
	}
	public void push(double data) {
		if(isFull()) {
			System.out.println("stack dolu");
		}
		
		else {
		top++;
		stackArray[top]=data;
		}
	}
	
	public double pop() {
		double temp=0;
		
		if(empty()) {
			System.out.println("stack bos");
		}
		
		else {
		
		temp=stackArray[top];
		top--;}
		return temp;
		
		
		
	}
	public boolean isFull() {
		return top==maxSize-1;
	}
	public boolean empty() {
		return top==-1;
	}
	
	public double peek() {
		return stackArray[top];
	}
	

}
