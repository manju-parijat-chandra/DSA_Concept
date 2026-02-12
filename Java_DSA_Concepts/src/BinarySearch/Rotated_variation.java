package BinarySearch;

public class Rotated_variation {
	public static void main(String[] args) {
		
		int[] test = new int[] {1};
		
		int peak = findPivotInDuplicate(test);
		
		int target = 1;
		int index = 0;
		
		if(target <= test[test.length - 1]) {
			index = searchInRotated(test, peak + 1, test.length - 1, target);
		}else {
			index = searchInRotated(test, 0, peak,  target);
		}
		
		System.out.println("Fond " + target + " at index " + index);
		
		/*
		 *  TARGET SEARCH STRATEGY TABLE
		 *  ========================================================================================================================
		 *  Scenario                || Logic Condition             || Search Range         || Array Example (Target: 1)
		 *  ------------------------||-----------------------------||----------------------||----------------------------------------
		 *  Array Not Rotated       || peak == -1                  || 0 to last            || [1, 2, 3] -> Normal Binary Search.
		 *  ------------------------||-----------------------------||----------------------||----------------------------------------
		 *  Target is the Peak      || target == arr[peak]         || return peak          || [5, 9, 1] -> Target 9 found at peak.
		 *  ------------------------||-----------------------------||----------------------||----------------------------------------
		 *  Target in Right Mountain|| target <= arr[last]         || peak + 1 to last     || [5, 9, 1, 2] -> 1 <= 2 is TRUE.
		 *                          ||                             ||                      || (Search Right Half: [1, 2])
		 *  ------------------------||-----------------------------||----------------------||----------------------------------------
		 *  Target in Left Mountain || target > arr[last]          || 0 to peak            || [8, 9, 1, 2] -> Target 8. 8 > 2 is TRUE.
		 *                          || (or target >= arr[0])       ||                      || (Search Left Half: [8, 9])
		 *  ========================================================================================================================
		 */
		
		/*   *****************************************************
		 * If the array has only one element, no rotation is possible. 
		 * The single element is technically both the start and the peak.
		 */
	}
	
	static int searchInRotated(int[] arr, int start, int end, int target) {
		// Binary Search in the Array Half's
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}
			
			if(target > arr[mid]) {
				// Target is after MID
				start = mid + 1;
			}else {
				// Target is before MID
				end = mid - 1;
			}
		}
		return -1;
	}
	
	// This code works only for non duplicate elements
	static int findPivot(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;

			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}
			
			/*
			 *  PIVOT DETECTION TABLE (Direct Checks)
			 *  =====================================================================================================================
			 *  Condition            || Result              || Logic / Reason                         || Array Example (Peak=9)
			 *  ---------------------||---------------------||----------------------------------------||-----------------------------
			 *  arr[mid] > arr[mid+1]|| return mid          || Mid is the "cliff". The next element   || [5, 9, 1, 2]
			 *                       ||                     || drops, so mid is the highest point.    || mid=1 (9), mid+1=1 (9 > 1)
			 *  ---------------------||---------------------||----------------------------------------||-----------------------------
			 *  arr[mid] < arr[mid-1]|| return mid - 1      || Mid is the smallest element. The one   || [5, 9, 1, 2]
			 *                       ||                     || before it (mid-1) must be the peak.    || mid=2 (1), mid-1=9 (1 < 9)
			 *  =====================================================================================================================
			 */
			
            if(arr[start] > arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            
            /*
             *  SEARCH DIRECTION TABLE (Deciding where to move)
             *  =====================================================================================================================
             *  Case / Relationship   || Status              || Action           || Reason               || Array Example (Peak=9)
             *  --------------------- ||---------------------||------------------||----------------------||---------------------------
             *  arr[start] > arr[mid] || Left is Unsorted    || end = mid - 1    || The rotation "jump"  || [8, 9, 1, 2, 3]
             *                        ||                     ||                  || is in the left half. || S=8, M=1, E=3 (8 > 1)
             *  --------------------- ||---------------------||------------------||----------------------||---------------------------
             *  arr[start] < arr[mid] || Left is Sorted      || start = mid + 1  || The peak must be in  || [1, 2, 8, 9, 0]
             *                        ||                     ||                  || the right half.      || S=1, M=8, E=0 (1 < 8)
             *  --------------------- ||---------------------||------------------||----------------------||---------------------------
             *  arr[start] == arr[mid]|| Window is Small     || start = mid + 1  || Defaults to right to || [1, 2] 
             *                        ||                     ||                  || exhaust the search.  || S=1, M=1, E=2 (1 == 1)
             *  =====================================================================================================================
             */
        
            
            /*
             *  POINTER CONVERGENCE RULES
             *  **********************************************************************************
             *  arr[start] == arr[mid] -> Occurs when only 2 elements remain (Size 2).
             *                            Indices: start and mid point to the same first element.
             *
             *  arr[mid]   == arr[end] -> Occurs when only 1 element remains (Size 1).
             *                            Indices: start, mid, and end all point to the same spot.
             *  **********************************************************************************
             */

		}
		return end;
		//return -1;
		
		/*
		 *  TERMINATION TABLE (Loop Exit Scenarios)
		 *  =====================================================================================================================
		 *  Scenario             || Final Value of 'end'|| Outcome                              || Array Example
		 *  ---------------------||---------------------||--------------------------------------|| --------------------------
		 *  Rotation Found       || N/A                 || Returns 'mid' or 'mid-1' inside loop.|| [4, 5, 1, 2] -> returns 1(5)
		 *  ---------------------||---------------------||--------------------------------------||---------------------------
		 *  No Rotation (Sorted) || arr.length - 1      || Returns last index (The max value).  || [1, 2, 3, 4] -> returns 3(4)
		 *  ---------------------||---------------------||--------------------------------------||---------------------------
		 *  Array Size 1         || 0                   || Returns 0 (The only element).        || [5] -> returns 0(5)
		 *  =====================================================================================================================
		 */

	}
	
	// Find Pivot if array contains duplicate
	static int findPivotInDuplicate(int[] arr) {
		
		int start  = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			//Case 1 -> mid is greater than mid + 1 (!! - Mid is not at end "length -1" Otherwise Index overflow)
			if(mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			// Case 2 -> mid - 1 is greater than mid (!! - mid is not at start "0" Otherwise index underflow)
			if(mid > start && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}
			// Case 3 -> Since it contains Duplicate elements . if (Start - End - Mid) are same . (Skip start and end) 
			// Check start and end if those are peak element. Otherwise It's safe to SKIP
			if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
				// Check Start is not the Peak
				// also check if start and end are not at same position
				if(start < end && arr[start] > arr[start + 1]) {
					// If condition matches the start is Peak otherwise we can skip start
					return start;
				}
				start ++;
				// Check if end is not a peak . and safe to SKIP
				if(end > start && arr[end - 1] > arr[end]) {
					// End is Peak
					return end -1;
				}
				end --;
			}else 
				
			/* --------------------------------||---------------------------||-----------------------||-------------------------------------------
			 * Relationship                    ||   Logic Status            || Result/Action         || Array Example (Peak=9)
			 * arr[mid] > arr[mid + 1]         ||   Peak Found at Mid       || return mid            || [..., 9, 1, ...] -> mid points to 9
			 *				                   ||                           ||                       || arr[mid]=9 > arr[mid+1]=1
			 * --------------------------------||---------------------------||-----------------------||-------------------------------------------
			 * arr[mid - 1] > arr[mid]         ||   Peak Found at Mid-1     || return mid - 1        || [..., 9, 1, ...] -> mid points to 1
			 *			                       ||                           ||                       || arr[mid-1]=9 > arr[mid]=1
			 * --------------------------------||---------------------------||-----------------------||-------------------------------------------
			 * arr[start] == mid == end        ||   "Blind Spot" Detected   || Check Edges & Shrink  || [2, 9, 2, 2, 2] -> S=2, M=2, E=2
			 *                                 ||                           ||                       || Trend is hidden by duplicates.
			 * --------------------------------||---------------------------||-----------------------||-------------------------------------------
			 * start++ AND end--               ||   Linear Window Shrink    || Continue Search       || [2, 2, 9, 2, 2] -> S=2, M=2, E=2
			 *                                 ||                           ||                       || Window shrinks to [2, 9, 2] 
			*/                                 
				
			if(arr[mid] > arr[start] || arr[start] == arr[mid] && arr[mid] > arr[end]){
				start = mid + 1;
			}else {
				end = mid - 1;
			}
			
//			if(arr[mid] > arr[start] || arr[start] == arr[mid]){
//				start = mid + 1;
//			}else {
//				end = mid - 1;
//			}
			
			
//			if(arr[start] > arr[mid]) {
//				end = mid - 1;
//			}else {
//				start = mid+1;
//			}
			
			/* Relationship                    ||   Logic Status            || Where is the Peak?   ||    Direction    ||  Array Example (Peak=9)
			 * --------------------------------||---------------------------||----------------------||-----------------||-------------------------
			 * start < mid                     ||   Left side is Sorted     ||     Right Side       ||    Right        || [5, 6, 8, 9, 1] 
			 *			                       ||                           ||                      ||   (start=mid+1) || S=5, M=8, E=1 (5 < 8)
			 * --------------------------------||---------------------------||----------------------||-----------------||-------------------------
			 * start == mid AND mid > end      ||   Left side is Sorted     ||     Right Side       ||    Right        || [2, 2, 4, 1]
			 *			                       ||                           ||                      ||   (start=mid+1) || S=2, M=2, E=1 (2 > 1)
			 * --------------------------------||---------------------------||----------------------||-----------------||-------------------------
			 * start == mid AND mid > end      ||   Left side is Sorted     ||     Right Side       ||    Right        || [2, 2, 2, 1]
			 *                                 ||                           ||                      ||   (start=mid+1) || S=2, M=2, E=3 (2 < 1)
			 * --------------------------------||---------------------------||----------------------||-----------------||-------------------------
			 * start == mid AND end > mid      ||   Array is not Rotated    ||     Right Side       ||    Right        || [2, 2, 2, 3]
			 *                                 ||                           ||                      ||   (start=mid+1) || S=2, M=2, E=3 (3 > 2)
			 * --------------------------------||---------------------------||----------------------||-----------------||-------------------------
			 *			                      ********* OR ********* (The 'Else' Block Logic) *********
			 * --------------------------------||---------------------------||----------------------||-----------------||-------------------------
			 * start > mid                     ||   Left side is Broken     ||     Left Side        ||    Left         || [9, 1, 1, 1]
			 *                                 ||                           ||                      ||    (end=mid-1)  || S=9, M=1, E=1 (9 > 1)
			 */                                 	
		}
		
		return -1;
		
		/*
		 *  TERMINATION & RESULT TABLE
		 *  =========================================================================================================================
		 *  Scenario             || Final State (S, M, E) || Return Value     || Meaning / Outcome         || Example Array
		 *  ---------------------||-----------------------||------------------||---------------------------||-------------------------
		 *  Peak Found (Inside)  || S=1, M=3, E=5         || mid OR mid-1     || The "cliff" was found;    || [2, 2, 9, 2, 2] 
		 *                       ||                       || (Valid Index)    || Array is rotated.         || Returns Index 2 (Value 9)
		 *  ---------------------||-----------------------||------------------||---------------------------||-------------------------
		 *  Standard Sorted      || start > end           || -1               || No "jump" found; Array    || [1, 2, 3, 4, 5]
		 *                       ||                       ||                  || is in ascending order.    || Returns -1
		 *  ---------------------||-----------------------||------------------||---------------------------||-------------------------
		 *  All Elements Equal   || start > end           || -1               || Window exhausted; No      || [2, 2, 2, 2, 2]
		 *                       ||                       ||                  || peak exists.              || Returns -1
		 *  ---------------------||-----------------------||------------------||---------------------------||-------------------------
		 *  Single Element       || start > end           || -1               || (mid < end) never hits;   || [5]
		 *                       ||                       ||                  || treated as sorted.        || Returns -1
		 *  =========================================================================================================================
		 */

	}
	
}







