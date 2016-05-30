package number;

public class Reverse {

	public static void main(String[] args) {
		System.out.println(reverseBit(43261596));

	}
	
	private static int reverseBit(int n) {
		int result = 0;
        for (int i = 0; i<32; i++) {
        	result <<= 1;
            if ((n & 1) == 1) {
                result += 1;               
            }
            n >>= 1;
        }
        return result;
	}
}
