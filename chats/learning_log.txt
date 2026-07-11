# Prompt

Explain the fundamentals of writing unit tests in Java, specifically using JUnit. Explain how to test different code paths and edge cases."
# AI

Unit tests verify that a small piece of code works correctly in isolation. In Java, JUnit is the most common framework for this.

Key ideas:

A unit test should be:
small
fast
deterministic
focused on one behavior
Test the public behavior, not the internal implementation.
Basic JUnit 5 structure:

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void addsTwoNumbers() {
        assertEquals(4, 2 + 2);
    }
}

Common JUnit annotations:

@Test: marks a test method
@BeforeEach: runs before each test
@AfterEach: runs after each test
@BeforeAll / @AfterAll: run once for the class
Common assertions:

assertEquals(expected, actual)
assertTrue(condition)
assertFalse(condition)
assertNull(value)
assertNotNull(value)
assertThrows(Exception.class, () -> code) for expected exceptions
A good test pattern is:

Arrange: set up input/data
Act: call the method
Assert: verify the result
Example:

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

class CalculatorTest {

    @Test
    void addReturnsSumForPositiveNumbers() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }
}

Testing different code paths:

Normal path

Test the common, expected behavior.
Branches

If your code has if/else, test both branches.
Example:

class StringUtils {
    public String normalize(String value) {
        if (value == null || value.isBlank()) {
            return "";
        }
        return value.trim();
    }
}

Tests:

class StringUtilsTest {

    @Test
    void returnsEmptyStringForNull() {
        StringUtils utils = new StringUtils();
        assertEquals("", utils.normalize(null));
    }

    @Test
    void returnsEmptyStringForBlankInput() {
        StringUtils utils = new StringUtils();
        assertEquals("", utils.normalize("   "));
    }

    @Test
    void trimsNonBlankInput() {
        StringUtils utils = new StringUtils();
        assertEquals("hello", utils.normalize("  hello  "));
    }
}

Testing edge cases:

null
empty string / empty list
zero values
negative values
very large values
boundary values like 0, 1, -1, maximum/minimum integers
exception behavior
Example:

class NumberUtils {
    public int square(int n) {
        return n * n;
    }
}

class NumberUtilsTest {

    @Test
    void squareHandlesZero() {
        assertEquals(0, new NumberUtils().square(0));
    }

    @Test
    void squareHandlesNegativeNumbers() {
        assertEquals(25, new NumberUtils().square(-5));
    }

    @Test
    void squareHandlesLargeNumbers() {
        assertEquals(1000000, new NumberUtils().square(1000));
    }
}

Testing exceptions:

class DivisionUtils {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b cannot be zero");
        }
        return a / b;
    }
}

class DivisionUtilsTest {

    @Test
    void throwsExceptionWhenDividingByZero() {
        DivisionUtils utils = new DivisionUtils();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> utils.divide(10, 0)
        );

        assertEquals("b cannot be zero", exception.getMessage());
    }
}

Good practices:

Give tests clear names: addReturnsSumForPositiveNumbers
Keep each test focused on one behavior
Avoid testing multiple things in one test
Use meaningful assertions
Make tests independent of each other
Prefer simple, readable setup
If you are using Maven, JUnit 5 dependency is typically:

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>

The main goal is to cover:

normal cases
alternate branches
invalid input
edge/boundary values
exceptions
If you want, I can also show you how to write tests for methods with loops, collections, or if/else logic in a small Java example.