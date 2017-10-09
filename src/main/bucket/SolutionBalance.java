package bucket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SolutionBalance {
    public static boolean isBalanced(String expression) {
        char[] expressChar = expression.toCharArray();

        Stack<Character> stack = new Stack<>();

        int len = expressChar.length;
        for (int i = 0;i < len; i++) {
            switch (expressChar[i]){
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                case '}':
                    if (stack.empty()) return false;
                    if (stack.pop().equals('}') == false) return false;
                    break;
                case ']':
                    if (stack.empty()) return false;
                    if (stack.pop().equals(']') == false) return false;
                    break;
                case ')':
                    if (stack.empty()) return false;
                    if (stack.pop().equals(')') == false) return false;
                    break;
            }


        }

        return stack.empty();

    }

    public static void main(String[] args) {
        String expression1 = "{{[[(())]]}}";
        System.out.println(isBalanced(expression1));
        String expression2 = "{{[[(";
        System.out.println(isBalanced(expression2));
        String expression3 = "3";
        System.out.println(isBalanced(expression3));


    }

}
