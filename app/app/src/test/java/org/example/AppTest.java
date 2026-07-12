package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class AppTest {

    // add
    // constructor coverage: exercise no-arg constructor so JaCoCo records it
    @Test public void constructorIsCovered() { new App(); }

    @Test public void add_positive() { assertEquals(5, App.add(2, 3)); }
    @Test public void add_negative() { assertEquals(-1, App.add(2, -3)); }

    // isPrime
    @Test public void isPrime_lessThanTwo() { assertFalse(App.isPrime(1)); }
    @Test public void isPrime_prime() { assertTrue(App.isPrime(17)); }
    @Test public void isPrime_nonPrime() { assertFalse(App.isPrime(4)); }

    // reverse
    @Test public void reverse_regular() { assertEquals("cba", App.reverse("abc")); }
    @Test public void reverse_empty() { assertEquals("", App.reverse("")); }
    @Test public void reverse_null_throws() { assertThrows(NullPointerException.class, () -> App.reverse(null)); }

    // factorial
    @Test public void factorial_zero() { assertEquals(1, App.factorial(0)); }
    @Test public void factorial_one() { assertEquals(1, App.factorial(1)); }
    @Test public void factorial_positive() { assertEquals(120, App.factorial(5)); }
    @Test public void factorial_negative_throws() { assertThrows(IllegalArgumentException.class, () -> App.factorial(-1)); }

    // isPalindrome
    @Test public void isPalindrome_regular() { assertTrue(App.isPalindrome("racecar")); }
    @Test public void isPalindrome_punctuation() { assertTrue(App.isPalindrome("A man, a plan, a canal: Panama")); }
    @Test public void isPalindrome_empty() { assertTrue(App.isPalindrome("")); }
    @Test public void isPalindrome_null_throws() { assertThrows(NullPointerException.class, () -> App.isPalindrome(null)); }

    // fibonacciUpTo
    @Test public void fibonacci_zero() { assertEquals(Arrays.asList(0), App.fibonacciUpTo(0)); }
    @Test public void fibonacci_one() { assertEquals(Arrays.asList(0, 1, 1), App.fibonacciUpTo(1)); }
    @Test public void fibonacci_general() { assertEquals(Arrays.asList(0,1,1,2,3,5), App.fibonacciUpTo(5)); }
    @Test public void fibonacci_negative_throws() { assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1)); }

    // charFrequency
    @Test public void charFrequency_regular() {
        Map<Character,Integer> freq = App.charFrequency("aabBc");
        assertEquals(2, freq.get('a').intValue());
        assertEquals(1, freq.get('B').intValue());
        assertEquals(1, freq.get('c').intValue());
    }
    @Test public void charFrequency_empty() { assertTrue(App.charFrequency("").isEmpty()); }
    @Test public void charFrequency_null_throws() { assertThrows(NullPointerException.class, () -> App.charFrequency(null)); }

    // isAnagram
    @Test public void isAnagram_regular() { assertTrue(App.isAnagram("Listen","Silent")); }
    @Test public void isAnagram_whitespace_case() { assertTrue(App.isAnagram("rail safety","fairy tales")); }
    @Test public void isAnagram_empty() { assertTrue(App.isAnagram("","")); }
    @Test public void isAnagram_nullFirst_throws() { assertThrows(NullPointerException.class, () -> App.isAnagram(null,"x")); }
    @Test public void isAnagram_nullSecond_throws() { assertThrows(NullPointerException.class, () -> App.isAnagram("x",null)); }

    // average
    @Test public void average_normal() { assertEquals(2.5, App.average(new int[]{2,3}), 1e-9); }
    @Test public void average_another() { assertEquals(3.0, App.average(new int[]{1,5}), 1e-9); }
    @Test public void average_empty_throws() { assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{})); }
    @Test public void average_null_throws() { assertThrows(NullPointerException.class, () -> App.average(null)); }

    // filterEvens
    @Test public void filterEvens_regular() {
        assertEquals(Arrays.asList(2,4,6), App.filterEvens(Arrays.asList(1,2,3,4,5,6)));
    }
    @Test public void filterEvens_empty() { assertEquals(Collections.emptyList(), App.filterEvens(Collections.emptyList())); }
    @Test public void filterEvens_null_throws() { assertThrows(NullPointerException.class, () -> App.filterEvens(null)); }

    // mostCommonWord
    @Test public void mostCommonWord_regular() { assertEquals("apple", App.mostCommonWord("Apple banana apple orange apple banana")); }
    @Test public void mostCommonWord_punctuation_case() { assertEquals("hello", App.mostCommonWord("Hello, hello! world")); }
    @Test public void mostCommonWord_empty() { assertEquals("", App.mostCommonWord("")); }
    @Test public void mostCommonWord_null_throws() { assertThrows(NullPointerException.class, () -> App.mostCommonWord(null)); }

}
