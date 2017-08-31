package intersection;

/**
 * 
 * @author xenxui
 * @since 2016/6/30
 */
public class IntersectionTwoArrays {

	public static void main(String[] args) {
		int[] x = { 1, 2, 2, 1 };
		int[] y = { 2, 2, 1 };
		int[] result = intersect(x, y);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */

	public static int[] intersect(int[] nums1, int[] nums2) {
		int[] intersection1;
		int[] intersection2;
		if (nums1.length > nums2.length) {
			intersection1 = nums1;
			intersection2 = nums2;
		} else {
			intersection2 = nums1;
			intersection1 = nums2;
		}
		int[] temp = new int[intersection2.length];
		int length = 0;
		for (int i = 0; i < intersection2.length; i++) {
			for (int j = 0; j < intersection1.length; j++) {
				if (intersection2[i] == intersection1[j]) {
					temp[length] = intersection2[i];
					intersection1[j] = -1;
					length = length + 1;
					break;
				}
			}
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = temp[i];
		}

		return result;
	}
}
