package power;

public class Power {

	public static void main(String[] args) {
		System.out.println(myPow(34.00515, -3));

	}

	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		if (x == 1) {
			return 1;
		}

		if (n == Integer.MIN_VALUE && x > 0) {
			return 0;
		}

		if (n < 0) {
			x = 1 / x;
			n = -1 * n;
		}

		int time = (int) Math.sqrt(n);
		int remain = n - time * time;
		double result = 1;
		double temp = 1;

		for (int i = 0; i < time; i++) {
			temp = x * temp;
		}

		for (int i = 0; i < time; i++) {
			result = temp * result;
		}

		for (int i = 0; i < remain; i++) {
			result = x * result;
		}

		return result;
	}

	/**
	 * check if the number is power of two
	 * 
	 * @param num
	 *            the number we want to check
	 * @return true if the number is power of two
	 */

	public static boolean isPowerTwo(int num) {
		return num <= 0 ? false : (num & (num - 1)) == 0;
	}

	public static boolean isPowerFour(int num) {
		if (isPowerTwo(num)) {
			while (num > 0) {
				if (num == 1)
					return true;
				num >>= 2;
			}
		}

		return false;
	}

	public static boolean isPowerOfThree(int n) {
		if (n == 1)
			return true;
		if (n == 3)
			return true;
		if (n == 9)
			return true;
		if (n == 27)
			return true;
		if (n == 81)
			return true;
		if (n == 243)
			return true;
		if (n == 729)
			return true;
		if (n == 2187)
			return true;
		if (n == 6561)
			return true;
		if (n == 19683)
			return true;
		if (n == 59049)
			return true;
		if (n == 177147)
			return true;
		if (n == 531441)
			return true;
		if (n == 1594323)
			return true;
		if (n == 4782969)
			return true;
		if (n == 14348907)
			return true;
		if (n == 43046721)
			return true;
		if (n == 129140163)
			return true;
		if (n == 387420489)
			return true;
		if (n == 1162261467)
			return true;

		return false;
	}
}
