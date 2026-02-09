package BinarySearch;

public class Binary_Search {
	public static void main(String[] args) {
		int[] test = new int[] {-1,0,3,6,10,12,15,20};
		
		// Initialize Start and End Index
		//int start = 0;
		int end = test.length - 1;
		
		System.out.println(bSearch(test, 0, end, 1));
		System.out.println(bSearch(test, 0, end, 17));
		System.out.println(bSearch(test, 0, end, 12));
		System.out.println(bSearch(test, 0, end, 100));
	}
	
	static boolean bSearch (int[] arr, int start, int end, int target) {
		
		// Check if array is empty
		if(arr.length == 0) {
			return false;
		}
		
		// Keep searching until start crosses end index
		
		while(start <= end) {
			// pick middle element and determine target location -> first half or second half
			int mid = start + (end - start) / 2;
			
			// Check if target is at mid 
			if(arr[mid] == target) {
				return true;
			}
			
			// Since sorted array. if target is greater than mid then 
			// new search space is mid till end
			
			if(target > arr[mid]) {
				// till mid we don't have our target element
				start = mid + 1;
			}else {
				// mid is not our target as verified before
				// target is present before mid as it is less than mid
				end = mid - 1;
			}
		}
		
		return false;
	}
}
