package ua.com.foxminded.anagrams;
import java.util.ArrayList;

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
    	
    	WordCatcher wordCatcher = new WordCatcher();
        ArrayList<String> words = wordCatcher.getWordsFromString(sentence);
       
        WordModifier wordModifier = new WordModifier();
        for(int i = 0; i < words.size(); i++) {
            String str = wordModifier.reverseLettersInWord(words.get(i));
            words.set(i,str);
        }

        StringBuilder newSentence = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < sentence.length()) {
            if(!Character.isWhitespace(sentence.charAt(i))) { 
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