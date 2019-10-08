package ua.com.foxminded.anagrams;

class WordModifier {
   
    static String reverseLettersInWord(String word) {
      
        StringBuilder lettersOnly = new StringBuilder(removeNonLetterChars(word));
        lettersOnly.reverse();
       
        char[] arr = new char[word.length()];
       
        for(int i=0; i < arr.length; i++) {
            char ch = word.charAt(i);
            if((ch < 65) || (ch > 122) || ((ch > 90) && (ch < 97)))
                arr[i] = ch;
            else
                arr[i] = 'x';
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
   
    static String removeNonLetterChars(String word) {
        
    	StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            if((ch > 96) && (ch < 123) || (ch > 64) && (ch < 91))
                newWord.append(ch);
        }
        return newWord.toString();
    }
}