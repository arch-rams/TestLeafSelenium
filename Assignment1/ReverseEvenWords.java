package week1.Day1;

import org.bouncycastle.util.Arrays;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String text = "This is the line to check reversal of even words";
		String[] textSplit = text.split("\\s+");

		for (int i = 0; i < textSplit.length; i++) {
			if (i % 2 != 0) {
				textSplit[i] = reverseWord(textSplit[i]);
			}
		}
		//Using StringBuilderFunction from the class in this package
		RemoveDuplicates strBuild = new RemoveDuplicates();

		String alteredText = strBuild.strBuilder(textSplit);
		System.out.println(alteredText);
	}

	private static String reverseWord(String string) {
		// TODO Auto-generated method stub
		String revWord = new StringBuilder(new String(string)).reverse().toString();

		return revWord;
	}
}
