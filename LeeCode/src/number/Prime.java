package number;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	public static void main(String[] args) {
		long temp = System.currentTimeMillis();
		System.out.println(countPrimes(5000000));	
		System.out.println(System.currentTimeMillis() - temp);

	}
	
	/**
	 *  count the prime number lower than n
	 * @param n
	 * @return
	 */
	public static int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		
		if (n == 3) {
			return 1;
		}
		
		int count = 2;
		List<Integer> list = new ArrayList<>();
		list.add(3);
		
		for (int i = 5; i < n; i = i+2) {
			if (isPrime(i, list)) {
				list.add(i);
				count++;
			}
		}
		return count;
    }
	
	public static boolean  isPrime(int num, List<Integer> list ) {	
		for (int i = 0; list.get(i)*list.get(i)<= num && i<list.size(); i++) {
			if (num %list.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
}
