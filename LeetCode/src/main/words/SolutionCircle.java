package words;

import java.util.HashMap;
import java.util.Map;

public class SolutionCircle {

    public static void main(String[] args) {


    }

    public static boolean judgeCircle(String moves) {
        if (moves == null) return false;

        char[] moveArray = moves.toUpperCase().toCharArray();

        Map<Character, Integer> moveMap = new HashMap<>();

        int len = moveArray.length;

        if (len  == 0) return true;

        if (len %2 != 0) return false;

        for (int i = 0; i< len; i++ ) {
            char temp = moveArray[i];
            if (moveMap.containsKey(temp)) {
                moveMap.put(temp, moveMap.get(temp)+1);
            }else {
                moveMap.put(temp, 1);
            }

        }

        if (moveMap.containsKey('L') && moveMap.get('L').equals(moveMap.get('R')) == false) {
            return false;
        }

        if (moveMap.containsKey('U') && moveMap.get('U').equals(moveMap.get('D')) == false) {
            return false;
        }
        return true;
    }

}
