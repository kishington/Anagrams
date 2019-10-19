package ua.com.foxminded.anagrams.manipulators;

import java.util.*;

public class WordManipulator {
    private static final String WHITESPACE_REGEX = "\\s";
    private static final char DUMMY_CHAR = 'x';

    public List<String> getWords(String inputText) {
        List<String> words = new ArrayList<String>();
        boolean reachedLastWord = false;
        while (!reachedLastWord) {
            inputText = inputText.trim();
            String[] firstWordAndRest = inputText.split(WHITESPACE_REGEX, 2);
            String firstWord = firstWordAndRest[0];
            words.add(firstWord);
            if (firstWordAndRest.length == 2) {
                inputText = firstWordAndRest[1];
            } else {
                reachedLastWord = true;
            }
        }
        return words;
    }

    public String reverseLettersInWord(String word) {

        String letterCharsOnlyString = removeNonLetterChars(word);
        StringBuilder letterCharsOnly = new StringBuilder(letterCharsOnlyString);
        letterCharsOnly.reverse();

        char[] nonLetterChars = new char[word.length()];

        for (int i = 0; i < nonLetterChars.length; i++) {
            char currentChar = word.charAt(i);
            if (!Character.isLetter(currentChar)) {
                nonLetterChars[i] = currentChar;
            } else {
                nonLetterChars[i] = DUMMY_CHAR;
            }
        }

        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < nonLetterChars.length; i++) {
            if (nonLetterChars[i] == DUMMY_CHAR) {
                newWord.append(letterCharsOnly.charAt(0));
                letterCharsOnly.deleteCharAt(0);
            } else {
                newWord.append(nonLetterChars[i]);
            }
        }
        return newWord.toString();
    }

    public String removeNonLetterChars(String word) {

        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.isLetter(currentChar)) {
                newWord.append(currentChar);
            }
        }
        return newWord.toString();
    }
}

