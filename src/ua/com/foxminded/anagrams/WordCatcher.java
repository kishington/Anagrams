package ua.com.foxminded.anagrams;
import java.util.ArrayList;

class WordCatcher {
   
    public ArrayList<String> getWords(String sentence){
        ArrayList<String> list = new ArrayList<>();
        String str = sentence;
        while(!str.equals(" ")){
            list.add(getFirstWord(str));
            str = deleteFirstWord(str);
        }
        return list;
    }
   
    public String getFirstWord(String sentence) {
        String str = sentence.trim() + " ";
        int i = 0;
        while(!Character.isWhitespace(str.charAt(i))) {
        	i++;
        }
        return str.substring(0,i);
    }
   
    public String deleteFirstWord(String sentence) {
        String str = sentence.trim() + " ";
        int i = 0;
        while(!Character.isWhitespace(str.charAt(i))) {
        	i++;
        }
        return str.substring(i);
    }  
}