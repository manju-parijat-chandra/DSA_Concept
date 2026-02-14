package BinarySearch;

// Given an array of integers sorted in strictly increasing (ascending) order, determine if a specific target value exists within the array.


public class Binary_Search {
	public static void main(String[] args) {
		int[] test = new int[] {-1,0,3,6,10,12,15,20};
		
		// Initialize Start and End Index
		// int start = 0;
		int end = test.length - 1;
		
		System.out.println(bSearch(test, 0, end, 1));
		System.out.println(bSearch(test, 0, end, 17));
		System.out.println(bSearch(test, 0, end, 12));
		System.out.println(bSearch(test, 0, end, 100));
	}
	
	
	// Works perfectly with duplicate elements.
	
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
			
// Relationship    ||   Logic Status             || Search Direction   || Reason										  || Array Example (Target: 12)
// ----------------||----------------------------||--------------------||-------------------------------------------------||-----------------------------
// target > mid    || Target is in Right Half    || start = mid + 1    || All elements before mid are smaller than target.|| 12 > 11    -> [10,11,12,13]
// ----------------||----------------------------||--------------------||-------------------------------------------------||-----------------------------
// target == mid   || Target Found               || return true        || mid index matches our target value.             || 12 = 12    -> [11,12,13]
// ----------------||----------------------------||--------------------||-------------------------------------------------||-----------------------------
// target < mid    || Target is in Left Half     || end = mid - 1      || All elements after mid are larger than target.  || 12 < 13    -> [12,13]
			

		}
		return false;
	}
}


// *********************************************************************************************************************************
// If -> While(start < end)
//         --> start and mid at same place whereas end at (start or mid) + 1
// If -> While(start <= end)
//         --> mid and end at same place Whereas start at (end or mid) + 1
