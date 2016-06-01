package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		subset(list, 0, nums, new ArrayList<>());
		
        return list;
    }
	
	public static void subset(List<List<Integer>>  list, int index, int[] nums, List<Integer> sublist) {
		if (index == nums.length) {
			list.add(sublist);
		}else {
			subset(list, index+1, nums,sublist);
			List<Integer> aList = new ArrayList<>(sublist);
			aList.add(nums[index]);
			subset(list, index+1, nums, aList);
		}
	}
}
