package main.java.ua.com.foxminded.anagrams.tools;
import java.util.ArrayList;

public class AnagramCreator {

	public String createAnagram(String inputText) {

		WordCatcher wordCatcher = new WordCatcher();
		ArrayList<String> words = wordCatcher.getWords(inputText);

		WordModifier wordModifier = new WordModifier();
		for (int i = 0; i < words.size(); i++) {
			String modifiedWord = wordModifier.reverseLettersInWord(words.get(i));
			words.set(i, modifiedWord);
		}

		StringBuilder outputText = new StringBuilder();
		int charIndex = 0;
		int wordIndex = 0;
		while (charIndex < inputText.length()) {
			if (!Character.isWhitespace(inputText.charAt(charIndex))) {
				outputText.append(words.get(wordIndex));
				charIndex += words.get(wordIndex).length();
				wordIndex++;
			} else {
				outputText.append(inputText.charAt(charIndex));
				charIndex++;
			}
		}
		return outputText.toString();
	}
}
