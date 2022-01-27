package week1.Day1;

import java.util.Scanner;

public class FibonacciSeries {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int a = 0, b = 1, c = 0, range = 0;

		System.out.println("Enter the range of the series: ");
		range = scan.nextInt();

		if (range == 1) {
			System.out.println(a);
		} else if (range == 2) {
			System.out.println(a);
			System.out.println(b);
		} else {
			System.out.println(a);
			System.out.println(b);
			for (int i = 2; i < range; i++) {
				c = a + b;
				System.out.println(c);
				a = b;
				b = c;
			}
		}
	}

}
