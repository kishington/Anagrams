package main.java.ua.com.foxminded.anagrams.tools;

import java.util.*;

public class AnagramCreator {

    public String createAnagram(String inputText) {

        WordManipulator wordManipulator = new WordManipulator();
        List<String> words = wordManipulator.getWords(inputText);

        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            String modifiedWord = wordManipulator.reverseLettersInWord(currentWord);
            words.set(i, modifiedWord);
        }

        StringBuilder outputText = new StringBuilder();
        int charIndex = 0;
        int wordIndex = 0;
        while (charIndex < inputText.length()) {
            char currentChar = inputText.charAt(charIndex);
            boolean isCurrentCharWhitespace = Character.isWhitespace(currentChar);
            if (!isCurrentCharWhitespace) {
                String currentWord = words.get(wordIndex);
                outputText.append(currentWord);
                charIndex += currentWord.length();
                wordIndex++;
            } else {
                outputText.append(currentChar);
                charIndex++;
            }
        }
        return outputText.toString();
    }
}

