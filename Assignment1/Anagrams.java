package week1.Day1;

import java.util.Arrays;

public class Anagrams {
	public static void main(String[] args) {
		String word1 = "listen";
		String word2 = "silent";
		boolean isAnagram = true;

		if (word1.length() == word2.length()) {
			char[] wrd1 = word1.toCharArray();
			char[] wrd2 = word2.toCharArray();
			Arrays.sort(wrd1);
			Arrays.sort(wrd2);

			for (int m = 0; m < wrd1.length; m++) {
				if (wrd1[m] != wrd2[m]) {
					System.out.println("The words are not anagrams");
					isAnagram = false;
					break;
				}
			}
			if (isAnagram) {
				System.out.println("The words are anagrams");
			}
		} else {
			System.out.println("The words don't match in length");
		}
	}

}
