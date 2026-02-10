package BinarySearch;

public class Lower_Upper_bound {
	public static void main(String[] args) {
		int[] test = new int[] {1,2,3,4,6,7,8};
		int target = 5;
		
		int floor = bSearch(test, target, true);
		int ceiling = bSearch(test,target,false);
		
		System.out.println("Floor -> " + test[floor]);
		System.out.println("Ceiling -> " + test[ceiling]);
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
	}
}
