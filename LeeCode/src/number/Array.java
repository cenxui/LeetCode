package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Array {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3 ,4, 5, 6 };

		System.out.println(removeElement(array, 3));
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	/**
	 * given a none zero and has a majority element that means more the n/2 
	 * in nums array
	 * @param nums the element array
	 * @return the majority element in nums array
	 */
	
	public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
        
    }
	
	/**
	 * remove all elements that equal val 
	 * @param nums elements array
	 * @param val the value we want to remove
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
		for (int i = 0 ,j = 0; j < length && i<nums.length; i++) {
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

	public static boolean containsDuplicate(int[] nums) {
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
