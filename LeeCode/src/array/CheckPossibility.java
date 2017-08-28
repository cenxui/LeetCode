package array;

public class CheckPossibility {

    public static void main(String[] args) {
        int[] nums = {2,3,3,2,4}; //true
        System.out.println(checkPossibility(nums));
        int[] nums1 = {3,4,2,3}; //false
        System.out.println(checkPossibility(nums1));
        int[] nums2 = {3,3,2,2}; //false
        System.out.println(checkPossibility(nums2));
        int[] nums3 = {5,4,3,2,1}; //false
        System.out.println(checkPossibility(nums3));
        int[] nums4 = {1,2,4,5,3}; //true
        System.out.println(checkPossibility(nums4));
        int[] nums5 = {1,3,4,2,5}; //true
        System.out.println(checkPossibility(nums5));
    }

    public static boolean checkPossibility(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        if (nums.length <=2) return true;

        boolean result = true;

        boolean check = false; //check if exist one non-increase.

        int len = nums.length;

        for (int i = 1 ; i < len ; i++) {
            if (nums[i-1] > nums[i]) {
                if (check == false) {
                    check = true;

                    if (i == len-1) {
                        break;
                    }else if (i >1 && nums[i-1] != nums[i-2] && nums[i-2] >= nums[i] && nums[i-2] <= nums[i+1] ) {
                        result = false;
                        break;
                    }else if (i>1 && len > 3 && len > (i + 1) && nums[i-1] == nums[i-2] && nums[i] == nums[i+1]) {
                        result = false;
                        break;
                    }

                }else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
