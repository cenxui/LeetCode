package adddigit;

/**
 * 
 * @author xenxui
 * @since 2016/5/30
 */
public class AddDigit {

	/**
	 * 258. Add Digits
	 * Given a non-negative integer num, repeatedly add 
	 * all its digits until the result has only one digit.
	 * 
	 * @param num
	 * 			a non-negative integer
	 * @return one digit
	 */
	public int addDigits(int num) {
		return num == 0 ? 0 : (num - 1) % 9 + 1;
	}
}
