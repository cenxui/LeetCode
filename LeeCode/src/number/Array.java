package number;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		int[] array = { 1, 1, 2, 3, 3, 4, 5, 6 };

		System.out.println(removeDuplicates(array));
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	/**
	 * Given an array of integers, 
	 * every element appears twice except for one. Find that single one.
	 * @param nums an array of integers
	 * @return  that single one
	 */

	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 1) {
			return nums[0];
		}

		for (int i = 0; i < nums.length - 1; i = i + 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}

		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			return nums[nums.length - 1];
		}

		return 0;
	}
	
	/**
	 * Given an array of integers, 
	 * every element appears three times except for one. Find that single one. 
	 * @param nums an array of integers
	 * @return the single one
	 */

	public int singleNumberII(int[] nums) {
		if (nums.length == 0 ) {
			return 0;
		}
		
		if (nums.length <3) {
			return nums[0];
		}
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length-1; i= i+3) {
			if (nums[i] != nums[i+1]) {
				return nums[i];
			}
		}
		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			return nums[nums.length - 1];
		}
		
		return 0;
	}

	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int i = length - 1;
		while (i >= 0 || digits[i] == 9) {
			digits[i] = 0;
			i--;
		}

		if (i == -1) {
			int[] result = new int[length + 1];
			System.arraycopy(digits, 0, result, 1, length);
			result[0] = 1;
			return result;
		}
		digits[i] = digits[i] + 1;

		return digits;
	}

	/**
	 * remove duplicates elements in array
	 * 
	 * @param nums
	 *            the array we want to remove all duplicates
	 * @return the elements number retain in array
	 */

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int check = Integer.MAX_VALUE;
		int[] result = new int[nums.length];
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != check) {
				result[length] = nums[i];
				check = nums[i];
				length++;
			}
		}
		System.arraycopy(result, 0, nums, 0, length);
		return length;
	}

	/**
	 * given a none zero and has a majority element that means more the n/2 in
	 * nums array
	 * 
	 * @param nums
	 *            the element array
	 * @return the majority element in nums array
	 */

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];

	}

	/**
	 * remove all elements that equal val
	 * 
	 * @param nums
	 *            elements array
	 * @param val
	 *            the value we want to remove
	 * @return the elements number after we remove
	 */

	public static int removeElement(int[] nums, int val) {
		int length = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				length = length - 1;
			}
		}
		int[] result = new int[length];
		for (int i = 0, j = 0; j < length && i < nums.length; i++) {
			if (nums[i] != val) {
				result[j] = nums[i];
				j++;
			}
		}
		System.arraycopy(result, 0, nums, 0, length);
		return length;
	}

	public static void rotate(int[] nums, int k) {
		int length = nums.length;
		int[] result = new int[length];

		for (int i = 0; i < length; i++) {
			result[(i + k) % length] = nums[i];
		}

		System.arraycopy(result, 0, nums, 0, length);
	}

	/**
	 * check array whether include duplicate element
	 * 
	 * @param nums
	 *            the none zero length array we want to check
	 * @return true if it exists duplicate elements
	 */
	public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}
		Arrays.sort(nums);
		int check = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != check) {
				check = nums[i];
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * the method only can be used in prime length array
	 * 
	 * @param nums
	 *            the array we want to rotate
	 * @param k
	 *            the rotate step
	 */

	public static void rotatePrimeLength(int[] nums, int k) {
		int length = nums.length;
		int tempX = nums[0];
		int tempY = 0;
		int positionX = 0;
		int positionY = 0;
		for (int i = 0; i < length; i++) {
			positionY = (positionX + k) % length;
			tempY = nums[positionY];
			nums[positionY] = tempX;
			positionX = positionY;
			tempX = tempY;
		}
	}
}
