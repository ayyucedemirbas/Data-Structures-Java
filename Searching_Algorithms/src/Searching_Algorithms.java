
public class Searching_Algorithms {
	
	/*########################  Linear Search    ###############################*/
	static int Linearsearch(int arr[], int n, int x) { //O(n)
        for (int i = 0; i < n; i++)  { 
            // Return the index of the element if the element 
            // is found 
            if (arr[i] == x) 
                return i; 
        } 
   
        // return -1 if the element is not found 
        return -1; 
    } 
	
	/*###################################################################################*/
	
	/*########################  Binary Search    ###############################*/
	
	//T(n) = T(n/2) + c 
	
	static int binarySearch(int arr[], int l, int r, int x)  { 
	        if (r>=l) 
	        { 
	            int mid = l + (r - l)/2; 
	  
	            // If the element is present at the  
	            // middle itself 
	            if (arr[mid] == x) 
	               return mid; 
	  
	            // If element is smaller than mid, then  
	            // it can only be present in left subarray 
	            if (arr[mid] > x) 
	               return binarySearch(arr, l, mid-1, x); 
	  
	            // Else the element can only be present 
	            // in right subarray 
	            return binarySearch(arr, mid+1, r, x); 
	        } 
	  
	        // We reach here when element is not present 
	        //  in array 
	        return -1; 
	    } 
	
	 static int recBinarySearch(int arr[], int l, int r, int x)  { 
	        if (r>=l)  { 
	            int mid = l + (r - l)/2; 
	    // If the element is present at the  
	            // middle itself 
	            if (arr[mid] == x) 
	               return mid; 
	  
	            // If element is smaller than mid, then  
	            // it can only be present in left subarray 
	            if (arr[mid] > x) 
	               return recBinarySearch(arr, l, mid-1, x); 
	  
	            // Else the element can only be present 
	            // in right subarray 
	            return recBinarySearch(arr, mid+1, r, x); 
	        } 
	  
	        // We reach here when element is not present 
	        //  in array 
	        return -1; 
	    } 
	
	 /*###################################################################################*/
	
}
