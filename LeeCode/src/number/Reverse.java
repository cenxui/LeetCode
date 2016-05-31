package number;

public class Reverse {

	public static void main(String[] args) {
//		System.out.println(reverseBit(43261596));
		System.out.println(reverseInteger(153155588));
	}
	
	public static int reverseBit(int n) {
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
	
	public static int reverseInteger(int n) {
		if (n >= 0) {
			return reverseUnsingInteger(n);
		}else {
			return reverseUnsingInteger(-1*n)*-1;
		}
	}
	
	private static int reverseUnsingInteger(int n) {
		char[] temp = String.valueOf(n).toCharArray();
		
		char[] number = new char[temp.length];
		int tempPosition = temp.length-1; 
		for (int i = 0;i <= tempPosition;i++) {
			number[i] = temp[tempPosition - i];
		}
		
		return Integer.valueOf(String.valueOf(number)).intValue();
	}
}
