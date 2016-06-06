package number;


public class Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * this method is for solve it{@link https://leetcode.com/problems/rectangle-area/}
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return the area of tw rectangle cover
	 */
	
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rectABCD = (C-A)*(D-B);
        int rectEFGH = (G-E)*(H-F);
        if (rectABCD == 0) {
        	return rectEFGH;
        }
        
        if (rectEFGH == 0) {
        	return rectABCD;
        }
        
        int intersectionCover = 0;
        if (Math.min(C, G) <= Math.max(A, E)) {
        	intersectionCover = 0;
        }else if (Math.min(D, H) <= Math.max(B, F)) {
			intersectionCover = 0;
		}else {
			intersectionCover = (Math.min(C, G)- Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));				
		}
        
        return rectABCD+rectEFGH-intersectionCover;
    }
}
