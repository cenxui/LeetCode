package twosum;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] twoNumber = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					twoNumber[0] = i;
					twoNumber[1] = j;
					return twoNumber;
				}
			}
		}
		return twoNumber;
	}
}
