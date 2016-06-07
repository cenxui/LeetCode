package words;

import java.util.Arrays;

public class Word {
	// private static String words = "the sky is blue";
	private static String words = " 1";

	public static void main(String[] arg) {
		System.out.println(wordPattern("blood", "b l o o d"));
	}

	public static boolean wordPattern(String pattern, String str) {
		if (pattern == null && str == null) {
			return true;			
		}
		
		if (pattern == null||pattern.length() == 0) {
			return false;
		}
		
		String[] strings = str.split(" ");	
		
		if (pattern.length() == 1&& strings.length == 1 ) {
			return true;
		}
		
		if (pattern.length() != strings.length) {
			return false;
		}
		
		int[] isomorphicWord = isomorphicWords(strings);
		int[] isomorphicString = isomorphicString(pattern);
		return Arrays.equals(isomorphicString, isomorphicWord);
	}

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
