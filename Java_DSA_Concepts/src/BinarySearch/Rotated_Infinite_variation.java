package BinarySearch;

public class Rotated_Infinite_variation {
	public static void main(String[] args) {
		// int[] test = new int[] {5,6,7,8,9,10,1,2,3,4};
		
		int[] test = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		
		int peak = findPivotInDuplicate(test);
		
		System.out.println("Peak " + test[peak] + " at index " + peak);
		
		int target = 2;
		
		// Now Find the target element in rotated binary search
		
		// As Array is split in two half ->  0 to peak AND peak to last
		
		// First Find target in First half -> If not present then -> Find in second half
		
		int index = 0;
		
		// If target is >= start element then array is present in First half 
		if(target >= test[0]) {
			index = searchInRotated(test, 0, peak, target);
		}else {
			index = searchInRotated(test, peak + 1, test.length -1,  target);
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
			
            if(arr[start] > arr[mid]){
            	// Left side is unsorted, so peak must be there
                end = mid - 1;
            }else{
            	// Since == is included in here . If start and mid are same > For last element.
            	// start go out of the index from last as mid+1
            	// Left side is sorted, so peak must be on the right
                start = mid + 1;
            }
			
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
				if(end > start && arr[end] > arr[end-1]) {
					// End is Peak
					return end;
				}
				end --;
			}
			
			// If start > mid . i.e - mid is currently in second half AND Therefore Peak lies left side
			
			//element at start is equal to mid and  mid is greater than end -> in this case my peak is left side.  
			// Therefore we can not skip this part.. so include in condition
			
			if(arr[start] > arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
				end = mid - 1;
			}else {
				// in this case mid could be peak or peak is present to right side of mid
				start = mid + 1;
			}
			
			
		}
		
		return -1;
	}
	
}
