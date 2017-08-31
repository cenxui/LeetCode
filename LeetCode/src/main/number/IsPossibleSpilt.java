package number;

import java.util.*;

public class IsPossibleSpilt {

    public static void main(String[] args) {
        int[] ints = {1,2,3,3,4,4,5,5};

//        int[] ints = {1,2,3,3,4,5};

//        int[] ints = {1,2,3,4,4,5};

        System.out.println(isPossible(ints));
    }

    public static boolean isPossible(int[] nums) {

        if ( nums == null) return false;

        int len = nums.length;

        if (len < 6) return false;

        int temp = nums[0];

        int index = 0;

        //find dupicated

        for (int i = 1; i < len ; i++ ) {

            if (temp++ == nums[i]) {
                index = i;
                break;
            }
        }

        if (index == 0) return true;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = index-1 ; i < len; i++ ) {
            int val = nums[i];
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            }else {
                map.put(val,1);
            }

        }

        //check first element

        Integer[] arrays = map.keySet().toArray(new Integer[map.keySet().size()]);

        Arrays.sort(arrays);

        int arraysLen = arrays.length;

        boolean onlyOne = false;

        if (map.keySet().size()<3) return false;

        for (int i = arrays[0]; i < arraysLen; i++ ) {
            if (i < 3 && map.get(arrays[i]) != 2 ) {
                return false;
            }else if (onlyOne == false && map.get(arrays[i]) == 1) {
                onlyOne = true;
            }else if (onlyOne == true && map.get(arrays[i])!= 1) {
                 return false;
            }

        }

        return true;

    }

}
