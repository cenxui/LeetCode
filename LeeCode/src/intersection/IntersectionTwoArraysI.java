package intersection;

public class IntersectionTwoArraysI {
	public static void main(String[] args) {
		int[] x = {1,2,2,1,1};
		int[] y = {1,1,1};
		int[] result = intersect(x, y);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) return new int[0];
		
		int[] intersection1;
		int[] intersection2;
		
		if (nums1.length > nums2.length) {
			intersection1 = nums1;
			intersection2 = nums2;
		}else {
			intersection2 = nums1;
			intersection1 = nums2;
		}
		
		int[] temp = new int[intersection2.length];
		int length = 0;
		for (int i = 0; i<intersection2.length; i++) {
			for (int j = 0; j < intersection1.length; j++) {
				if (intersection2[i] == intersection1[j]) {
					temp[length] = intersection2[i];
					intersection1[j] = -1;
					length = length + 1;
					break;
				}
			}
		}
		int[] result = new int[length]; 
		for (int i = 0; i<length;i ++) {
			result[i] = temp[i];
		}
		result = refine(result);	
		return result;
	}
	
	private static int[] refine(int[] nums) {
		int refineLength = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) refineLength = refineLength + 1;
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] != -1 && nums[i] == nums[j]) {
					nums[j] = -1;						
				}
			}
		}

		int[] temp = nums;
		nums = new int[refineLength];
		
		int position = 0;
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != -1) {
				nums[position] = temp[i];
				position = position + 1;
			}
		}
		
		return nums;
	}
}
