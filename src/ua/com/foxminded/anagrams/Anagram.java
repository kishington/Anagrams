package ua.com.foxminded.anagrams;

public class Anagram {
	public static void main(String[] args) {

		String inputText = "   Sk3fsxl=f kLj;pof-W f4wer sd9a   ";
		String outputText = new AnagramCreator().createAnagram(inputText);

		System.out.println("Original text:");
		System.out.println(inputText);

		System.out.println("Anagram:");
		System.out.println(outputText);
	}
}