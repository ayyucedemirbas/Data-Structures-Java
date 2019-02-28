
public class LinkedList {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	
	Node findLast() {//O(n)
		Node n= head;
		while(n.next!=null) {
			n=n.next;
		}
		return n;
	}
	
	
	void add(int k) {
		Node last; 
		Node n = new Node (k);
		if(head!=null) {
			last=findLast();//each time you call the "add" method, findLast method will be called and O(n) time will be wasted
	      last.next=n;
	      last = n;
          last.next = null;
		}
		else {
			
			head=n;
			
		}
			
		
		
	}
	
	boolean isEmpty() {
		return head==null;
	}
	
	void roundRobin() {
		Node last=findLast();//O(n)
		int count=2;
		System.out.println("İlk adim: ");
		print();
		while(!isEmpty()) {
			if(head.data>10) {
				
				Node p= new Node((head.data)-10);
				last.next=p;
				last=p;
				
			}
			head=head.next;
			System.out.println();
			System.out.println(count+". adim: ");
			print();
			count++;
			
		}
	}
	
	
	void delete() {
		head=head.next;
		
	}
	
	void print() {
		Node n= head;
		while(n!=null) {
			//System.out.println("   ");
			System.out.print(n.data+",");
			n=n.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		ll.add(12);
		ll.add(5);
		ll.add(18);
		ll.add(29);
		/*ll.add(12);
		ll.add(18);
		*/
		
		ll.roundRobin();
		/*ll.delete();
		ll.delete();*/
		
		
		//ll.print();
		
		/*System.out.println("Head: "+ ll.head.data);*/
		
		
	}
	

}
