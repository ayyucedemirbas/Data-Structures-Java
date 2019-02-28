package heap;

public class Heap { 
	public int[] arr;
	public int size;
	Heap(int N){
		arr= new int[N];
		size=0;
	}
	
	boolean isEmpty() {
		return size==0;
	}
	
	void up(int num) {
		int par=(num-1)/2;
		while(par>=0 &&arr[par]<arr[num]) {
			int search=arr[par];
			arr[par]=arr[num];
			arr[num]=search;
			num=par;
			par=(num-1)/2;
		}
	}
	
	public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i)  { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  
	
	void down(int num) {
		int left=2*num+1, right= 2*num+2, search;
		while((left<size&& arr[num]<arr[left])||(right>=size&&arr[num]<arr[right])) {
			if(right>=size||arr[left]>arr[right]) {
				search=arr[num];
				arr[num]=arr[left];
				arr[left]=search;
				num=left;
			}
			else {
				search=arr[right];
				arr[right]=arr[num];
				arr[num]=search;
				num=right;
				
			}
			
			left=2*num+1;
			right= 2*num+2;
			
		}
		
		
	}
	
	int search(int key) {
		
		for(int i=0; i<size;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		return -1;
		
	}
	
	
	//Delete element from heap
	int delete(int k) {
		int tmp=-1;
		for(int i=0; i<k+1; i++) {
		 tmp=arr[0];
		arr[0]=arr[size-1];
		down(0);
		size--;
		}
		return tmp;
		
		
	}
	
	void add(int k) {
		size++;
		arr[size-1]=k;
		up(size-1);
		
		
	}
	
	void print() {
		//System.out.println("Heap Tree: ");
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]+" ");
		}
	}
	
	
	int[] kesisim(Heap h1, Heap h2) {
		int arr1[]= h1.arr, arr2[]= h2.arr;
		int[] kesisim= new int[arr2.length];
		int counter=0, k=0;
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i]==arr2[counter]) {
				kesisim[k]=arr2[counter];
				counter++;
				k++;
			}
			
		}
		
		
		/*if(kesisim.length!=0) {
			System.out.println("Kesisim kumesi:");
			for(int i=0; i<kesisim.length;i++) {
				System.out.println(kesisim[i]);
			}
		}
		
		else {
			System.out.println("Kesisim yok");
		}*/
		return kesisim;
	}
	
	int[] birlesim(Heap h1, Heap h2) {
		
		int count=0, k=0;
		
		int[] arr1=h1.arr;
		int[] arr2=h2.arr;
		int[] kesisim=kesisim(h1,h2);
		int[] birlesim=new int[arr1.length+arr2.length];
		
		
		
		for(int i=0; i<arr1.length;i++) {
				birlesim[k]=arr1[i];
				k++;
				
			
		}
		//k=+1;
		for(int i=0; i<arr2.length;i++) {
			if(arr2[i]!=kesisim[count]) {
			birlesim[k]=arr2[i];
			
			k++;
			
			}
			count++;
		}
		//sort(birlesim);
		
		return birlesim;
		
		
		
	}
	
	/*int Max(Heap h, int k) {
		
		int arrMax[]=h.arr;
		
		return arrMax[ arrMax.length-k];
		
		//System.out.println(k+ ".  eleman: "+ arrMax[ arrMax.length-k]);
	}*/
	
	
	
	
	public static void main(String[] args) {
		Heap h= new Heap(10);
		Heap h1= new Heap(6);
		h.add(5);
		h.add(9);
		h.add(7);
		h.add(3);
		h.add(8);
		h.add(2);
		h.add(4);
		h.add(1);
		h.add(6);
		h.add(45);
		
	h.sort(h.arr);
		//h.print();
		
	
		
		h1.add(7);
		h1.add(4);
		h1.add(6);
		h1.add(67);
		h1.add(89);
		h1.add(1);
		
		h1.sort(h1.arr);
		//h1.print();
		
		
		
		//int eb= h.delete(2);
		//System.out.println("En buyuk  "+ eb);
		

		
		int[] kesisim= h.kesisim(h, h1);
		System.out.print("Kesisim kumesi:");
		for(int i=0; i<kesisim.length;i++) {
			System.out.print(kesisim[i]+" ");
		}
		
		System.out.println("\nBirlesim Kumesi: ");
		
	  int[] birlesim= h.birlesim(h, h1);
	  
	  for(int i=0; i<birlesim.length;i++) {
			System.out.print(birlesim[i]+" ");
		}
		
		
	}
	
	
} 