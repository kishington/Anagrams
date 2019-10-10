package ua.com.foxminded.anagrams;

class WordModifier {
   
    public String reverseLettersInWord(String word) {
      
        StringBuilder lettersOnly = new StringBuilder(removeNonLetterChars(word));
        lettersOnly.reverse();
       
        char[] arr = new char[word.length()];
       
        for(int i=0; i < arr.length; i++) {
            char ch = word.charAt(i);
            if(!Character.isLetter(ch)) {
            	arr[i] = ch;
            }
            else {
            	arr[i] = 'x';
            }
        }
       
        StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < arr.length; i++) {
            if(arr[i]=='x') {
                newWord.append(lettersOnly.charAt(0));
                lettersOnly.deleteCharAt(0);
            }
            else {
            	newWord.append(arr[i]);
            }
        }
        return newWord.toString();
    }
   
    public String removeNonLetterChars(String word) {
        
    	StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLetter(ch)) {
            	newWord.append(ch);
            }
        }
        return newWord.toString();
    }
}