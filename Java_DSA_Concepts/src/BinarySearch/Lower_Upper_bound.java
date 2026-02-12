package BinarySearch;

// Given a sorted integer array and a target value, find the Strict Floor and Strict Ceiling of the target. 
// Unlike standard bounds, a strict neighbor cannot be equal to the target itself.


public class Lower_Upper_bound {
	public static void main(String[] args) {
		
		// Handles duplicates by ignoring matches:
		// 1. Floor: Pushes 'end' to the largest number smaller than target.
		// 2. Ceiling: Pushes 'start' to the smallest number larger than target.
		
		int[] test = new int[] {1,2,3,4,4,4,4,6,7,8};
		int target = 4;
		
		int floor = bSearch(test, target, true);
		int ceiling = bSearch(test,target,false);
		
		System.out.println("Floor -> " + test[floor] + " at index " + floor);
		System.out.println("Ceiling -> " + test[ceiling] + " at index " + ceiling);
	}
	
	static int bSearch(int[] arr, int target, boolean isFloor) {
		int start = 0;
		int end = arr.length-1;
		
		// If the loop finishes without finding the target:

		// START (Ceiling) -> Points to the smallest number GREATER than the target.
		// It is the "Insertion Point" where the target should be placed.

		// END (Floor) -> Points to the largest number SMALLER than the target.
		// It is the last element that is still strictly less than the target.
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(isFloor) {
				if(target > arr[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}else {
				if(target < arr[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		
		
		/*
		 *  RELATIONSHIP & LOGIC TABLE (Strict Floor/Ceiling)
		 *  ========================================================================================
		 *  Relationship       || isFloor Logic       || isCeiling Logic     || Reason
		 *  -------------------||---------------------||---------------------||---------------------
		 *  arr[mid] == target || end = mid - 1       || start = mid + 1     || Excludes target to 
		 *                     ||                     ||                     || find STRICT neighbor.
		 *  -------------------||---------------------||---------------------||---------------------
		 *  arr[mid] < target  || start = mid + 1     || start = mid + 1     || Look right for closer 
		 *                     ||                     ||                     || value.
		 *  -------------------||---------------------||---------------------||---------------------
		 *  arr[mid] > target  || end = mid - 1       || end = mid - 1       || Look left for closer 
		 *                     ||                     ||                     || value.
		 *  -------------------||---------------------||---------------------||---------------------
		 *  Loop Ends          || return end          || return start        || Pointers crossed; 
		 *  (start > end)      || (Largest < target)  || (Smallest > target) || bounds are found.
		 *  ========================================================================================
		 */
		
		
		
		// Handle is Element is not present
		// or element is at first or last 
		
		if(isFloor) {
			if(end < 0) {
				return end + 1;
			}else {
				return end;
			}
		}else {
			if(start > arr.length -1) {
				return start - 1;
			}else {
				return start;
			}
		}
		
		/*
		 *  BOUNDARY & OUT-OF-BOUNDS TABLE
		 *  =========================================================================================
		 *  Scenario            || Pointer Position      || Logic/Action          || Returned Index
		 *  --------------------||-----------------------||-----------------------||-----------------
		 *  Target too SMALL    || end = -1              || Floor: end + 1        || 0 (First Index)
		 *  (No Floor exists)   ||                       ||                       || 
		 *  --------------------||-----------------------||-----------------------||-----------------
		 *  Target too LARGE    || start = arr.length    || Ceiling: start - 1    || Last Index
		 *  (No Ceiling exists) ||                       ||                       || 
		 *  --------------------||-----------------------||-----------------------||-----------------
		 *  Inside Bounds       || end >= 0              || Floor: return end     || end (Valid index)
		 *  (Standard Case)     || start < arr.length    || Ceiling: return start || start (Valid index)
		 *  =========================================================================================
		 */



	}
}
