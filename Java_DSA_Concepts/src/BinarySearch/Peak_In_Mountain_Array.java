package BinarySearch;

public class Peak_In_Mountain_Array {
	public static void main(String[] args) {
		int[] test = new int[] {2,1};
		
		System.out.print(findPeak(test));
	}
	
	static int findPeak(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		
		// Loop until start and end meet at the peak
		while(start < end) {
			int mid = start + (end - start)/2;
			
			// If start <= end -> equal is included then we can't compare mid and mid + 1. (if only one element)
			// If only element in array. then start = end = mid. and mid + 1 is out of bound
			// At last we will have start and end as our peak as we are stopping when start = mid .
			// Then only two element is remaining , and on next iteration -> end = mid. where condition broke with start and end at peak 
			
			if(arr[mid] > arr[mid+1]) {
				// This could be the peak, but look at the left to be sure.
				end = mid;
			}else {
				// Because arr[mid+1] > arr[mid], mid is definitely not the peak.
				start = mid + 1;
			}
			/*
			 *  MOUNTAIN PEAK RELATIONSHIP TABLE
			 *  ====================================================================================================
			 *  Relationship         || Slope Status        || Where is Peak? || Action           || Example Array
			 *  ---------------------||---------------------||----------------||------------------||----------------
			 *  arr[mid] > arr[mid+1]|| Descending (Down)   || At Mid or Left || end = mid        || [8, 4, 3, 2]
			 *                       ||                     ||                ||                  || mid=8, next=4
			 *  ---------------------||---------------------||----------------||------------------||----------------
			 *  arr[mid] < arr[mid+1]|| Ascending (Up)      || Strictly Right || start = mid + 1  || [5, 6, 7, 8]
			 *                       ||                     ||                ||                  || mid=6, next=7
			 *  ====================================================================================================
			 *  
			 *  mid == mid + 1 (Impossible since we have unique element.
			 *  mid == start But mid != end --> Means only two element in array remaining
			 */
		}
		// At the end, start == end, both pointing to the largest element.
		return end; // return start
	}
}
