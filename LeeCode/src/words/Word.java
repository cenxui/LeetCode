package words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Word {
	// private static String words = "the sky is blue";
	private static String words = " 1";

	public static void main(String[] arg) {
		
		System.out.println(isPalindrome("`l;`` 1o1 ??;l`"));
	}
	
	public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
			if (chars[i]>64 && chars[i] <91){
				result.add(chars[i]);
			}else if (chars[i]>96 && chars[i]<123) {
				result.add((char)((int)chars[i]-32));
			}else if (chars[i]>47 && chars[i]<58) {
				result.add(chars[i]);
			}		
		}
        
        for (int i = 0; i < result.size()/2; i++) {
			if (result.get(i) != result.get(result.size()-1-i)) {
				return false;
			}
		}
        
        return true;
    }
	
	/**
	 * check if this string is valid with ([{ type
	 * @param s the string we want to check
	 * @return true if the string is valid type
	 */

	public static boolean isValid(String s) {
		if (s.length()% 2 == 1) {
			return false;
		}
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			if (stack.isEmpty()) {
				if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
					return false;
				} else {
					if (chars[i] == '(') {
						stack.push(')');
					} else if (chars[i] == '[') {
						stack.push(']');
					} else if (chars[i] == '{') {
						stack.push('}');
					}
				}
			} else {
				if (chars[i] == ')' && chars[i] == stack.peek()) {
					stack.pop();
				} else if (chars[i] == ']' && chars[i] == stack.peek()) {
					stack.pop();
				} else if (chars[i] == '}' && chars[i] == stack.peek()) {
					stack.pop();
				} else if (chars[i] == '(') {
					stack.push(')');
				} else if (chars[i] == '[') {
					stack.push(']');
				} else if (chars[i] == '{') {
					stack.push('}');
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();

	}

	/**
	 * get the lest word length of a sentence
	 * 
	 * @param s
	 *            the sentence
	 * @return the last word of sentence
	 */

	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		if (s.equals(" ")) {
			return 0;
		}

		String[] result = s.split(" ");
		if (result.length == 0) {
			return 0;
		}

		System.out.println("array length" + result.length);

		return result[result.length - 1].length();
	}

	/**
	 * check strings if isomorphic or not
	 * 
	 * @param s
	 *            string compared
	 * @param t
	 *            string compare
	 * @return true if they have same isomorphic structure
	 */

	public static boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		if (s.length() == 0 && s.length() == t.length()) {
			return true;
		}

		if (s.length() == 1 && s.length() == t.length()) {
			return true;
		}

		int[] isomorphicS = isomorphicString(s);
		int[] isomorphicT = isomorphicString(t);
		return Arrays.equals(isomorphicS, isomorphicT);
	}

	public static boolean wordPattern(String pattern, String str) {
		if (pattern == null && str == null) {
			return true;
		}

		if (pattern == null || pattern.length() == 0) {
			return false;
		}

		String[] strings = str.split(" ");

		if (pattern.length() == 1 && strings.length == 1) {
			return true;
		}

		if (pattern.length() != strings.length) {
			return false;
		}

		int[] isomorphicWord = isomorphicWords(strings);
		int[] isomorphicString = isomorphicString(pattern);
		return Arrays.equals(isomorphicString, isomorphicWord);
	}

	/**
	 * get the isomorphic word type
	 * 
	 * @param word
	 *            the word we want to isomorphic
	 * @return the isomorphic structure
	 */
	public static int[] isomorphicWords(String[] word) {
		int length = word.length;
		int[] isomorphic = new int[length];
		if (word.length == 0) {
			return isomorphic;
		}

		isomorphic[0] = 1;

		if (length == 1) {
			return isomorphic;
		}
		int used = 1;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (word[i].equals(word[j])) {
					isomorphic[i] = isomorphic[j];
					break;
				}
			}

			if (isomorphic[i] == 0) {
				isomorphic[i] = 1 + used;
				used++;
			}
		}
		return isomorphic;
	}

	/**
	 * get the isomorphic string type
	 * 
	 * @param string
	 *            the string we want to isomorphic
	 * @return the isomorphic type
	 */

	public static int[] isomorphicString(String string) {
		char[] stringChar = string.toCharArray();
		int length = stringChar.length;
		int[] isomorphic = new int[length];

		if (length == 0) {
			return isomorphic;
		}

		isomorphic[0] = 1;

		if (length == 1) {
			return isomorphic;
		}
		int used = 1;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (stringChar[i] == stringChar[j]) {
					isomorphic[i] = isomorphic[j];
					break;
				}
			}

			if (isomorphic[i] == 0) {
				isomorphic[i] = 1 + used;
				used++;
			}
		}
		return isomorphic;
	}

	public static String reverseWords(String string) {
		if (words == null || words.length() == 0)
			return "";

		String[] strings = words.split(" ");
		System.out.println(strings.length);
		if (strings.length == 0) {
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder(strings[strings.length - 1]);
		if (strings.length > 2) {
			for (int i = strings.length - 2; i > 0; i--) {
				if (strings[i].equals("") == false)
					stringBuilder.append(" ").append(strings[i]);
				System.out.println(i);
			}

		}

		if (strings.length > 1) {
			if (strings[0].hashCode() != 0) {
				stringBuilder.append(" ").append(strings[0]);
			}
		}

		return stringBuilder.toString();
	}
}
