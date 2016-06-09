package words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCompare {
	public static void main(String[] args) {
		System.out.println(reverseVowels("A man a plan a canal: Panama"));
	}
	
	public static String reverseVowels(String s) {
		char[] vowls = {'a','e','i','o','u','A','E','I','O','U'};
		char[] charS = s.toCharArray();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < charS.length; i++) {
			for (int j = 0; j < vowls.length; j++) {
				if (charS[i] == vowls[j]) {
					list.add(i);
					break;
				}
			}
		}
		char temp;
		for (int i = 0; i < list.size()/2; i++) {
			temp = charS[list.get(i)];
			charS[list.get(i)] = charS[list.get(list.size()-i-1)];
			charS[list.get(list.size()-i-1)] = temp;
		}
		
        return new String(charS);
    }
	
	/**
	 * form integer to excel table value 
	 * @param n the integer value
	 * @return return the excel table string value
	 */
	
	public static String convertToTitle(int n) {
		if (n<=0) {
			return "";
		}
        Stack<Integer> stack = new Stack<>();
        while (n>0) {   
        	n = n-1;
			stack.push(Integer.valueOf(n%26+1));
			n = n/26;
		}
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.isEmpty() == false) {
			char s = (char)(stack.pop()+64);
			stringBuilder.append(s);
		}
        return stringBuilder.toString();
    }
	
	/**
	 * excel table
	 * @param s the title string
	 * @return to the table integer
	 */
	
	public static int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
        char[] charS = s.toCharArray();
        int result = 0;
        for (int i = 0; i <charS.length; i++) {
        	result = result*26;
        	result = result + (int)charS[i]-64;
        }
        return result;
    }
	
	/**
	 * check to string whether they are anagram
	 * @param s compared word
	 * @param t compare word
	 * @return true if anagram
	 */
	
	public static boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		if (s.equals(t)) {
			return false;
		}
		
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		
		Arrays.sort(charS);
		Arrays.sort(charT);

        return Arrays.equals(charS, charT);
    }
}
