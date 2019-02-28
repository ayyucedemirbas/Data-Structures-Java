
public class Tree {
	
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			
		}
	}
	
	Node root;
	
	Tree(){
		root=null;
	}
	
	public Node getBST(int[] arr, int start, int end) {
	    if(start > end) { 
	        return null;
	    }
	    int mid = start + (end - start) / 2;
	    Node root = new Node(arr[mid]);
	    root.left = getBST(arr, start, mid - 1);
	    root.right = getBST(arr, mid + 1, end);
	    return root;    
	}
	
   public static void main(String[] args) {
		Tree t= new Tree();	
		int[] arr= {1,2,3,4,5,6,7};
		
		Node n= t.getBST(arr, 0, 6);
		System.out.println("root.data: "+n.data);
		System.out.println("root.right.data: "+n.right.data);
		System.out.println("root.left.data: "+n.left.data);
		System.out.println("root.right.right.data: "+n.right.right.data);
		System.out.println("root.right.left.data: "+n.right.left.data);
		System.out.println("root.left.right.data: "+n.left.right.data);
		System.out.println("root.left.left.data: "+n.left.left.data);
		
		
	}

}
