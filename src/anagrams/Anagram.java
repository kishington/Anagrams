/*
Task 1 - Anagrams
Write an application that reverses all the words of input text:

  E.g. "abcd efgh" => "dcba hgfe"

All non-letter symbols should stay on the same places:

  E.g. "a1bcd efg!h" => "d1cba hgf!e"

Use Latin alphabet for test only.
*/

package anagrams;

import java.util.ArrayList;
import static java.lang.Character.isWhitespace;

public class Anagram{
      
    public Anagram(String sentence) {
        System.out.println(createAnagram(sentence));
    }
   
    public static void main(String []args){
   
        //String sentence = "   Sk3fsl=f kLj;pof-W f4wer sd9a   ";
        //String sentence = " P2o.rcu l'Eft th]e bU!ild/in-g ZA  ";
    	String sentence = "tta6nn7 anntvd agt 653_1MM 66543";
        System.out.println("Original sentence:");
        System.out.println(sentence);
        
        System.out.println("Anagram:");
        new Anagram(sentence);
     }
    

    String createAnagram(String sentence) {
       
        // getting separate words from the original sentence
        ArrayList<String> wordList = WordCatcher.getWordsFromString(sentence);
       
        // separately reversing words from the origianl sentence
        for(int i=0; i < wordList.size(); i++) {
            String str = WordModifier.reverseLettersInWord(wordList.get(i));
            wordList.set(i,str);
        }

        // creating a new sentence with the reversed words and copying the original whitespace chars
        StringBuilder newSentence = new StringBuilder();
        int i = 0; // iterating through whitespace characters
        int j = 0; // iterating through reversed words 
        while(i < sentence.length()) {
            if(!isWhitespace(sentence.charAt(i))) { 
                newSentence.append(wordList.get(j)); // adding reversed words to the new sentence
                i += wordList.get(j).length();
                j++;
            } else {
                newSentence.append(sentence.charAt(i)); // copying whitespace chars to the new sentence
                i++;
            }
        }
        return newSentence.toString();
    }
}