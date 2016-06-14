package number;

import java.util.ArrayList;

public class Number {

	public static void main(String[] args) {
		System.out.println(isHappy(3));

	}
	
	public static int trailingZeroes(int n) {
		int result = 0;
		while (n>0) {
			n = n/5;
			result = result + n;
		}
        return result;
    }
	
	/**
	 * check the number is happy or not
	 * the process is endless or end in 1 
	 * if number lower than 10 it can be check if it is happy or not
	 * @param n the number we ant to check
	 * @return true if the number is happy
	 */
	
	public static boolean isHappy(int n) {
		ArrayList<Integer> arrayList;		
		while (n>9) {
			arrayList = new ArrayList<>();
			while (n>0) {
				arrayList.add((n%10));
				n = n/10;
			}		
			n = square(arrayList);
			System.out.println(n);
		} 
		
		if (n == 1) {
			return true;
		}
		
		if (n == 7) {
			return true;
		}
		
        return false;
    }
	
	private static int square(ArrayList<Integer> arrayList) {
		int sum = 0;
		int temp;
		for (int i = 0; i<arrayList.size();i++) {
			temp = arrayList.get(i);
			sum = sum + temp*temp;
		}
		return sum;
	}
	
	public static int romanToInt(String s) {
        int res=0;
        String[] c = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] n = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int len = s.length();
        int i=12,j=0;
        while(i>=0 && j<=len ){
            int len_temp=c[i].length();
            String temp="";
            if(j+len_temp<=len){
                 temp=s.substring(j,j+len_temp);
            }
            if(c[i].equals(temp)){
                res+=n[i];
                j+=len_temp;
            }else{
                i--;
            }
        }
        return res;
    }
}
