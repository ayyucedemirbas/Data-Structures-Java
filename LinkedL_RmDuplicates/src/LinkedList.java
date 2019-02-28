import java.util.HashSet;
public class LinkedList {//HashMap  O(n^2)
	//HashMap <Node, Integer> map = new HashMap<>();
	
	Node head;
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
			
		}
		
	}
	
	void push(int d) {
		
		Node n= new Node(d);
		n.next=head;
		head=n;
		
	}
	
	
	
	void print (Node n) {
		while(n!=null) {
			System.out.println(n.data);
			n=n.next;
		}
	}
	
	
	void rmDuplicated(Node n) { //with temp buffer  //HashMap  O(N) N:bagli liste eleman sayisi
	
		/*while(n!=null) {
			/*last=n;
			n=n.next;*/
			
			/*map.put(n, n.data);
			n=n.next;
			
			
			}*/
		
		HashSet<Integer> set = new HashSet<>();
		
		Node prev=null;
		
		while(n!=null) {
			if(set.contains(n.data)) {
				prev.next=n.next;
			}
			
			else {
				set.add(n.data);
				prev=n;
			}
			
			
			n=n.next;
		}
		

	}
	
	
	void _rmDuplicated(Node n) {//without temp buffer   //Space complexity O(1),   time complexity O(N^2)
		Node current = n;
		
		while(current!=null) {
			/*Ayni degere -data- sahip tum nodelari siler*/
			Node runner= current;
			while(runner.next!=null) {
				if(runner.next.data==current.data) {
					runner.next=runner.next.next;
				}
				
				else {
					runner=runner.next;
				}
			}
			
			current=current.next;
		}
	}
	
	
	
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		
		ll.push(5);
		ll.push(6);
		ll.push(9);
		ll.push(1);
		ll.push(9);
		ll.push(1);
		
		//ll._rmDuplicated(ll.head);
		ll.rmDuplicated(ll.head);
		
		ll.print(ll.head);
		
		
	}
	
	

}
