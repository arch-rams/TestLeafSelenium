package week1.Day1;

import java.util.Scanner;

public class PrimeNumbers {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the number to verify if it's prime");
		//Declaring inputs
		int num = scan.nextInt();
		boolean check = false;
		
		if (num==0 || num==1) {
			System.out.println(num + " is not a prime number");
		} else {
			for(int i=2; i<num/2; i++) {
				if(num%i==0) {
					System.out.println(num + " is not a prime number");
					check = true;
					break;
				}
			}
			
			if(!check) {
				System.out.println(num + " is a prime number");
			}
		}
	}

}
