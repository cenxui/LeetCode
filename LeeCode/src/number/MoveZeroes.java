package number;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] array = { 0, 1, 0, 3, 12 };
		moveZeroes(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * remove zeroes in array
	 * 
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
		int[] result = new int[nums.length];
		int noneZero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				result[noneZero] = nums[i];
				noneZero++;
			}
		}
		System.arraycopy(result, 0, nums, 0, nums.length);
	}
}
