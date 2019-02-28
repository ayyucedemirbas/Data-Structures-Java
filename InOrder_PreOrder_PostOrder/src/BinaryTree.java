class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data=data;
		left=null; right=null;
	}
	
}
public class BinaryTree {
	Node root;
	BinaryTree(int x){
		root=new Node(x);
	}
	public BinaryTree() {
		root=null;
	}	
	void print(Node n) {
		while(n!=null) {
			System.out.println(n.data);
			n=n.left;
		}
		
		n=root;
		while(n!=null) {
			System.out.println(n.data);
			n=n.right;
		}
		
		
	}
	void inOrderTraversal(Node n) {
		if(n!=null) {
			inOrderTraversal(n.left);
			System.out.print(n.data+" ");
			inOrderTraversal(n.right);
		}
	}
	
	void preOrderTraversal(Node n) {
		if(n!=null) {
			System.out.print(n.data+" ");
			preOrderTraversal(n.left);
			preOrderTraversal(n.right);
		}
	}
	void postOrderTraversal(Node n) {
		if(n!=null) {
		postOrderTraversal(n.left);
		postOrderTraversal(n.right);     
		
		System.out.print(n.data+" ");
		}
	}
	
	public static void main(String[] args) {   
		BinaryTree bt = new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		bt.root.left.left=new Node(4);
		bt.root.left.right=new Node(5);
		bt.root.right.left=new Node(6);
		bt.root.right.right=new Node(7);
		
		/*                                      1 
                                                     /     \
                                                  2          3
                                                 /  \      /    \  
                                               4     5     6     7
*/
		
		
			
		
		
	//	bt.inOrderTraversal(bt.root);  //4 2 5 1 6 3 7 
	//	bt.preOrderTraversal(bt.root); //1 2 4 5 3 6 7 
		bt.postOrderTraversal(bt.root); //4 5 2 6 7 3 1
		
	}

}
