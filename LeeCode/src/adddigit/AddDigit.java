package adddigit;

/**
 * 
 * @author xenxui
 * @since 2016/5/30
 */
public class AddDigit {
	
	public int addDigits(int num) {
        return num == 0 ? 0 : (num -1)%9+1;
    }
}
