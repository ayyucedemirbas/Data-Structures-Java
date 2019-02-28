package binaryTreeSwap;
 class Node{
	 int data;
	 Node left, right;
	 Node(int data){
		 this.data=data;
		 left=null;
		 right=null;
	 }
 }


public class BinaryTree {
	Node root;
	BinaryTree(int x){
		root =new Node(x);
	}
	BinaryTree(){
		root=null;
	}
	

	
	void swap(Node n1, Node n2) {// my fucking solution
		int tmp=n2.data;
		n2.data=n1.data;
		n1.data=tmp;
		
		
	}
	
	
	 void swap( Node node, int depth, int[ ] sDepths, int sI ) {//stackoverflow
	    if( node == null || sI >= sDepths.length ) return;
	    if( depth == sDepths[ sI ] ) {
	        Node tmp = node.left;
	        node.left = node.right;
	        node.right = tmp;
	        sI++;
	    }
	    swap( node.left, depth + 1, sDepths, sI );
	    swap( node.right, depth + 1, sDepths, sI );
	    
	    
	    /*First it verifies that we didn't walk off the tree and that there are more swaps to perform. 
	     * Then it checks if the current depth needs to be swapped. If it does we swap and increment the index into the swaps array.
	     *  Then we repeat on it's children. This requires sDepth to be in increasing order and initial call would be like swap( root, 0, sDepths, 0 )*/
	}
	

	public static void main(String[] args) {
		BinaryTree b= new BinaryTree();
		b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3); //
		b.root.left.left= new Node(4);
		b.root.left.right=new Node(5);//
		b.root.right.left=new Node(6);
		b.root.right.right= new Node(7);
		
		//b.swap(b.root.right, b.root.left.right);
		
		int sI=2, depth=2;
		int[] sDepths= {1,2,3};
		
		System.out.println("Before swap: ");
		System.out.println(b.root.data);
		System.out.println(b.root.left.data);
		System.out.println(b.root.right.data);
		System.out.println(b.root.left.left.data);
		System.out.println(b.root.left.right.data);
		System.out.println(b.root.right.left.data);
		System.out.println(b.root.right.right.data);
		
		
		b.swap(b.root, depth, sDepths, sI);
		
		
		System.out.println("After swap: ");
		
		
		
		System.out.println(b.root.data);
		System.out.println(b.root.left.data);
		System.out.println(b.root.right.data);
		System.out.println(b.root.left.left.data);
		System.out.println(b.root.left.right.data);
		System.out.println(b.root.right.left.data);
		System.out.println(b.root.right.right.data);
		
		
	}
	
}
