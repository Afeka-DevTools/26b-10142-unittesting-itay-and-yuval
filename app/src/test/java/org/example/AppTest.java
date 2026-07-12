package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class AppTest {

    @Test
    public void testAdd() {
        assertEquals(5, App.add(2, 3));
        assertEquals(-1, App.add(2, -3));
    }

    @Test
    public void testIsPrime() {
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(17));
        assertFalse(App.isPrime(1));
        assertFalse(App.isPrime(4));
    }

    @Test
    public void testReverse() {
        assertEquals("cba", App.reverse("abc"));
        assertEquals("", App.reverse(""));
    }

    @Test
    public void testReverseNull() {
        assertThrows(NullPointerException.class, () -> App.reverse(null));
    }

    @Test
    public void testFactorial() {
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
        assertEquals(120, App.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(App.isPalindrome("racecar"));
        assertFalse(App.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindromeNull() {
        assertThrows(NullPointerException.class, () -> App.isPalindrome(null));
    }

    @Test
    public void testFibonacciUpTo() {
        assertEquals(Arrays.asList(0), App.fibonacciUpTo(0));
        assertEquals(Arrays.asList(0,1,1,2,3,5), App.fibonacciUpTo(5));
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-5));
    }

    @Test
    public void testCharFrequency() {
        Map<Character, Integer> freq = App.charFrequency("aabBc");
        assertEquals(2, freq.get('a').intValue());
        assertEquals(1, freq.get('B').intValue());
        assertEquals(1, freq.get('c').intValue());
    }

    @Test
    public void testCharFrequencyEmpty() {
        assertTrue(App.charFrequency("").isEmpty());
    }

    @Test
    public void testCharFrequencyNull() {
        assertThrows(NullPointerException.class, () -> App.charFrequency(null));
    }

    @Test
    public void testIsAnagram() {
        assertTrue(App.isAnagram("Listen", "Silent"));
        assertTrue(App.isAnagram("rail safety", "fairy tales"));
        assertFalse(App.isAnagram("hello", "billion"));
    }

    @Test
    public void testIsAnagramEmpty() {
        assertTrue(App.isAnagram("", ""));
    }

    @Test
    public void testIsAnagramNulls() {
        assertThrows(NullPointerException.class, () -> App.isAnagram(null, "x"));
        assertThrows(NullPointerException.class, () -> App.isAnagram("x", null));
    }

    @Test
    public void testAverage() {
        assertEquals(2.5, App.average(new int[]{2,3}), 1e-9);
        assertEquals(3.0, App.average(new int[]{1,5}), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{}));
    }

    @Test
    public void testAverageNull() {
        assertThrows(NullPointerException.class, () -> App.average(null));
    }

    @Test
    public void testFilterEvens() {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        List<Integer> expected = Arrays.asList(2,4,6);
        assertEquals(expected, App.filterEvens(input));
        assertEquals(Collections.emptyList(), App.filterEvens(Collections.emptyList()));
    }

    @Test
    public void testFilterEvensNull() {
        assertThrows(NullPointerException.class, () -> App.filterEvens(null));
    }

    @Test
    public void testMostCommonWord() {
        String text = "Apple banana apple orange apple banana";
        assertEquals("apple", App.mostCommonWord(text));
    }

    @Test
    public void testMostCommonWordEmpty() {
        assertEquals("", App.mostCommonWord(""));
    }

    @Test
    public void testMostCommonWordNull() {
        assertThrows(NullPointerException.class, () -> App.mostCommonWord(null));
    }
}
