package number;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
	

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
	
	
	public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int check = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != check) {
				check = nums[i];
			}else {
				return true;
			}
		}
        return false;
    }
	
	public static void rotatePrimeLength(int[] nums ,int k) {
		int length = nums.length;
		int tempX = nums[0];
		int tempY = 0;
		int positionX = 0;
		int positionY = 0;
        for (int i = 0; i < length ; i++ ) {
        	positionY = (positionX+k)%length;
        	tempY = nums[positionY];
        	nums[positionY] = tempX;
        	positionX = positionY;
        	tempX = tempY;
        }
	}
}
