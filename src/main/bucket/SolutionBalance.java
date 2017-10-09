package bucket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SolutionBalance {
    public static boolean isBalanced(String expression) {
        char[] expressChar = expression.toCharArray();

        Stack<Character> stack = new Stack<>();

        int i = 0;
        int len = expressChar.length;
        for (;i < len; i++) {

            if (expressChar[i] == '{') {
                stack.push('}');
            }else if (expressChar[i] == '[') {
                stack.push(']');
            }else if (expressChar[i] == '(') {
                stack.push(')');
            }else {
                break;
            }
        }

        Set<Character> set = new HashSet<>();
        set.add('}');
        set.add(']');
        set.add(')');

        while (i < len && set.contains(expressChar[i]) == false) {
            i++;
        }

        for (;i < len; i++ ) {
            if (stack.empty()) return false;
            if (stack.pop().equals(Character.valueOf(expressChar[i])) == false) {
                return false;
            }

        }

        if (stack.empty() == false) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String expression = "{{[[(())]]}}";
        String expression = "{[(])}";
//        String expression = "3";
        System.out.println(isBalanced(expression));

    }

}
