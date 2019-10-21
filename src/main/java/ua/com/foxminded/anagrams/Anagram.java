package ua.com.foxminded.anagrams;

import ua.com.foxminded.anagrams.manipulators.WordManipulator;

public class Anagram {
    public static void main(String[] args) {

        String inputText = " +Aw Sk3fsxl=f  kLj;pof-W   f4wer     sd9a   ";
        WordManipulator wordManipulator = new WordManipulator();
        String outputText = wordManipulator.createAnagram(inputText);

        System.out.println("Original text:");
        System.out.println(inputText);

        System.out.println("Anagram:");
        System.out.println(outputText);
    }
}

