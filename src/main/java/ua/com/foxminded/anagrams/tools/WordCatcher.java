package main.java.ua.com.foxminded.anagrams.tools;
import java.util.ArrayList;

public class WordCatcher {
     
    public ArrayList<String> getWords(String inputText) {
    	ArrayList<String> words = new ArrayList<>();
    	while(true) {
    		inputText = inputText.trim();
    		String[] firstWordAndRest = inputText.split("\\s",2);
    		String firstWord = firstWordAndRest[0];
    		words.add(firstWord);
    		if (firstWordAndRest.length == 2) {
    			inputText = firstWordAndRest[1];
    		} 
    		else {
    			break;
    		}		
    	}
    	return words;
    }
}
