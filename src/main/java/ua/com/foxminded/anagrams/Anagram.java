package main.java.ua.com.foxminded.anagrams;

import main.java.ua.com.foxminded.anagrams.manipulators.AnagramCreator;

public class Anagram {
    public static void main(String[] args) {

        String inputText = " +Aw Sk3fsxl=f  kLj;pof-W   f4wer     sd9a   ";
        AnagramCreator anagramCreator = new AnagramCreator();
        String outputText = anagramCreator.createAnagram(inputText);

        System.out.println("Original text:");
        System.out.println(inputText);

        System.out.println("Anagram:");
        System.out.println(outputText);
    }
}

