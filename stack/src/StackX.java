import java.util.*;
import java.io.*;
public class StackX {
	private int maxSize;
	private double[] stackArray;
	private int top;
	public StackX(int s){
		maxSize=s;
		stackArray= new double[maxSize];
		top=-1;
	}
	public void push(double data){ //add to the stack
		if(isFull()){
			System.out.println("The stack is full");
		}
		else{
			top++;
			stackArray[top]=data;
		}
	}
	
	public double pop(){ // remove from the stack
		double temp;
		if(Empty()){
			System.out.println("The stack is empty");
			return 0;
		}
		else{
			temp=stackArray[top];
			top--;
			return temp;
		}
	}
	
	public boolean isFull(){// Is the stack full?
		if(top==maxSize-1){
			return true;
		}
		else{return false;}
		
	}
	
	public boolean Empty(){ // Is the stack empty?
		return top==-1;
	}
	
	public int size(){
		return top+1;
	}
	
	public double peek(){
		return stackArray[top];
	}

}
