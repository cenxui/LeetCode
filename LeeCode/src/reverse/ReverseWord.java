package reverse;

public class ReverseWord {
//	private static String words = "the sky is blue";
	private static String words = " 1";
	public static void main(String[] arg) {
		
		System.out.println("start" + reverseWords(words)+ "end");
	}
	
	public static String reverseWords(String string) {
		if (words == null || words.length() == 0)
			return "";
		
		String[] strings = words.split(" ");
		System.out.println( strings.length);
		if (strings.length == 0) {
			return "";
		}
		
		StringBuilder stringBuilder = new StringBuilder(strings[strings.length -1]);
		if (strings.length >2 ) {
			for (int i = strings.length -2; i>0 ;i--) {
				if (strings[i].equals("") == false)
					stringBuilder.append(" ").append(strings[i]);
				System.out.println(i);
			}
			
		}
		
		if (strings.length >1) {
			if (strings[0].hashCode() != 0){				
				stringBuilder.append(" ").append(strings[0]);
			}			
		}
		
		return stringBuilder.toString();
	}
}
