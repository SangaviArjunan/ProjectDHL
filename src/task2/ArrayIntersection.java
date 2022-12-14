package task2;

import java.util.ArrayList;

/**
 * @author SArjunan
 *
 */
public class ArrayIntersection {

	/**
	 * 
	 */
	static int[] out = null;
	static ArrayList<Integer> al = new ArrayList<>();

	public static void intersect(int[] a1, int[] a2) {
		for (int a = 0; a < a1.length; a++) {
			for (int b = 0; b < a2.length; b++) {
				if (a1[a] == a2[b]) {
					if (!al.contains(a1[a])) {
						al.add(a1[a]);
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1 = { 9, 4, 5, 9 };
		int[] a2 = { 8, 7, 5, 9, 1, 2, 9, 9, 5 };
		intersect(a1, a2);
		System.out.println(al);
	}

}
