package number;

import java.util.Stack;

public class Bit {
	public static void main(String[] arg) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(a.length());
	}
	
	public static int numberOfBit(long l) {
		int sum = 0;
		for (int i = 0 ; i<32;i++ ){
			if ((l&1) == 1) {			
				sum = sum + 1;				
			} 
			l = l>>1;
		}
		return sum;
	}
	
	public static String addBinary(String a, String b) {
        long result = stringToByte(a) + stringToByte(b);
        return byteToString(result);
    }
	
	public static long stringToByte(String a) {
		char[] charA = a.toCharArray();
		long result = 0;
		for (int i = 0; i<charA.length;i++) {
			result <<=1;
			result = result + (long)charA[i]-48;
		}
		return result;
	}
	
	public static String byteToString(long a) {
		if (a == 0) {
			return "0";
		}
		
		Stack<Long> stack = new Stack<>();
		while (a > 0) {
			stack.push(a&1);
			a >>= 1;
		}
		StringBuilder result = new StringBuilder();
		while (stack.isEmpty() == false) {
			result.append(stack.pop());
		}
		return result.toString();
	}
}
