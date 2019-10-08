package ua.com.foxminded.anagrams;

// This class provides some methods to modify words
class WordModifier {
   
    // this method reverses all a-z characters in a word
    static String reverseLettersInWord(String word) {
      
        StringBuilder lettersOnly = new StringBuilder(removeNonLetterChars(word)); // remove all non a-z chars in the word
        lettersOnly.reverse();
       
        char[] arr = new char[word.length()]; // auxiliary array to store non a-z chars and dummy values for a-z chars. It will be used to get a new word
       
        for(int i=0; i < arr.length; i++) {
            char ch = word.charAt(i);
            if((ch < 65) || (ch > 122) || ((ch > 90) && (ch < 97)))
                arr[i] = ch; // non a-z char stored here
            else
                arr[i] = 'x'; // dummy value at positions for a-z chars
        }
       
        StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < arr.length; i++) {
            if(arr[i]=='x') {
                newWord.append(lettersOnly.charAt(0));
                lettersOnly.deleteCharAt(0);
            } else
                newWord.append(arr[i]);
        }
        
        return newWord.toString();
    }
   
    
    // this method removes all non a-z characters from a word
    static String removeNonLetterChars(String word) {
        
    	StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            if((ch > 96) && (ch < 123) || (ch > 64) && (ch < 91))
                newWord.append(ch); // adding a-z chars only
        }
        return newWord.toString();
    }
}