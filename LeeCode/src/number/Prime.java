package number;

import org.junit.Ignore;

public class Prime {

	public static void main(String[] args) {
		long temp = System.currentTimeMillis();
		System.out.println(countPrimes(500000));	
		System.out.println(System.currentTimeMillis() - temp);

	}
	
	/**
	 * this method is too slow
	 * @param n
	 * @return
	 */
	@Ignore
	public static int countPrimes(int n) {		
		if (n<=1) {
			return 0;
		}

		if (n == 2) {
			return 1;
		}

		if (n == 3 || n == 4) {
			return 2;
		}
		
		if (n == 5) {
			return 3;
		}
		
		int size  = n;
		if (n>1000) {
			size = n/4;
		}
		
		int[] resultArray = new int[size];
		resultArray[0] = 2;
		resultArray[1] = 3;
		int length = 2;
		int check = 5;
		boolean isPrime;
		while (check <= n) {
			isPrime = true;			
			for (int i = 1; i < length; i++) {
				if (check % resultArray[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				resultArray[length] = check;
				length++;
			}
			check = check +2;
		}
				
        return length;
    }
}
