package power;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPowerFour(1));
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
	
//	public static boolean isPowerOfThree(int n) {
//		
//	}
}
