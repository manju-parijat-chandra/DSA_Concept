package BinarySearch;

public class Boundary_Duplicate_Variations {
	public static void main(String[] args) {
		int[] test = new int[] {1,2,3,4,4,5,6,7,8};
		
		int fIdx = occurrence(test,4,true);
		int lIdx = occurrence(test,4,false);
		
		// To find Total Count
		int totalOcc = -1;
		
		if(fIdx == -1) {
			totalOcc = 0;
		}else {
			totalOcc = lIdx - fIdx + 1;
		}
		
		// f -> 4, l -> 7 --> l - f = 3. 
		// Add 1 to include first as well
		// 3 + 1
		
		System.out.print(totalOcc);
		
	}
	static int occurrence(int[] arr, int target, boolean isFirst) {
		
		// Safety Check
		if(arr.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = arr.length - 1;
		
		
		// Initialize by -1 . for value not present
		int ansIdx = -1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == target) {
				ansIdx = mid;
				if(isFirst) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}else if(target > arr[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		
		return ansIdx;
	}
}
