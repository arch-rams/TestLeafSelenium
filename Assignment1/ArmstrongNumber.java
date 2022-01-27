package week1.Day1;

import java.util.Scanner;

public class ArmstrongNumber {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the number to verify if is an Armstrong Number:");
		// Declare your input
		int num = 0, original = scan.nextInt(), sum = 0;
		
		num = original;

		while (num != 0) {
			int remainder = num % 10;
			sum += Math.pow(remainder, 3);
			// System.out.println("remainder:" +sum);
			num = num / 10;
			// System.out.println("num: "+num);
		}

		if (original == sum) {
			System.out.println("The number " + original + " is an Armstrong Number");
		} else {
			System.out.println("The number " + original + " is not an Armstrong Number");
		}

	}

}
