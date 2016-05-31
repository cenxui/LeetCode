package power;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 30;
		for (int i = 0; i<5; i++) {
			b = b >>1;
		System.out.println(b);
		}
		
	}
	
	public static boolean isPowerTwo(int n) {
		return n <= 0 ? false:(n & (n-1)) == 0;
	}
	
	private static boolean isPowerFour(int n) {
		return isPowerTwo(n) && ((n>>1)&n) == 0; 
	}
	
//	public static boolean isPowerOfThree(int n) {
//		
//	}
}
