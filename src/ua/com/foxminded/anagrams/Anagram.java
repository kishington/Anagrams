package ua.com.foxminded.anagrams;
import java.util.ArrayList;
import static java.lang.Character.isWhitespace;

public class Anagram{
	public static void main(String []args){
   
        String inputText = "   Sk3fsl=f kLj;pof-W f4wer sd9a   ";
        String outputText = new Anagram().createAnagram(inputText);
        
        System.out.println("Original text:");
        System.out.println(inputText);
        
        System.out.println("Anagram:");
        System.out.println(outputText);        
    }
    
    public String createAnagram(String sentence) {
       
        ArrayList<String> words = WordCatcher.getWordsFromString(sentence);
       
        for(int i = 0; i < words.size(); i++) {
            String str = WordModifier.reverseLettersInWord(words.get(i));
            words.set(i,str);
        }

        StringBuilder newSentence = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < sentence.length()) {
            if(!isWhitespace(sentence.charAt(i))) { 
                newSentence.append(words.get(j));
                i += words.get(j).length();
                j++;
            } else {
                newSentence.append(sentence.charAt(i));
                i++;
            }
        }
        return newSentence.toString();
    }
}