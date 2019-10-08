package ua.com.foxminded.anagrams;
import java.util.ArrayList;

public class Anagram{
	public static void main(String []args){
   
        String inputText = "   Sk3fsxl=f kLj;pof-W f4wer sd9a   ";
        String outputText = new Anagram().createAnagram(inputText);
        
        System.out.println("Original text:");
        System.out.println(inputText);
        
        System.out.println("Anagram:");
        System.out.println(outputText);        
    }
    
    public String createAnagram(String inputText) {
    	
    	WordCatcher wordCatcher = new WordCatcher();
        ArrayList<String> words = wordCatcher.getWords(inputText);
       
        WordModifier wordModifier = new WordModifier();
        for(int i = 0; i < words.size(); i++) {
            String str = wordModifier.reverseLettersInWord(words.get(i));
            words.set(i,str);
        }

        StringBuilder outputText = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < inputText.length()) {
            if(!Character.isWhitespace(inputText.charAt(i))) { 
                outputText.append(words.get(j));
                i += words.get(j).length();
                j++;
            } else {
                outputText.append(inputText.charAt(i));
                i++;
            }
        }
        return outputText.toString();
    }
}