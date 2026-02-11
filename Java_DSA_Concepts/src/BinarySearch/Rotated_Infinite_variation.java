package BinarySearch;

public class Rotated_Infinite_variation {
	public static void main(String[] args) {
		// int[] test = new int[] {5,6,7,8,9,10,1,2,3,4};
		
		int[] test = new int[] {1};
		
		int peak = findPivotInDuplicate(test);
		
		if(peak != -1) {
		System.out.println("Peak " + test[peak] + " at index " + peak);
		}
		int target = 1;
		
		// Now Find the target element in rotated binary search
		
		// As Array is split in two half ->  0 to peak AND peak to last
		
		// First Find target in First half -> If not present then -> Find in second half
		
		int index = 0;
		
		// If target is >= start element then array is present in First half 
		if(target <= test[test.length - 1]) {
			index = searchInRotated(test, peak + 1, test.length - 1, target);
		}else {
			index = searchInRotated(test, 0, peak,  target);
		}
		
		System.out.println("Fond " + target + " at index " + index);
		
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
			System.out.println("Start - " + start + " End - " + end + " Mid - " + mid);
			
			// find index where mid > mid + 1  OR  mid < mid - 1
			
			// Check if 'mid' is the peak (next element is smaller)
			// Also check if mid is not at 0 -> (mid - 1)
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			
			// Check if 'mid-1' is the peak (current element is smaller than previous)
			// and check if mid is not at the end -> (mid + 1)
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}
			
			// Decide which side to search:
			
			// 4 Sub cases - 
			// a ->  start > mid ? -> means mid is in right side array. therefore we should search for peak in left side
			//                                                                                  **** end = mid - 1 ****
			
			// b -> start == mid  // Possible only when end is next to start. 
			// -> This means Left side doesn't contain our peak element. so search in right - > *** start = mid + 1 ***
			
			// c -> mid > start ? -> means left side array doens't have peak i.e ->             **** start = mid + 1; ****
			
			
            if(arr[start] > arr[mid]){
            	// Left side is unsorted, so peak must be there
                end = mid - 1;
            }else{
            	// Since == is included in here . If start and mid are same > For last element.
            	// start go out of the index from last as mid+1
            	// Left side is sorted, so peak must be on the right
                start = mid + 1;
            }
            
			// when mid == end // Possible only when start and mid are at same position 
			// -> next iteration start = mid + 1. and returns - 1. 
			// as this case could not meet the requirement for rotated array means array is not rotated
			
		}
		
		// If Start , Mid , End is at the end . (case when last element is peak)
		// Why? -> we have to compare peak element with peak + 1. (in this case it is not present)
		return end;
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
			
			
//			When the values at start, mid, and end are equal, Binary Search cannot decide which way to go. Your code handles this by:
//				Verifying the edges aren't the peak.
//				Shrinking the search window by 1 on both sides.
//				Continuing the binary search on the smaller window.

			
			
			
			
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
				
				// Remaining condition 
				// Decide where to search when element at start, mid are equal  AND  element at mid > end 
				// in this case peak is after mid -> start = mid + 1
				
			if(arr[mid] > arr[start] || arr[start] == arr[mid] && arr[mid] > arr[end]){
				start = mid + 1;
			}else {
				// remaining case
				end = mid - 1;
			}
			
			
			// Relationship                    ||   Logic Status	         || Where is the Peak?	||    Direction    ||  Array
			
			// start < mid	                   ||   Left side is Sorted      ||	   Right Side	    ||    Right        || [5, 6, 7, 8, 9, 1, 2]
			// start == mid AND mid > end	   ||   Right side is Broken	 ||    Right Side	    ||    Right        || [2, 2, 2, 9, 1]
			//                                     ********* OR *********
			// start > mid	                   ||   Left side is Broken	     ||    Left Side	    ||    Left         || [9, 10, 1, 2, 3]
			// start == mid AND mid < end	   ||   Right side is Sorted	 ||    Left Side	    ||    Left         || [2, 9, 2, 2, 3]
			
			
			
			// Remaining case when start and mid and end are at same position. 
			// Equal by value is already covered before
			// this means peak is at the end so we return -1 which will be handled later
			
		}
		
		return -1;
	}
	
}







