package number;

import java.util.ArrayList;

public class Number {

	public static void main(String[] args) {
		System.out.println(getSum(100, 1000));

	}

	/**
	 * 371. Sum of Two Integers
	 *  get sum with binary operation without "+" and "-" operation
	 * 
	 * @param a
	 *            the integer number we want to add
	 * @param b
	 *            the integer number we want to add
	 * @return the sum of a and b
	 */

	public static int getSum(int a, int b) {
		int result = 0;
		int tempResult = 0;
		boolean addMore = false;
		for (int i = 0; i < 32; i++) {
			int tempA = 1 & a;
			int tempB = 1 & b;
			if (addMore) {
				if (tempA == 1 && tempB == 1) {
					addMore = true;
					tempResult = 1;
					tempResult <<= i;
				} else if (tempA == 0 && tempB == 0) {
					addMore = false;
					tempResult = 1;
					tempResult <<= i;
				} else {
					addMore = true;
					tempResult = 0;
				}
			} else {
				if (tempA == 1 && tempB == 1) {
					addMore = true;
					tempResult = 0;
				} else if (tempA == 0 && tempB == 0) {
					addMore = false;
					tempResult = 0;
				} else {
					addMore = false;
					tempResult = 1;
					tempResult <<= i;
				}
			}
			a >>= 1;
			b >>= 1;
			result = result | tempResult;
		}
		return result;
	}

	/**
	 * Given a positive integer n, break it into the sum of at least two
	 * positive integers and maximize the product of those integers. Return the
	 * maximum product you can get
	 * 
	 * @param n
	 *            a positive integer n we want to break it into the sum of at
	 *            least two positive integer
	 * @return Return the maximum product you can get
	 */
	public static int integerBreak(int n) {
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 1;
		}

		if (n == 3) {
			return 2;
		}

		if (n == 4) {
			return 4;
		}

		double temp = Math.sqrt(n);
		int index = 0;
		int logarithm = 0;
		int remain = (int) (n - temp * temp);
		if (remain < 3) {
			index = (int) temp;
			logarithm = (int) temp;
		} else {

		}

		int indexPlusOne = index + 1;
		int result = 1;

		for (int i = 0; i < remain; i++) {
			result = result * indexPlusOne;
		}

		for (int i = 0; i < logarithm - remain; i++) {
			result = result * index;
		}

		return result;
	}

	/**
	 * This method is to get how many zeroes we get in n!
	 * 
	 * @param n
	 *            the number to get n!
	 * @return the zeroes in n!
	 */
	public static int trailingZeroes(int n) {
		int result = 0;
		while (n > 0) {
			n = n / 5;
			result = result + n;
		}
		return result;
	}

	/**
	 * 202. Happy Number
	 * A happy number is a number defined by the following process: 
	 * Starting with any positive integer, replace the number by 
	 * the sum of the squares of its digits, and repeat the process 
	 * until the number equals 1 (where it will stay), or it loops endlessly 
	 * in a cycle which does not include 1.
	 * 
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * check the number is happy or not the process is endless or end in 1 if
	 * number lower than 10 it can be check if it is happy or not
	 * 
	 * @param n
	 *            the number we ant to check
	 * @return true if the number is happy
	 */
	public boolean isHappy(int n) {
        if(n == 1 || n== 7) {
            return true;
        }
        
        int sum = getSquare(n);
        
        return (sum == 1 || sum == 7)? true : false;
    }
    
    private int getSquare(int n) {
        int sum = 0;
        int temp = 0;
        
        while(n>9) {
            temp = n%10;
            sum += temp*temp;
            n = n/10;
            if(n<=9) {
                sum += n*n;
                if(sum<10) {
                    return sum;
                }
                
                n = sum;
                sum = 0;
            }
        }
        
        return sum;
    }

	public static int romanToInt(String s) {
		int res = 0;
		String[] c = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] n = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		int len = s.length();
		int i = 12, j = 0;
		while (i >= 0 && j <= len) {
			int len_temp = c[i].length();
			String temp = "";
			if (j + len_temp <= len) {
				temp = s.substring(j, j + len_temp);
			}
			if (c[i].equals(temp)) {
				res += n[i];
				j += len_temp;
			} else {
				i--;
			}
		}
		return res;
	}
}
