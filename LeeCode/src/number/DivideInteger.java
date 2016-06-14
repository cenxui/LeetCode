package number;

public class DivideInteger {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		System.out.println(divide(-2147483648,-2));
		System.out.println("time" + (System.currentTimeMillis() - s));
	}
	/**
	 * divide integer with no divide and multiple method 
 	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		if (dividend == 0) return 0;
		
		if (divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) {
			return 1;
		}
		
		if (divisor == 1) {
			return dividend;
		}
		
		if (divisor == -1) {
			if (dividend == Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			}
			return ~dividend +1;
		}

		if (divisor == 2) {
			if (dividend == Integer.MIN_VALUE) {
				dividend = dividend +1;
				return ~dividePositivePositive(~dividend+1, divisor);
			}
		}
		
		if (divisor == -2) {
			if (dividend == Integer.MIN_VALUE) {
				dividend = dividend +1;
				return ~dividePositivePositive(~dividend+1, ~divisor+1);
			}
		}	
		
		if (dividend > 0 && divisor > 0) 
			return dividePositivePositive(dividend, divisor);
		
		if (dividend < 0 && divisor > 0) {
			if (dividend == Integer.MIN_VALUE) {
				dividend = dividend +1;				
			}
			return ~dividePositivePositive(~dividend +1, divisor)+1;
		}
			
		if (dividend > 0 && divisor < 0)
			return ~dividePositivePositive(dividend, ~divisor+1)+1;
		
		if (dividend < 0 && divisor <0) {
			if (dividend == Integer.MIN_VALUE) {
				dividend = dividend +1;				
			}
			return dividePositivePositive(~dividend+1, ~divisor+1);
		}
			
		return 0;
    }
	
	private static int  dividePositivePositive(long dividend, long divisor) {
		if (dividend <divisor) return 0;
		if (dividend == divisor) return 1;
		if (divisor == 1) return (int) dividend;
		
		int[] divideArray = divideTwo(dividend, divisor);
		
		dividend = divideArray[0];
		divisor = divideArray[1];
		if (divisor == 1) return (int) dividend;
        return (int) Math.exp((Math.log((double)dividend)-Math.log((double)divisor)));
	}
	
	private static int[] divideTwo(long dividend, long divisor) {
		
		while ((divisor &1) == 0) {
			dividend >>= 1;
			divisor >>= 1;
		}
		int[] result = {(int) dividend, (int) divisor};
		return result;
	}
}
