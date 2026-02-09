package BinarySearch;

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
		
		boolean trend = arr[start] < arr[end];
		
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
		
		return false;
	}

}
