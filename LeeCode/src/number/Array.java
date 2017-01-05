package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Array {

	public static void main(String[] args) {
		int[] array = { 1, 2 };
		topKFrequent(array, 2);
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		class Key {
			int val;
			int nums = 1;
		}
		Arrays.sort(nums);
		List<Key> list = new ArrayList<>();
		Key key = new Key();
		key.val = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != key.val) {
				key = new Key();
				key.val = nums[i];
				list.add(key);
			} else {
				key.nums++;
			}
		}

		return result;
	}

	/**
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * For example,Given [1,1,1,2,2,3] and k = 2, return [1,2].
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Arrays.sort(nums);
		class Value {
			int value;
			int number;
		}
		List<Value> resultList = new ArrayList<>();

		int check = nums[0];
		int index = 0;
		Value value = new Value();
		value.value = check;
		value.number = 0;
		resultList.add(value);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == check && i != (nums.length - 1)) {
				resultList.get(index).number++;
			} else {
				value = new Value();
				check = nums[i];
				value.value = check;
				value.number = 1;
				resultList.add(value);
				index++;
			}
		}

		Comparator<Value> comparator = (a, b) -> {
			if (a.number == b.number) {
				return 0;
			}
			return a.number > b.number ? 1 : -1;
		};

		Collections.sort(resultList, comparator);
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= k; i++) {
			result.add(resultList.get(resultList.size() - i).value);
		}
		return result;
	}

	/**
	 * Given a collection of distinct numbers, return all possible permutations.
	 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
	 * 
	 * @param nums
	 * @return
	 */

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		LinkedList<Integer> list = new LinkedList<>();
		addPremute(nums, 0, list, result);

		return result;
	}

	private static void addPremute(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
		if (nums.length == index) {
			result.add(list);
			return;
		}
		List<Integer> temp;
		for (int i = 0; i <= index; i++) {
			temp = new LinkedList<>(list);
			temp.add(i, nums[index]);
			addPremute(nums, index + 1, temp, result);
		}
	}

	/**
	 * 136. Single Number Given an array of integers, every element appears
	 * twice except for one. Find that single one.
	 * 
	 * @param nums
	 *            an array of integers
	 * @return that single one
	 */

	public static int singleNumber(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return nums[0];
		}

		Arrays.sort(nums);

		for (int i = 0; i < length - 1; i = i + 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}

		return nums[length - 1];

	}

	/**
	 * 137. Single Number II Given an array of integers, every element appears
	 * three times except for one. Find that single one.
	 * 
	 * @param nums
	 *            an array of integers
	 * @return the single one
	 */

	public int singleNumberII(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}

		if (length < 3) {
			return nums[0];
		}

		Arrays.sort(nums);

		for (int i = 0; i < length - 1; i = i + 3) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}

		if (nums[length - 1] != nums[length - 2]) {
			return nums[length - 1];
		}

		return 0;
	}

	/**
	 * 260. Single Number III Given an array of numbers nums, in which exactly
	 * two elements appear only once and all the other elements appear exactly
	 * twice. Find the two elements that appear only once.
	 * 
	 * @param nums
	 *            an array of integers
	 * @return an array of two elements that appear only once
	 */
	public int[] singleNumberIII(int[] nums) {
		boolean exist1 = false;
		int[] result = new int[2];
		int length = nums.length;

		if (nums == null || length < 2) {
			return nums;
		}

		Arrays.sort(nums);

		for (int i = 0; i < length - 1;) {
			if (nums[i] == nums[i + 1]) {
				i += 2;
				if (i == length - 1) {
					result[1] = nums[i];
					break;
				}
				continue;
			}

			if (!exist1) {
				result[0] = nums[i];
				exist1 = true;
				if (i == length - 2) {
					result[1] = nums[i + 1];
					break;
				} else {
					i++;
				}
			} else {
				result[1] = nums[i];
				break;
			}
		}

		return result;
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
