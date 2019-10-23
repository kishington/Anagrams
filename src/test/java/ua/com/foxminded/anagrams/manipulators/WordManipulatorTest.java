package ua.com.foxminded.anagrams.manipulators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordManipulatorTest {

    @Test
    void createAnagramOutputWhenPassedEmptyString() {
        WordManipulator manipulator = new WordManipulator();
        String expected = "";
        String actual = manipulator.createAnagram("");
        assertEquals(expected, actual);
    }
    
    @Test
    void createAnagramOutputWhenPassedJustWhitespaces() {
        WordManipulator manipulator = new WordManipulator();
        String expected = "  \t   \n   \r   ";
        String actual = manipulator.createAnagram("  \t   \n   \r   ");
        assertEquals(expected, actual);
    }
    
    @Test
    void createAnagramOutputWhenPassedJustOneWord() {
        WordManipulator manipulator = new WordManipulator();
        String expected = "  ..aw=y$-kj  ";
        String actual = manipulator.createAnagram("  ..jk=y$-wa  ");
        assertEquals(expected, actual);
    }

    @Test
    void createAnagramReturnSameStringWhenCalledTwoTimes() {
        WordManipulator manipulator = new WordManipulator();
        String expected = " ..aw=y$-kj  35v#jtykj%45asf     0(afa_a(l  ";
        String actual = manipulator.createAnagram(" ..aw=y$-kj  35v#jtykj%45asf     0(afa_a(l  ");
        actual = manipulator.createAnagram(actual);
        assertEquals(expected, actual);
    }
}
