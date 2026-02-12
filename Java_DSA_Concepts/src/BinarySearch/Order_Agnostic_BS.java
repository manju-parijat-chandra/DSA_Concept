package BinarySearch;

// Given a sorted integer array and a target value, determine if the target exists in the array. 
// The array is guaranteed to be sorted, but you do not know if it is sorted in ascending (increasing) or descending (decreasing) order.


public class Order_Agnostic_BS {
	public static void main(String[] args) {
		
		int[] asc = new int[] {1,2,3,4,5,6};
		int[] desc = new int[] {6,5,4,3,2,1};
		
		System.out.println(oabSearch(asc,0,asc.length-1, 3));
		System.out.println(oabSearch(desc,0,desc.length-1, 3));
		
	}
	static boolean oabSearch(int[] arr, int start, int end, int target) {
		
		if(arr.length == 0) {
			return false;
		}
		
		
		// Use == to handle duplicate
		// it assign default ascending if equals
		
		boolean trend = arr[start] <= arr[end];
		
		/*
		 *  TREND IDENTIFICATION TABLE
		 *  ========================================================================================
		 *  Condition             || Result (trend)      || Meaning             || Default Handling
		 *  -------------------   ||---------------------||---------------------||---------------------
		 *  arr[start] < arr[end] || true                || Ascending Order     || Standard BS logic.
		 *  -------------------   ||---------------------||---------------------||---------------------
		 *  arr[start] > arr[end] || false               || Descending Order    || Reverse BS logic.
		 *  -------------------   ||---------------------||---------------------||---------------------
		 *  arr[start] == arr[end]|| true (Default)      || Equal Elements      || Handles single-element 
		 *                        ||                     ||                     || or all-duplicate arrays.
		 *  ========================================================================================
		 */

		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == target) {
				return true;
			}
			
			if(trend) {
				if(target > arr[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}else {
				if(target > arr[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		
		/*
		 *  SEARCH MOVEMENT TABLE (After mid calculation)
		 *  ========================================================================================
		 *  Scenario           || if (trend == true)  || if (trend == false) || Reason
		 *                     || (Ascending)         || (Descending)        ||
		 *  -------------------||---------------------||---------------------||---------------------
		 *  target > arr[mid]  || start = mid + 1     || end = mid - 1       || In Descending, larger 
		 *                     ||                     ||                     || values are on the LEFT.
		 *  -------------------||---------------------||---------------------||---------------------
		 *  target < arr[mid]  || end = mid - 1       || start = mid + 1     || In Descending, smaller 
		 *                     ||                     ||                     || values are on the RIGHT.
		 *  -------------------||---------------------||---------------------||---------------------
		 *  target == arr[mid] || return true         || return true         || Target found!
		 *  ========================================================================================
		 */

		
		return false;
	}

}
