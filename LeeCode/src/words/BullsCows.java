package words;

public class BullsCows {
	
	public static void main(String[] args) {
		String secret = "11";
		String guess = "01";
		System.out.println(getHint(secret, guess));
	}
	
	public static String getHint(String secret, String guess) {
        int[] point = new int[2];
		char[] SChar = secret.toCharArray();
		char[] GChar = guess.toCharArray();
		
		for (int i = 0; i<GChar.length; i++) {
			System.out.println(GChar[i]);
		}
		
		for (int i = 0; i<GChar.length; i++) {
			if (GChar[i] == SChar[i]) {
				point[0] = point[0] +1;
				SChar[i] = 0;
				GChar[i] = 100;
			}
		}
				
		for (int i = 0; i < GChar.length; i++) {
			for (int j = 0; j < SChar.length; j++) {				
				if (GChar[i] == SChar[j]) {						
					point[1] = point[1] +1;
					SChar[j] = 0;
					GChar[i] = 100;
					break;
				}
			}
		}
		
		return point[0]+ "A" + point[1] + "B";
    }
}
