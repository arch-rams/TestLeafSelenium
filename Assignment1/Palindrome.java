package week1.Day1;

import java.util.Scanner;

public class Palindrome {
public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the word to verify if it's palindrome");
		boolean istrue = true;
		String word = scan.next();
		
		for(int i=0, j=word.length()-1; i<word.length()/2; i++, j--) {
			if(word.charAt(i) != word.charAt(j)) {
				System.out.println(word + " is not a palindrome");
				istrue=false;
				break;
			} else {
				istrue = true;
			}
		}
		if(istrue) {
			System.out.println(word + " is a palindrome");
		}
		
	}

}
