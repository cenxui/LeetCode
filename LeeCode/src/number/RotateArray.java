package number;

public class RotateArray {
	

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		
		rotate(array, 2);
		for (int i = 0; i< array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	public static void rotate(int[] nums, int k) {
		int length = nums.length;
		int[] result = new int[length];
		
		for (int i = 0; i<length; i++) {
			result[(i+k)%length] = nums[i];
		}
		
		System.arraycopy(result, 0,nums , 0, length);
    }
	
}
