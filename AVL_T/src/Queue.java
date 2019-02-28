public class Queue<T> {
	
		class Node{
		
		T t;
		Node next;
		
		Node(T t){
			this.t=t;
			next=null;
			
		}
		
	}
	Node first, last;
	
	
	boolean isEmpty() {
		return first==null;
	}
	
	
	
	
	
	void add(T t) {
		
		 Node n=new Node(t);
	        n.next=null;
	        if(isEmpty()) {
	            first=n;
	        }
	        else {
	            last.next=n;
	        }
	        last=n;
		
		
	}
	
	
	T peek() {
		
		return first.t;
	}
	
	T poll() {
		
		Node tmp=first;
		if(!isEmpty()) {
			first=first.next;
			}
		return tmp.t;
	}
	
	

}
