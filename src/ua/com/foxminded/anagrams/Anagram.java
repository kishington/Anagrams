package ua.com.foxminded.anagrams;
import java.util.ArrayList;
import static java.lang.Character.isWhitespace;

public class Anagram{
      
    public Anagram(String sentence) {
        System.out.println(createAnagram(sentence));
    }
   
    public static void main(String []args){
   
        String sentence = "   Sk3fsl=f kLj;pof-W f4wer sd9a   ";
        System.out.println("Original sentence:");
        System.out.println(sentence);
        
        System.out.println("Anagram:");
        new Anagram(sentence);
     }
    

    String createAnagram(String sentence) {
       
        ArrayList<String> wordList = WordCatcher.getWordsFromString(sentence);
       
        for(int i=0; i < wordList.size(); i++) {
            String str = WordModifier.reverseLettersInWord(wordList.get(i));
            wordList.set(i,str);
        }

        StringBuilder newSentence = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < sentence.length()) {
            if(!isWhitespace(sentence.charAt(i))) { 
                newSentence.append(wordList.get(j));
                i += wordList.get(j).length();
                j++;
            } else {
                newSentence.append(sentence.charAt(i));
                i++;
            }
        }
        return newSentence.toString();
    }
}