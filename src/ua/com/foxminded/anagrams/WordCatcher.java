package ua.com.foxminded.anagrams;
import static java.lang.Character.isWhitespace;
import java.util.ArrayList;

class WordCatcher {
   
    static ArrayList<String> getWordsFromString(String sentence){
        ArrayList<String> list = new ArrayList<>();
        String str = sentence;
        while(!str.equals(" ")){
            list.add(getFirstWord(str));
            str = deleteFirstWord(str);
        }
        return list;
    }
   
    static String getFirstWord(String sentence) {
        String str = sentence.trim() + " ";
        int i = 0;
        while(!isWhitespace(str.charAt(i))) i++;
        return str.substring(0,i);
    }
   
    static String deleteFirstWord(String sentence) {
        String str = sentence.trim() + " ";
        int i = 0;
        while(!isWhitespace(str.charAt(i))) i++;
        return str.substring(i);
    }  
}