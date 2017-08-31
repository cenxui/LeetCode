package number;

public class FindComplement {
    public static void main(String[] args) {
//
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {

        if (num >0) {
            for (int i = 31; i > 0; i--) {
                int temp  = num & 1<<i;
                if ( temp != 0) {

                    return (1<<(i+1)) - (num+1);
                }
            }
        }else if (num <0) {
            for (int i = 32; i > 0; i--) {
                int temp  = num & 1<<i;
                if ( temp != 0) {
                    return -1*(1<<(i+1)) - (num) +1;
                }
            }
        }

        return 0;

    }
}
