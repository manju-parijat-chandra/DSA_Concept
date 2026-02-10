package BinarySearch;

public class Rotated_Infinite_variation {
	public static void main(String[] args) {
		int[] test1 = new int[] {5,6,7,8,9,10,1,2,3,4};
		int[] test2 = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] test3 = new int[] {11,5,6,7,8,9,10};
		int peak1 = findPivot(test1);
		int peak2 = findPivot(test2);
		int peak3 = findPivot(test3);
		
		System.out.println(test1[peak1]);
		System.out.println(test2[peak2]);
		System.out.println(test3[peak3]);
	}
	
	static int searchInRotated(int[] arr, int start, int end, int target) {
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
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
	
	
	static int findPivot(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			//System.out.println("Start - " + start + " End - " + end + " Mid - " + mid);
			
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
	
}
