package number;

import java.util.*;

public class SingleNumberIII {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        if (nums == null) return  null;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            }else {
                set.add(i);
            }
        }

        int[] result = new int[set.size()];

        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }


        return result;
    }
}
