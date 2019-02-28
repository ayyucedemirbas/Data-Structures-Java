import java.util.Arrays;

public class Sorting_Algorithms {
	
	/*#################################   Selection Sort ######################################*/
	
	/*The selection sort algorithm sorts an array by repeatedly finding the minimum element 
	 * (considering ascending order) from unsorted part and putting it at the beginning. 
	 * The algorithm maintains two subarrays in a given array.
	 * 1) The subarray which is already sorted.
	 * 2) Remaining subarray which is unsorted.
	 * In every iteration of selection sort, the minimum element (considering ascending order) from 
	 * the unsorted subarray is picked and moved to the sorted subarray.

*/
	 static void selectionSort(int arr[]) { //O(n^2)
	        int n = arr.length; 
	  
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            // Find the minimum element in unsorted array 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (arr[j] < arr[min_idx]) 
	                    min_idx = j; 
	  
	            // Swap the found minimum element with the first 
	            // element 
	            int temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	        } 
	        
	    } 
	 
	 
	 /*#############################################################################################*/
	 
	 /*#########################   Bubble Sort   #######################################*/
	 
	 
	 /*First Pass:
	  * ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
	  * ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
	  * ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
	  * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does
	  *  not swap them.
	  *  
	  *  Second Pass:
	  *  ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
	  *  ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
	  *  ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	  *  ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
	  *  Now, the array is already sorted, but our algorithm does not know if it is completed. 
	  *  The algorithm needs one whole pass without any swap to know it is sorted.
	  *  
	  *  Third Pass:
	  *  ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	  *  ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	  *  ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
	  *  ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

*/
	 static void bubbleSort(int arr[]) { //O(n^2)
		 int n = arr.length; 
	        for (int i = 0; i < n-1; i++) 
	            for (int j = 0; j < n-i-1; j++) 
	                if (arr[j] > arr[j+1]) 
	                { 
	                    // swap temp and arr[i] 
	                    int temp = arr[j]; 
	                    arr[j] = arr[j+1]; 
	                    arr[j+1] = temp; 
	                } 
	        

	
	 }
	 
	 static void optimizedBubbleSort(int arr[])  { 
	        int i, j, temp, n=arr.length; 
	        boolean swapped; 
	        for (i = 0; i < n - 1; i++)  { 
	            swapped = false; 
	            for (j = 0; j < n - i - 1; j++)  { 
	                if (arr[j] > arr[j + 1])   { 
	                    // swap arr[j] and arr[j+1] 
	                    temp = arr[j]; 
	                    arr[j] = arr[j + 1]; 
	                    arr[j + 1] = temp; 
	                    swapped = true; 
	                } 
	            } 
	  
	            // IF no two elements were  
	            // swapped by inner loop, then break 
	            if (swapped == false) 
	                break; 
	        } 
	    } 
	 
	 static void recursiveBubbleSort(int arr[], int size) { 
	        // Base case 
	        if (size == 1) 
	            return; 
	       
	        // One pass of bubble sort. After 
	        // this pass, the largest element 
	        // is moved (or bubbled) to end. 
	        for (int i=0; i<size-1; i++) 
	            if (arr[i] > arr[i+1]) 
	            { 
	                // swap arr[i], arr[i+1] 
	                int temp = arr[i]; 
	                arr[i] = arr[i+1]; 
	                arr[i+1] = temp; 
	            } 
	       
	        // Largest element is fixed, 
	        // recur for remaining array 
	        recursiveBubbleSort(arr, size-1); 
	    } 
	 
	 
	 /*#############################################################################################*/
	 
	 /*###############################    Insertion Sort   #########################################*/
	 
	 static void InsertionSort (int arr[]) { //O(n^2)
	        int n = arr.length; 
	        for (int i=1; i<n; ++i) 
	        { 
	            int key = arr[i]; 
	            int j = i-1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j>=0 && arr[j] > key) 
	            { 
	                arr[j+1] = arr[j]; 
	                j = j-1; 
	            } 
	            arr[j+1] = key; 
	        } 
	    }
	 
	 
	 static void insertionSortRecursive(int arr[], int n)    { 
	        // Base case 
	        if (n <= 1) 
	            return; 
	       
	        // Sort first n-1 elements 
	        insertionSortRecursive( arr, n-1 ); 
	       
	        // Insert last element at its correct position 
	        // in sorted array. 
	        int last = arr[n-1]; 
	        int j = n-2; 
	       
	        /* Move elements of arr[0..i-1], that are 
	          greater than key, to one position ahead 
	          of their current position */
	        while (j >= 0 && arr[j] > last) 
	        { 
	            arr[j+1] = arr[j]; 
	            j--; 
	        } 
	        arr[j+1] = last; 
	    } 
	 
	 
	 /*#############################################################################################*/
	 

	 /*##########################   merge sort ###################################*/
	 
	 
	 /*Like QuickSort, Merge Sort is a Divide and Conquer algorithm.
	  *  It divides input array in two halves, calls itself for the two halves and then merges the two sorted
	  *   halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process 
	  *   that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one*/
	 
	  
	  public static void mergeSort(int[] array)  { 
	        if(array == null) 
	        { 
	            return; 
	        } 
	  
	        if(array.length > 1) 
	        { 
	            int mid = array.length / 2; 
	  
	            // Split left part 
	            int[] left = new int[mid]; 
	            for(int i = 0; i < mid; i++) 
	            { 
	                left[i] = array[i]; 
	            } 
	              
	            // Split right part 
	            int[] right = new int[array.length - mid]; 
	            for(int i = mid; i < array.length; i++) 
	            { 
	                right[i - mid] = array[i]; 
	            } 
	            mergeSort(left); 
	            mergeSort(right); 
	  
	            int i = 0; 
	            int j = 0; 
	            int k = 0; 
	  
	            // Merge left and right arrays 
	            while(i < left.length && j < right.length) 
	            { 
	                if(left[i] < right[j]) 
	                { 
	                    array[k] = left[i]; 
	                    i++; 
	                } 
	                else
	                { 
	                    array[k] = right[j]; 
	                    j++; 
	                } 
	                k++; 
	            } 
	            // Collect remaining elements 
	            while(i < left.length) 
	            { 
	                array[k] = left[i]; 
	                i++; 
	                k++; 
	            } 
	            while(j < right.length) 
	            { 
	                array[k] = right[j]; 
	                j++; 
	                k++; 
	            } 
	        } 
	    } 
	 
	 
	//T(n) = 2T(n/2) + O(n)=O(nlogn)
	 
	// Merges two subarrays of arr[]. 
	    // First subarray is arr[l..m] 
	    // Second subarray is arr[m+1..r] 
	    void merge(int arr[], int l, int m, int r)  { 
	        // Find sizes of two subarrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        /* Create temp arrays */
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 
	  
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = l; 
	        while (i < n1 && j < n2) { 
	            if (L[i] <= R[j]) { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)  { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	  
	    // Main function that sorts arr[l..r] using 
	    // merge() 
	    void sort(int arr[], int l, int r) { 
	        if (l < r)  { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 
	  
	            // Merge the sorted halves 
	            merge(arr, l, m, r); 
	        } 
	    } 
	    
	    /*#############################################################################################*/

	    
	    
	    /*#############################   Quick sort  #########################*/
	    
	    /*Like Merge Sort, QuickSort is a Divide and Conquer algorithm. 
	     * It picks an element as pivot and partitions the given array around the picked pivot. 
	     * There are many different versions of quickSort that pick pivot in different ways.
	     * 
	     * 1)Always pick first element as pivot.
	     * 2)Always pick last element as pivot (implemented below)
	     * 3)Pick a random element as pivot.
	     * 4)Pick median as pivot.
	     * 
	     * The key process in quickSort is partition(). Target of partitions is, given an array and 
	     * an element x of array as pivot, put x at its correct position in sorted array and put all smaller 
	     * elements (smaller than x) before x, and put all greater elements (greater than x) after x. 
	     * All this should be done in linear time.*/
	    
	    
	    
	    
	    
	    /* This function takes last element as pivot, 
	       places the pivot element at its correct 
	       position in sorted array, and places all 
	       smaller (smaller than pivot) to left of 
	       pivot and all greater elements to right 
	       of pivot */
	    
	    
	    
	     static int partition(int arr[], int low, int high)   { 
	        int pivot = arr[high];  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++)   { 
	            // If current element is smaller than or 
	            // equal to pivot 
	            if (arr[j] <= pivot)  { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                int temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	  
	        return i+1; 
	    } 
	  
	  
	    /* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	    void qsort(int arr[], int low, int high)  { 
	        if (low < high)  { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int pi = partition(arr, low, high); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            qsort(arr, low, pi-1); 
	            qsort(arr, pi+1, high); 
	        } 
	    } 
	    
	    
	    /* A[] --> Array to be sorted,  
	    l  --> Starting index,  
	    h  --> Ending index */
	 static void quickSortIterative (int arr[], int l, int h) 
	 { 
	     // Create an auxiliary stack 
	     int[] stack = new int[h-l+1]; 
	    
	     // initialize top of stack 
	     int top = -1; 
	    
	     // push initial values of l and h to stack 
	     stack[++top] = l; 
	     stack[++top] = h; 
	    
	     // Keep popping from stack while is not empty 
	     while (top >= 0) 
	     { 
	         // Pop h and l 
	         h = stack[top--]; 
	         l = stack[top--]; 
	    
	         // Set pivot element at its correct position 
	         // in sorted array 
	         int p = partition(arr, l, h); 
	    
	         // If there are elements on left side of pivot, 
	         // then push left side to stack 
	         if (p-1 > l) 
	         { 
	             stack[++top] = l; 
	             stack[++top] = p - 1; 
	         } 
	    
	         // If there are elements on right side of pivot, 
	         // then push right side to stack 
	         if (p+1 < h) 
	         { 
	             stack[++top] = p + 1; 
	             stack[++top] = h; 
	         } 
	     } 
	 } 
	    
	    
	    /*#############################################################################################*/
	    
	 
	 
	/*##################################  Heap Sort  #######################*/
	 
	 /*Heap sort is a comparison based sorting technique based on Binary Heap data structure. 
	  * It is similar to selection sort where we first find the maximum element and place the maximum element 
	  * at the end. We repeat the same process for remaining element.

*/
	  public void heapSort(int arr[]) 
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
	    void heapify(int arr[], int n, int i) 
	    { 
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
	    /*#############################################################################################*/
	    
	    
	    
	    /*############################    Shell Sort     ##################################*/
	    /*ShellSort is mainly a variation of Insertion Sort. 
	     * In insertion sort, we move elements only one position ahead. 
	     * When an element has to be moved far ahead, many movements are involved. 
	     * The idea of shellSort is to allow exchange of far items. 
	     * In shellSort, we make the array h-sorted for a large value of h. 
	     * We keep reducing the value of h until it becomes 1. 
	     * An array is said to be h-sorted if all sublists of every h’th element is sorted.*/
	    
	    
	    int Shellsort(int arr[]) { // O(n^2)
	        int n = arr.length; 
	  
	        // Start with a big gap, then reduce the gap 
	        for (int gap = n/2; gap > 0; gap /= 2) { 
	            // Do a gapped insertion sort for this gap size. 
	            // The first gap elements a[0..gap-1] are already 
	            // in gapped order keep adding one more element 
	            // until the entire array is gap sorted 
	            for (int i = gap; i < n; i += 1) 
	            { 
	                // add a[i] to the elements that have been gap 
	                // sorted save a[i] in temp and make a hole at 
	                // position i 
	                int temp = arr[i]; 
	  
	                // shift earlier gap-sorted elements up until 
	                // the correct location for a[i] is found 
	                int j; 
	                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
	                    arr[j] = arr[j - gap]; 
	  
	                // put temp (the original a[i]) in its correct 
	                // location 
	                arr[j] = temp; 
	            } 
	        } 
	        return 0; 
	    } 
	    
	    
	    /*#############################################################################################*/
	    
	    /*########################## Counting Sort ######################################*/
  
	    /*Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.*/
	    
	    
	    /*Counting sort is a sorting technique based on keys between a specific range. 
	     * It works by counting the number of objects having distinct key values (kind of hashing). 
	     * Then doing some arithmetic to calculate the position of each object in the output sequence.*/
	    
	    
	    void countingSort(char arr[]) 
	    { 
	        int n = arr.length; 
	  
	        // The output character array that will have sorted arr 
	        char output[] = new char[n]; 
	  
	        // Create a count array to store count of inidividul 
	        // characters and initialize count array as 0 
	        int count[] = new int[256]; 
	        for (int i=0; i<256; ++i) 
	            count[i] = 0; 
	  
	        // store count of each character 
	        for (int i=0; i<n; ++i) 
	            ++count[arr[i]]; 
	  
	        // Change count[i] so that count[i] now contains actual 
	        // position of this character in output array 
	        for (int i=1; i<=255; ++i) 
	            count[i] += count[i-1]; 
	  
	        // Build the output character array 
	        // To make it stable we are operating in reverse order. 
	        for (int i = n-1; i>=0; i--) 
	        { 
	            output[count[arr[i]]-1] = arr[i]; 
	            --count[arr[i]]; 
	        } 
	  
	        // Copy the output array to arr, so that arr now 
	        // contains sorted characters 
	        for (int i = 0; i<n; ++i) 
	            arr[i] = output[i]; 
	    } 
	    
	    
	    /*###################################################################################*/
	    
	    /*###########################  Radix sort ####################### */
	    
	    /*We can’t use counting sort because counting sort will take O(n^2) which is worse 
	     * than comparison based sorting algorithms. Can we sort such an array in linear time?
	     * Radix Sort is the answer. The idea of Radix Sort is to do digit by digit sort starting 
	     * from least significant digit to most significant digit. 
	     * Radix sort uses counting sort as a subroutine to sort.*/
	    
	    static int getMax(int arr[], int n) 
	    { 
	        int mx = arr[0]; 
	        for (int i = 1; i < n; i++) 
	            if (arr[i] > mx) 
	                mx = arr[i]; 
	        return mx; 
	    } 
	  
	    // A function to do counting sort of arr[] according to 
	    // the digit represented by exp. 
	    static void countSort(int arr[], int n, int exp) 
	    { 
	        int output[] = new int[n]; // output array 
	        int i; 
	        int count[] = new int[10]; 
	        Arrays.fill(count,0); 
	  
	        // Store count of occurrences in count[] 
	        for (i = 0; i < n; i++) 
	            count[ (arr[i]/exp)%10 ]++; 
	  
	        // Change count[i] so that count[i] now contains 
	        // actual position of this digit in output[] 
	        for (i = 1; i < 10; i++) 
	            count[i] += count[i - 1]; 
	  
	        // Build the output array 
	        for (i = n - 1; i >= 0; i--) 
	        { 
	            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
	            count[ (arr[i]/exp)%10 ]--; 
	        } 
	  
	        // Copy the output array to arr[], so that arr[] now 
	        // contains sorted numbers according to curent digit 
	        for (i = 0; i < n; i++) 
	            arr[i] = output[i]; 
	    } 
	  
	    // The main function to that sorts arr[] of size n using 
	    // Radix Sort 
	    static void radixsort(int arr[], int n) 
	    { 
	        // Find the maximum number to know number of digits 
	        int m = getMax(arr, n); 
	  
	        // Do counting sort for every digit. Note that instead 
	        // of passing digit number, exp is passed. exp is 10^i 
	        // where i is current digit number 
	        for (int exp = 1; m/exp > 0; exp *= 10) 
	            countSort(arr, n, exp); 
	    } 
	    /*###################################################################################*/
	    
	    
	    
	    
}
