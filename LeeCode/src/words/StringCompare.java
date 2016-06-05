package words;

import java.util.Arrays;

public class StringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
