package number;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		}
		int unaddible = nums[0] + nums[2];
		int add = nums[2];
		int addible = nums[1];
		if (nums.length == 3) {
			return unaddible > addible ? unaddible : addible;
		}

		for (int i = 3; i < nums.length; i++) {
			if (unaddible - add > addible) {
				addible = unaddible - add;
			}

			if (addible + nums[i] > unaddible) {
				int temp = unaddible;
				unaddible = addible + nums[i];
				add = nums[i];
				addible = temp;
			} else {
				int temp = addible;
				addible = unaddible;
				unaddible = temp + nums[i];
				add = nums[i];
			}

		}
		return unaddible > addible ? unaddible : addible;
	}
}
