package ua.com.foxminded.anagrams.manipulators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WordManipulatorTest {
    private static WordManipulator manipulator;

    @BeforeAll
    public static void initialise() {
        manipulator = new WordManipulator();
    }

    @Test
    public void createAnagram_ShouldThrowNullPointerExceptionWhenPassedNull() {
        assertThrows(NullPointerException.class, () -> manipulator.createAnagram(null));
    }

    @ParameterizedTest(name = "input: \"{0}\"")
    @ValueSource(strings = { "", " ", "     ", "123:;,.)(][" })
    void createAnagram_ShouldReturnSameStringWhenPassedNonLettersOnly(String input) {
        String expectedOutput = input;
        String actualOutput = manipulator.createAnagram(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest(name = "\"{0}\" should output \"{1}\"")
    @CsvSource({ 
        "a, a",
        "aaaaa, aaaaa",
        "abcdefg, gfedcba",
        "aaaaAAaaAaA, AaAaaAAaaaa"

    })
    void createAnagram_SouldReverseLettersWhenPassedLettersOnly(String input, String expectedOutput) {
        String actualOutput = manipulator.createAnagram(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createAnagram_ShouldOnlyReverseLettersWhenPassedOneWordWithLettersAndNonLetters() {
        String expected = "  ..aW=y$-Kj  ";
        String actual = manipulator.createAnagram("  ..jK=y$-Wa  ");
        assertEquals(expected, actual);
    }

    @Test
    void createAnagram_ShouldOnlyReverseLettersInWordsWhenPassedSeveralWords() {
        String input = "  H2o(w a:re yo;u? I /am fi][ne, th!ank you! :)  ";
        String expectedOutput = "  w2o(H e:ra uo;y? I /ma en][if, kn!aht uoy! :)  ";
        String actualOutput = manipulator.createAnagram(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createAnagram_ShouldReturnSameStringWhenCalledTwoTimes() {
        String input = " ..aw=y$-kj  35v#jtykj%45asf     0(afa_a(l  ";
        String expectedOutput = input;
        String actualOutput = manipulator.createAnagram(input);
        actualOutput = manipulator.createAnagram(actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }
}
