package number;

import java.util.Stack;

public class Bit {
	public static void main(String[] arg) {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + "nuber of bit" + numberOfBit(i) + "\n");
		}
	}

	/**
	 * 338. Counting Bits 
	 * Given a non negative integer number num. For every
	 * numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their
	 * binary representation and return them as an array.
	 * 
	 * For num = 5 you should return [0,1,1,2,1,2].
	 * 
	 * @param num
	 *            a non negative integer number num
	 * @return an array of number of 1's in 0 to num's binary representation
	 */
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = numberOfBit(i);
		}

		return result;
	}

	public static int numberOfBit(long l) {
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			if ((l & 1) == 1) {
				sum = sum + 1;
			}
			l = l >> 1;
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
		for (int i = 0; i < charA.length; i++) {
			result <<= 1;
			result = result + (long) charA[i] - 48;
		}
		return result;
	}

	public static String byteToString(long a) {
		if (a == 0) {
			return "0";
		}

		Stack<Long> stack = new Stack<>();
		while (a > 0) {
			stack.push(a & 1);
			a >>= 1;
		}
		StringBuilder result = new StringBuilder();
		while (stack.isEmpty() == false) {
			result.append(stack.pop());
		}
		return result.toString();
	}

	/**
	 * 461. Hamming Distance 
	 * The Hamming distance between two integers is the
	 * number of positions at which the corresponding bits are different.
	 * 
	 * Note: 0 ≤ x, y < 2^31
	 * 
	 * @param x
	 *            integer used to calculate the Hamming distance
	 * @param y
	 *            integer used to calculate the Hamming distance
	 * @return total numbers of positions where the corresponding bits are
	 *         different
	 */
	public int hammingDistance(int x, int y) {
		int distance = 0;
		for (int i = 0; i < 32; i++) {
			if ((x & 1) != (y & 1)) {
				distance++;
			}
			x >>= 1;
			y >>= 1;
		}

		return distance;
	}
}
