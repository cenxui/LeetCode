package number;

public class Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int romanToInt(String s) {
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
