package number;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(0));
		System.out.println(isUgly(1));
		System.out.println(isUgly(25535));
	}

	public static boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}

		if (num == 1)
			return true;

		while (num > 0 && ((num & 1) != 1)) {
			num >>= 1;
		}

		if (num == 1) {
			return true;
		}

		while (num != 1 && num % 3 == 0) {
			num = num / 3;
		}

		if (num == 1) {
			return true;
		}

		while (num != 1 && num % 5 == 0) {
			num = num / 5;
		}

		if (num == 1) {
			return true;
		}

		return false;
	}
}
