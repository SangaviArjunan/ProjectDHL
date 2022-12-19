package task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author SArjunan
 * 
 *         To find the Array Intersection Run this class and follow the
 *         instructions given in console
 * 
 */
public class ArrayIntersection {

	/**
	 * this method takes 2 array inputs and returns common numbers from both arrays
	 * in an ArrayList
	 */
	public static ArrayList<Integer> intersect(int[] a1, int[] a2) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int a = 0; a < a1.length; a++) {
			for (int b = 0; b < a2.length; b++) {
				if (a1[a] == a2[b]) {
					if (!al.contains(a1[a])) {
						al.add(a1[a]);
					}
				}
			}
		}
		return al;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter number of elements in first array:");
			int a = scanner.nextInt();
			int x[] = new int[a];
			System.out.println("Enter first array elements:");
			for (int i = 0; i < a; i++) {
				x[i] = scanner.nextInt();
			}
			System.out.println("Enter number of elements in second array:");
			a = scanner.nextInt();
			int y[] = new int[a];
			System.out.println("Enter second array elements:");
			for (int i = 0; i < a; i++) {
				y[i] = scanner.nextInt();
			}
			al = intersect(x, y);
		}
		System.out.println(al);
	}

}
