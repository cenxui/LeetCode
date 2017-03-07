package number;

public class Reverse {

	public static void main(String[] args) {
		// System.out.println(reverseBit(43261596));
		System.out.println("result" + isPalindrome(12221));
	}

	/**
	 * 190. Reverse Bits 
	 * Reverse bits of a given 32 bits unsigned integer. For
	 * example, given input 43261596 (represented in binary as
	 * 00000010100101000001111010011100), return 964176192 (represented in
	 * binary as 00111001011110000010100101000000).
	 * 
	 * note that you need treat n as an unsigned value
	 * 
	 * @param n
	 *            a number to be reversed
	 * @return reversed number
	 */
	public static int reverseBit(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			if ((n & 1) == 1) {
				result += 1;
			}
			n >>= 1;
		}
		return result;
	}

	public static int reverse(int x) {
		if (x > 0) {
			return reverseABS(x);
		} else if (x == 0) {
			return 0;
		} else {
			if (x == Integer.MIN_VALUE) {
				return 0;
			}
			return -reverseABS(-x);
		}
	}

	private static int reverseABS(int n) {
		long result = 0;
		while (n >= 10) {
			result += n % 10;
			n = n / 10;
			result *= 10;
			System.out.println(result);
		}

		result = result + n;

		if (result > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) result;
	}

	public static boolean isPalindrome(int x) {
		if (x > 0) {
			if (x == reverseABS(x)) {
				return true;
			} else {
				return false;
			}
		} else if (x == 0) {
			return true;
		} else {
			if (x == -Integer.MIN_VALUE) {
				return false;
			}
			return false;
		}
	}
}
