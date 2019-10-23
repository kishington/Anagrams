package ua.com.foxminded.anagrams.manipulators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class WordManipulatorTest {
    private static WordManipulator manipulator;

    @BeforeAll
    public static void initialise() {
        manipulator = new WordManipulator();
    }

    @Test
    void createAnagramOutputWhenPassedEmptyString() {
        String expected = "";
        String actual = manipulator.createAnagram("");
        assertEquals(expected, actual);
    }

    @Test
    void createAnagramOutputWhenPassedJustWhitespaces() {
        String expected = "  \t   \n   \r   ";
        String actual = manipulator.createAnagram("  \t   \n   \r   ");
        assertEquals(expected, actual);
    }

    @Test
    void createAnagramOutputWhenPassedJustOneWord() {
        String expected = "  ..aw=y$-kj  ";
        String actual = manipulator.createAnagram("  ..jk=y$-wa  ");
        assertEquals(expected, actual);
    }

    @Test
    void createAnagramReturnSameStringWhenCalledTwoTimes() {
        String expected = " ..aw=y$-kj  35v#jtykj%45asf     0(afa_a(l  ";
        String actual = manipulator.createAnagram(" ..aw=y$-kj  35v#jtykj%45asf     0(afa_a(l  ");
        actual = manipulator.createAnagram(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void createAnagramShouldThrowNullPointerExceptionWhenPassedNull() {
        assertThrows(NullPointerException.class, () -> manipulator.createAnagram(null));
    }

}
