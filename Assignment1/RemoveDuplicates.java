package week1.Day1;

public class RemoveDuplicates {

	public static String strBuilder(String[] splText) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < splText.length; i++) {
			strBuilder.append(splText[i]);
			if(!splText[i].equals(""))
				strBuilder.append(" ");
		}
		return strBuilder.toString();
	}

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] splText = text.split("\\s+");
		int count = 0;

		for (int i = 0; i < splText.length; i++) {
			for (int j = i; j < splText.length; j++) {
				// System.out.println(splText[i] +" " +splText[j]);
				if (splText[i].equals(splText[j]) && !splText[i].equals("")) {
					count++;
					if (count > 1) {
						splText[j] = "";
					}
				}
			}
			count = 0;
		}

		String modWord = strBuilder(splText);
		System.out.println(modWord);
	}
}
