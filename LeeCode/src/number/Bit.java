package number;

public class Bit {
	public static void main(String[] arg) {
		System.out.println(numberOfBit(2147483647l));

	}
	
	public static int numberOfBit(long l) {
		int sum = 0;
		for (int i = 0 ; i<32;i++ ){
			if ((l&1) == 1) {			
				sum = sum + 1;				
			} 
			System.out.println(l);
			l = l>>1;
		}
		return sum;
	}
}
