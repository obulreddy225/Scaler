package com.jmp.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void shouldRejectNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldRejectPasswordShorterThanEightCharacters() {
        assertFalse(validator.isValid("Abc123"));
    }

    @Test
    void shouldRejectPasswordWithoutUppercaseLetter() {
        assertFalse(validator.isValid("abcdefg1"));
    }

    @Test
    void shouldRejectPasswordWithoutLowercaseLetter() {
        assertFalse(validator.isValid("ABCDEFG1"));
    }

    @Test
    void shouldRejectPasswordWithoutDigit() {
        assertFalse(validator.isValid("Abcdefgh"));
    }

    @Test
    void shouldAcceptPasswordMeetingAllRequirements() {
        assertTrue(validator.isValid("Abcdefg1"));
    }

    @Test
    void shouldAcceptLongerValidPassword() {
        assertTrue(validator.isValid("HelloWorld123"));
    }
}
