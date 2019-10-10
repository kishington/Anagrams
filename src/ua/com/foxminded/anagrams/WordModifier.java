package ua.com.foxminded.anagrams;

class WordModifier {
   
    public String reverseLettersInWord(String word) {
    	
    	final char dummyChar = 'x';
      
        StringBuilder letterCharsOnly = new StringBuilder(removeNonLetterChars(word));
        letterCharsOnly.reverse();
       
        char[] nonLetterChars = new char[word.length()];
       
        for(int i=0; i < nonLetterChars.length; i++) {
            char currentChar = word.charAt(i);
            if(!Character.isLetter(currentChar)) {
            	nonLetterChars[i] = currentChar;
            }
            else {
            	nonLetterChars[i] = dummyChar;
            }
        }
       
        StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < nonLetterChars.length; i++) {
            if(nonLetterChars[i] == dummyChar) {
                newWord.append(letterCharsOnly.charAt(0));
                letterCharsOnly.deleteCharAt(0);
            }
            else {
            	newWord.append(nonLetterChars[i]);
            }
        }
        return newWord.toString();
    }
   
    public String removeNonLetterChars(String word) {
        
    	StringBuilder newWord = new StringBuilder();
       
        for(int i=0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(Character.isLetter(currentChar)) {
            	newWord.append(currentChar);
            }
        }
        return newWord.toString();
    }
}