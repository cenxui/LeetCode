package list;

import java.util.*;

public class MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> triangle  = new ArrayList<>();

        List<Integer> step1 = new ArrayList<>();
        step1.add(2);
        triangle.add(step1);

        List<Integer> step2 = new ArrayList<>();
        step2.add(1);
        step2.add(3);
        triangle.add(step2);

        List<Integer> step3 = new ArrayList<>();
        step3.add(1);
        step3.add(3);
        step3.add(4);
        triangle.add(step3);
        MinimumTotal minimumTotal = new MinimumTotal();

        System.out.println(minimumTotal.minimumTotal(triangle));

    }



    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        if (triangle.size() == 1) return triangle.get(0).get(0);

        List<Integer> results = triangle.get(0);

        for (int i = 1; i < triangle.size(); i++) {
            results = minimumSum(results, triangle.get(i));

        }


        return Collections.min(results).intValue();

    }

    private List<Integer> minimumSum(List<Integer> sum, List<Integer> list) {
        if (sum == null || list == null) throw new NullPointerException("sum and list can not be null" );

        if ((sum.size() + 1) != list.size()) throw new IllegalArgumentException("list size must equals sum size + 1 ");

        List<Integer> result = new ArrayList<>(list.size());

        //add first
        result.add(0,list.get(0) + sum.get(0));

        for (int i = 1; i < sum.size(); i++) {
            Integer value = sum.get(i-1) < sum.get(i) ? sum.get(i-1): sum.get(i);
            result.add(i, value + list.get(i));
        }

        //add last.

        result.add(sum.size(), sum.get(sum.size()-1) + list.get(list.size()-1));


        return result;
    }

}
