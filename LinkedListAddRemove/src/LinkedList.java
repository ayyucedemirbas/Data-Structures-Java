
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
	
	void print(Node n) {
		while(n!= null) {
			System.out.println(n.data);
			n=n.next;
		}
	}
	
	
	void push(int x) {
		Node n= new Node(x);
		n.next=head;
		head=n;
		
	}
	
	void deleteNode(int key) {
		Node temp=head, prev=null;
		if(temp!=null&&temp.data==key) {
			head=temp.next; return;
		}
		
		while(temp!=null&&temp.data!=key) {
			prev=temp; temp=temp.next;
		}
		if(temp==null) {
			return;
			
		}
		prev.next=temp.next;
	}
	
	
	
	void _deleteNode(int position) {
		if(head==null)return;
		Node temp=head;
		if(position==0) {head=temp.next; return;}
		for(int i=0; temp!=null&&i<position;i++) {
			temp=temp.next;
		}
		
		
		if(temp==null || temp.next==null) return;
		
		Node next=temp.next.next;
		temp.next=next;
	}
	
	public void insertAfter(Node prev_node, int new_data) 
    { 
        /* 1. Check if the given Node is null */
        if (prev_node == null) 
        { 
            System.out.println("The given previous node cannot be null"); 
            return; 
        } 
  
        /* 2 & 3: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next; 
  
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node; 
    } 
     
    /* Appends a new node at the end.  This method is  
       defined inside LinkedList class shown above */
    public void append(int new_data) 
    { 
        /* 1. Allocate the Node & 
           2. Put in the data 
           3. Set next as null */
        Node new_node = new Node(new_data); 
  
        /* 4. If the Linked List is empty, then make the 
              new node as head */
        if (head == null) 
        { 
            head = new Node(new_data); 
            return; 
        } 
  
        /* 4. This new node is going to be the last node, so 
              make next of it as null */
        new_node.next = null; 
  
        /* 5. Else traverse till the last node */
        Node last = head;  
        while (last.next != null) 
            last = last.next; 
  
        /* 6. Change the next of last node */
        last.next = new_node; 
        return; 
    } 
	
	
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		l1.push(5);
		l1.push(4);
		l1.push(3);
		l1.push(2);
		l1.push(1);
		
		
		
		//bas kisma bir eleman ekleme
		
		//LinkedList tmp= new LinkedList();
		/*tmp.push(1);
		tmp.head.next=l1.head;*/
		
		//l1.print(tmp.head);
		
		//bas kisma birden fazla eleman ekleme
		
	/*	for(int i=10; i<20; i++ ) {
			tmp.push(i);
			
			tmp.head.next=l1.head;
			l1.head=tmp.head;
			
		}
		
	
		
		l1.print(tmp.head);*/
		
		
		LinkedList l2= new LinkedList();
	    l2.push(9);	
	    l2.push(8);
	    l2.push(7);
	    l2.push(6);	
	
	    
	    l2.insertAfter(l2.head, 24);
	    
	    Node n=l1.head;
	    
	    while(n.next!=null) {
	    	n=n.next;
	    //	if(n.data==5) break;   //fucking solution
	    }
	    
	    n.next=l2.head;
	    
	 // System.out.println(n.data);
	   //l1.print(l1.head);
	   
	    
		l1.deleteNode(7);
		
		l1._deleteNode(0);
		
		l1.print(l1.head);
		
		
	}
	

}
