# Copilot log (converted to markdown)

(Original content from chats/copilot_log.txt)

```
# Prompt
I need to write unit tests for the functions in App.java. Please help me write them using JUnit 5 and Assert statements. Ensure you cover all edge cases.
# AI
Here is a complete JUnit 5 test suite for App.java that covers normal behavior, branches, invalid input, and common edge cases such as empty input, negative values, and null.

package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void addReturnsSumForPositiveAndNegativeValues() {
        assertEquals(5, App.add(2, 3));
        assertEquals(0, App.add(-1, 1));
        assertEquals(-5, App.add(-2, -3));
    }

    @Test
    void isPrimeReturnsFalseForValuesLessThanTwo() {
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(1));
        assertFalse(App.isPrime(-7));
    }

    @Test
    void isPrimeReturnsTrueForPrimesAndFalseForNonPrimes() {
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(17));
        assertFalse(App.isPrime(4));
        assertFalse(App.isPrime(49));
    }

    @Test
    void reverseReversesStringAndHandlesEmptyAndSingleChar() {
        assertEquals("cba", App.reverse("abc"));
        assertEquals("", App.reverse(""));
        assertEquals("a", App.reverse("a"));
    }

    @Test
    void reverseThrowsForNullInput() {
        assertThrows(NullPointerException.class, () -> App.reverse(null));
    }

    @Test
    void factorialReturnsOneForZeroAndOne() {
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
    }

    @Test
    void factorialCalculatesPositiveValues() {
        assertEquals(120, App.factorial(5));
    }

    @Test
    void factorialThrowsForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
    }

    @Test
    void isPalindromeRecognizesPalindromesAndNonPalindromes() {
        assertTrue(App.isPalindrome("racecar"));
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(App.isPalindrome("hello"));
    }

    @Test
    void isPalindromeHandlesEmptyAndSingleCharacterStrings() {
        assertTrue(App.isPalindrome(""));
        assertTrue(App.isPalindrome("a"));
    }

    @Test
    void isPalindromeThrowsForNullInput() {
        assertThrows(NullPointerException.class, () -> App.isPalindrome(null));
    }

    @Test
    void fibonacciUpToReturnsSequenceUpToLimit() {
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), App.fibonacciUpTo(8));
    }

    @Test
    void fibonacciUpToHandlesZeroAndOne() {
        assertEquals(Collections.singletonList(0), App.fibonacciUpTo(0));
        assertEquals(Arrays.asList(0, 1), App.fibonacciUpTo(1));
    }

    @Test
    void fibonacciUpToThrowsForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1));
    }

    @Test
    void charFrequencyCountsCharacters() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 1);
        expected.put('c', 1);
        assertEquals(expected, App.charFrequency("aabbc"));
    }

    @Test
    void charFrequencyHandlesEmptyInput() {
        assertTrue(App.charFrequency("" ).isEmpty());
    }

    @Test
    void charFrequencyThrowsForNullInput() {
        assertThrows(NullPointerException.class, () -> App.charFrequency(null));
    }

    @Test
    void isAnagramDetectsAnagramsIgnoringCaseAndWhitespace() {
        assertTrue(App.isAnagram("listen", "silent"));
        assertTrue(App.isAnagram("Astronomer", "Moonstarer"));
        assertFalse(App.isAnagram("hello", "world"));
    }

    @Test
    void isAnagramHandlesEmptyStrings() {
        assertTrue(App.isAnagram("", ""));
    }

    @Test
    void isAnagramThrowsForNullInput() {
        assertThrows(NullPointerException.class, () -> App.isAnagram(null, "x"));
    }

    @Test
    void averageCalculatesMean() {
        assertEquals(3.0, App.average(new int[]{1, 2, 3, 4, 5}));
        assertEquals(2.5, App.average(new int[]{1, 2, 3, 4}));
    }

    @Test
    void averageThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{}));
    }

    @Test
  void filterEvensReturnsOnlyEvenNumbers() {
        assertEquals(Arrays.asList(2, 4, 6), App.filterEvens(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void filterEvensHandlesEmptyListAndNegativeNumbers() {
        assertTrue(App.filterEvens(Collections.emptyList()).isEmpty());
        assertEquals(Arrays.asList(-4, 0, 2), App.filterEvens(Arrays.asList(-3, -4, 0, 2, 5)));
    }

    @Test
    void mostCommonWordReturnsMostFrequentWord() {
        assertEquals("hello", App.mostCommonWord("hello world hello"));
        assertEquals("hello", App.mostCommonWord("Hello, hello! world"));
    }

    @Test
    void mostCommonWordHandlesEmptyInput() {
        assertEquals("", App.mostCommonWord(""));
    }

    @Test
    void mostCommonWordThrowsForNullInput() {
        assertThrows(NullPointerException.class, () -> App.mostCommonWord(null));
    }
}

If needed, I can also help convert these to parameterized tests to make them shorter.

# Second prompt
How can I verify if these tests cover all code paths and branches in App.java

#AI

The easiest way is to use a coverage tool such as JaCoCo.

Add coverage to Gradle
In build.gradle (or build.gradle.kts), add:

plugins {
    id 'java'
    id 'jacoco'
}

test {
    useJUnitPlatform()
    finalizedBy jacocoTestReport
}

jacocoTestReport {
    dependsOn test
    reports {
        xml.required = true
        html.required = true
    }
}

Run the tests and generate the report
On Windows:

gradlew.bat test jacocoTestReport

Open the coverage report
Open:

app/build/reports/jacoco/test/html/index.html

There you can see:

line coverage
branch coverage
method coverage
Check whether your tests hit every branch in App.java
For each method, make sure you test both outcomes of every branch:

isPrime

n < 2 → false
n >= 2 and divisible by a factor → false
n >= 2 and prime → true
factorial

{