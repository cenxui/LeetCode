package words;

import java.util.Arrays;

public class StringCompare {

	public static void main(String[] args) {
		String a = "A";
		System.out.println((int)a.toCharArray()[0]);

	}
	
	public static int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
        char[] charS = s.toCharArray();
        int result = 0;
        for (int i = 0; i <charS.length; i++) {
        	result = result*26;
        	result = result + (int)charS[i]-40;
        }
        return result;
    }
	
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
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		
		Arrays.sort(charS);
		Arrays.sort(charT);
		for (int i = 0; i<charS.length; i++) {
			if (charS[i] != charT[i]) {
				return false;
			}
		}
        return true;
    }
}
