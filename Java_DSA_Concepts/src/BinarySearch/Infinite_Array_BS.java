package BinarySearch;

public class Infinite_Array_BS {
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4};
		
		int start = 0;
		int end = 0;
		
		int target = 2;
		
		// First Find Range ...
		
		while(target > arr[end]) {
			// S = e + 1                ----> (previous end + 1)
			// -> E - S = 2(e - s) + 1  ----> (2 * previous length + 1)
			// E = 2(e - s) + e + 1 + 1
			// E = 3e -2s + 2
			// E = e + 2(e - s + 1)
			
			int cStart = end + 1;
			end = end + 2 * (end - start + 1);
			start = cStart;
			
			System.out.println("Start - " + start + " End - " + end);
		}
		
		boolean found = bSearch_Infinite(arr, start, end, target);
		System.out.print(found);
	}
	
	static boolean bSearch_Infinite(int[] arr,int start, int end, int target) {
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return true;
			}
			if(target > arr[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return false;
	}
}
