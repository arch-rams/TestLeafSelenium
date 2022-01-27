package week1.Day1;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String word="ventriloquizing";
		String upperCaseWord = word.toUpperCase();
		char[] wordArray = word.toCharArray();
		
		for(int i=1; i<=word.length(); i++) {
			if(i%2!=0)
				wordArray[i-1] = upperCaseWord.charAt(i-1);
		}
		String newWord = String.valueOf(wordArray);
		System.out.println(newWord);
	}
}
