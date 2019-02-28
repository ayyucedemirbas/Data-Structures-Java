package tree_longestPath;

public class Tree {
  Node root;
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	
	Tree(){
		root=null;
	}
	

	 void longestPath() {
		 Node tmp=root;
		 System.out.print(tmp.data+" ");
		 int key;
		 while(tmp!=null) {
			 key= tmp.data+1;
			 if(tmp.left.data==key ) {
				 tmp=tmp.left;
				 System.out.print(tmp.data+" ");
			 }
			 else if(tmp.right.data==key) {
				 tmp=tmp.right;
				 System.out.print(tmp.data+" ");
			 }
		 }
	 }
	 
	 
	 
	
	
	public static void main(String[] args) {
		Tree tree= new Tree();

		
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.left.right= new Node(3);
		tree.root.left.right.left=new Node(4);
		tree.root.left.left=new Node(9);
		tree.root.right=new Node(5);
		tree.root.right.left= new Node(7);
		tree.root.right.right= new Node(6);
	        
	        /* 
            1 
         /     \ 
        2      5 
       /  \    /  \ 
      9   3   7    6
          /
         4  
      
      */
	        
	        
	    
	        tree.longestPath();
	        
	        
	       
	}
	
}
