package power;

public class Power {

	public static void main(String[] args) {
		System.out.println(myPow(3, 5));
		
	}
	/**
	 * wrong method
	 * @param x
	 * @param n
	 * @return
	 */
	@Deprecated
	public static double myPow(double x, int n) {
		double result = 1;
		for (int i = n; i>0; i>>= 1) {
			
		}
		
		return result;
	}
	
	public static boolean isPowerTwo(int num) {
		return num <= 0 ? false:(num & (num-1)) == 0;
	}
	
	public static boolean isPowerFour(int num) {
		if (isPowerTwo(num)) {
			while (num>0) {			
				if (num == 1)
					return true;
				num >>= 2; 
			}
		}
		
		return false; 
	}
	
	
	
	public static boolean isPowerOfThree(int n) {
		if ( n == 1 ) return true;
		if ( n == 3 ) return true;
		if ( n == 9 ) return true;	
		if ( n == 27 ) return true;
		if ( n == 81 ) return true;
		if ( n == 243 ) return true;
		if ( n == 729 ) return true;
		if ( n == 2187) return true;
		if ( n == 6561 ) return true;
		if ( n == 19683 ) return true;
		if ( n == 59049 ) return true;	
		if ( n == 177147 ) return true;
		if ( n == 531441 ) return true;
		if ( n == 1594323 ) return true;
		if ( n == 4782969 ) return true;
		if ( n == 14348907) return true;
		if ( n == 43046721 ) return true;
		if ( n == 129140163 ) return true;
		if ( n == 387420489 ) return true;
		if ( n == 1162261467) return true;

		return false;
	}
}
