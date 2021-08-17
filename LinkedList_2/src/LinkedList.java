
public class LinkedList {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			//Constructor
			data=d;
			next= null;
		}
	}
	
	/*The new node is always added before the head of the given Linked List. 
	 * And newly added node becomes the new head of the Linked List. 
	 * For example if the given Linked List is 10->15->20->25 and we add an item 5 at the front, 
	 * then the Linked List becomes 5->10->15->20->25. 
	 * Let us call the function that adds at the front of the list is push(). 
	 * The push() must receive a pointer to the head pointer,
	 *  because push must change the head pointer to point to the new node*/
	public void push(int new_data) {
		/* This function is in LinkedList class. Inserts a
		   new Node at front of the list. This method is 
		   defined inside LinkedList class shown above */
		Node new_node = new Node(new_data);
		new_node.next=head;
		head=new_node;
	}	
	public void insertAfter(Node prev_node, int new_data) {
		/* This function is in LinkedList class.
		   Inserts a new node after the given prev_node. This method is 
		   defined inside LinkedList class shown above */
		if(prev_node==null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		Node new_node= new Node(new_data);
		new_node.next=prev_node.next;
		prev_node.next=new_node;
		
	}
	
	public void append(int new_data) {
		/* Appends a new node at the end.  This method is 
		   defined inside LinkedList class shown above */
		
		 /* 1. Allocate the Node &
	       2. Put in the data
	       3. Set next as null */
		Node new_node= new Node(new_data);
		

	    /* 4. If the Linked List is empty, then make the
	           new node as head */
		
		if(head== null) {
			head= new Node(new_data);
			return;
		}
		
	    /* 4. This new node is going to be the last node, so
	         make next of it as null */
		
		new_node.next=null;
		 /* 5. Else traverse till the last node */
		Node last= head;
		while(last.next !=null) {
			last=last.next;
			}
		 /* 6. Change the next of last node */
			last.next=new_node;
			return;
		
	}
	
    void deleteNode(int key){
        // Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    }
	
	
	
    void deleteNode_position(int position){
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;  // Unlink the deleted node from list
    }
	
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
 
    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
 
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
 
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
    }
	

}
