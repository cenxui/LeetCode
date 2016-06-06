package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
//		int[] nums = {-13,11,11,0,-5,-14,12,-11,-11,-14,-3,0,-3,12,-1,-9,-5,-13,9,-7,-2,9,-1,4,-6,-13,-7,10,10,9,7,13,5,4,-2,7,5,-13,11,10,-12,-14,-5,-8,13,2,-2,-14,4,-8,-6,-13,9,8,6,10,2,6,5,-10,0,-11,-12,12,8,-7,-4,-9,-13,-7,8,12,-14,10,-10,14,-3,3,-15,-14,3,-14,10,-11,1,1,14,-11,14,4,-6,-1,0,-11,-12,-14,-11,0,14,-9,0,7,-12,1,-6};
//		List<List<Integer>> list = threeSum(nums);
		System.out.println(getRow(2));
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i<= rowIndex; i++) {
			result.add(getCombination(rowIndex, i));
		}
        return result;
    }
	
	/**
	 * useful combination method
	 * @param n the number of elements
	 * @param k the number you want to pick
	 * @return the number of method
	 */
	
	public static int getCombination(int n,int k) {
		long result = 1;
		
		if (k == 0|| k == n) {
			return (int)result;
		}
		
		if (k>n/2) {
			k = n-k;
		}
		
		for (int i = 1; i<=k ;i++) {
			result = result*n/i;
			n = n-1;
		}
		return (int)result;
	}
	
	/**
	 * gerneate Pascal's Triangle
	 * @param numRows the level of Pascal's Triangle
	 * @return the Pascal's Triangle 
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> rowList;
			
		if (numRows <=0) {
			return resultList;
		}
		rowList = new ArrayList<>();	
		rowList.add(1);
		resultList.add(rowList);
		if (numRows == 1) {
			return resultList;
		}

        for (int i = 1; i < numRows; i++) {
        	rowList = new ArrayList<>();
			for (int j = 0; j<= i; j++) {
				if (j == 0 || j == i) {
					rowList.add(1);
				}else {
					rowList.add(resultList.get(i-1).get(j-1) + 
							resultList.get(i-1).get(j));
				}					
			}
			resultList.add(rowList);
		}
        return resultList;
    }
	
	/**
	 * list all the nums array subset
	 * @param nums the universe set 
	 * @return all the subsets
	 */
	
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		subset(list, 0, nums, new ArrayList<>());
		
        return list;
    }
	
	/**
	 * 
	 * @param list
	 * @param index
	 * @param nums
	 * @param sublist
	 */
	
	public static void subset(List<List<Integer>>  list, int index, int[] nums, List<Integer> sublist) {
		if (index == nums.length) {
			list.add(sublist);
		}else {
			subset(list, index+1, nums,sublist);
			List<Integer> newList = new ArrayList<>(sublist);
			newList.add(nums[index]);
			subset(list, index+1, nums, newList);
		}
	}
	
	/**
	 * thess method is still unworkable do not use it
	 * @param nums
	 * @return
	 */
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> list = subsets(3, nums);
		List<List<Integer>> resultList = new ArrayList<>();
		for (int i = 0; i<list.size(); i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum = sum +list.get(i).get(j);
			}
			if (sum == 0) {
				resultList.add(list.get(i));
			}			
		}
		
		return resultList;
    }
	
	/**
	 * 
	 * @param sebsetLength the subsetLength
	 * @param nums the main array
	 * @return the subsets are length {@value sebsetLength}
	 */
	
	public static List<List<Integer>> subsets(int sebsetLength,int[] nums) {
		if (nums.length < nums.length) {
			return null;
		}
		
		if (nums.length == 0) {
			return new ArrayList<>();
		}
		
		Arrays.sort(nums);		
		
		List<List<Integer>> list = new ArrayList<>();
		subset(list, 0, 3, nums, null);
		return list;
	}
	
	/**
	 * 
	 * @param list the list to store sublist
	 * @param index current position in nums
	 * @param limit the desire subset size must smaller than nums.length
	 * @param nums the main set must larger than nums.length
	 * @param sublist the subset of nums you can create new ArrayList or NULL
	 */
	
	private static void subset(List<List<Integer>>  list
			, int index
			, int limit
			, int[] nums
			, List<Integer> sublist) {
		if (limit> nums.length) {
			return;
		}
		
		if (sublist == null) {
			sublist = new ArrayList<>();
		}
		
		if (index == nums.length ) {
			if (sublist.size() == limit) {
				list.add(sublist);	
			}					
		}else {
			if (sublist.size() == limit) {
				list.add(sublist);
			}else if(sublist.size() < limit ){
				//subset remain the same
				subset( list, index+1, limit, nums, sublist);
				//subset add next one
				List<Integer> newList = new ArrayList<>(sublist);
				newList.add(nums[index]);
				subset( list, index+1, limit, nums, newList);
			}			
		}
	}
}

