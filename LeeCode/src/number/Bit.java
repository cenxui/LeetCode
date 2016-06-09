package number;

import java.util.Stack;

public class Bit {
	public static void main(String[] arg) {
		for (int i = 0; i <1000; i++) {
			System.out.println(i+"nuber of bit" + numberOfBit(i) + "\n");
		}
	}
	
	public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i < result.length; i++) {
			result[i] = numberOfBit(i);
		}
        
        return result;
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
