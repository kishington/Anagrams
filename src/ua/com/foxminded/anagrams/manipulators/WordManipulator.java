package ua.com.foxminded.anagrams.manipulators;

public class WordManipulator {
    private static final char DUMMY_CHAR = 'x';
    private static final String WHITESPACES = "\\s+";
    
    public String createAnagram(String inputText) {

        String trimmedInput = inputText.trim();
        String[] words = trimmedInput.split(WHITESPACES);
        
        WordManipulator wordManipulator = new WordManipulator();

        for (int i = 0; i < words.length; i++) {
            words[i] = wordManipulator.reverseLetters(words[i]);
        }

        StringBuilder outputText = new StringBuilder();
        int charIndex = 0;
        int wordIndex = 0;
        while (charIndex < inputText.length()) {
            char ch = inputText.charAt(charIndex);
            boolean isCurrentCharWhitespace = Character.isWhitespace(ch);
            if (!isCurrentCharWhitespace) {
                String currentWord = words[wordIndex];
                outputText.append(currentWord);
                charIndex += currentWord.length();
                wordIndex++;
            } else {
                outputText.append(ch);
                charIndex++;
            }
        }
        return outputText.toString();
    }

    private String reverseLetters(String word) {

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

    private String removeNonLetterChars(String word) {

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

