package words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCompare {
	public static void main(String[] args) {
		System.out.println(compareVersion("1.01", "01.1.0.1"));
		// char[] chars = {'1'};
		// System.out.println(charsToInteger(chars));

	}
	
	/**
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */

	public static int compareVersion(String version1, String version2) {
		String[] strVersion1 = version1.split("\\.");
		String[] strVersion2 = version2.split("\\.");
		int index;
		int compare;
		for (index = 0; index < strVersion1.length && index < strVersion2.length; index++) {
			compare = compareInterger(strVersion1[index].toCharArray(), strVersion2[index].toCharArray());
			if (compare != 0) {
				return compare;
			}
		}
		if (strVersion1.length > strVersion2.length) {
			for (; index < strVersion1.length; index++) {
				if (charsToInteger(strVersion1[index].toCharArray())!= 0) {
					return 1;
				}
			}
		} else {
			for (; index < strVersion2.length; index++) {
				if (charsToInteger(strVersion2[index].toCharArray())!= 0) {
					return -1;
				}
			}
		}

		return 0;
	}

	@SuppressWarnings("unused")
	private static int compareDecimal(char[] char1, char[] char2) {
		for (int i = 0; i < char1.length && i < char2.length; i++) {
			if (char1[i] > char2[i]) {
				return 1;
			} else if (char1[i] < char2[i]) {
				return -1;
			}
		}
		return 0;
	}

	private static int compareInterger(char[] char1, char[] char2) {
		int charInteger1 = charsToInteger(char1);
		int charInteger2 = charsToInteger(char2);
		if (charInteger1 > charInteger2) {
			return 1;
		} else if (charInteger1 < charInteger2) {
			return -1;
		} else {
			return 0;
		}
	}

	private static int charsToInteger(char[] chars) {
		int sum = 0;
		for (int i = 0; i < chars.length; i++) {
			sum = sum * 10 + (int) chars[i] - 48;
		}
		return sum;
	}

	/**
	 * reverse vowels is string
	 * 
	 * @param s
	 *            the string we want to reverse vowels
	 * @return the string vowels reversed
	 */

	public static String reverseVowels(String s) {
		char[] vowls = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
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
		for (int i = 0; i < list.size() / 2; i++) {
			temp = charS[list.get(i)];
			charS[list.get(i)] = charS[list.get(list.size() - i - 1)];
			charS[list.get(list.size() - i - 1)] = temp;
		}

		return new String(charS);
	}

	/**
	 * form integer to excel table value
	 * 
	 * @param n
	 *            the integer value
	 * @return return the excel table string value
	 */

	public static String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}
		Stack<Integer> stack = new Stack<>();
		while (n > 0) {
			n = n - 1;
			stack.push(Integer.valueOf(n % 26 + 1));
			n = n / 26;
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (stack.isEmpty() == false) {
			char s = (char) (stack.pop() + 64);
			stringBuilder.append(s);
		}
		return stringBuilder.toString();
	}

	/**
	 * excel table
	 * 
	 * @param s
	 *            the title string
	 * @return to the table integer
	 */

	public static int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] charS = s.toCharArray();
		int result = 0;
		for (int i = 0; i < charS.length; i++) {
			result = result * 26;
			result = result + (int) charS[i] - 64;
		}
		return result;
	}

	/**
	 * check to string whether they are anagram
	 * 
	 * @param s
	 *            compared word
	 * @param t
	 *            compare word
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
