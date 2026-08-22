package com.jmp.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RomanNumeralConverterTest {
    private final RomanNumeralConverter converter = new RomanNumeralConverter();

    // Basic Roman numerals
    @Test
    void shouldConvertOneToI() {
        assertEquals("I", converter.convert(1));
    }

    @Test
    void shouldConvertFiveToV() {
        assertEquals("V", converter.convert(5));
    }

    @Test
    void shouldConvertTenToX() {
        assertEquals("X", converter.convert(10));
    }

    // Subtractive notation
    @Test
    void shouldConvertFourToIV() {
        assertEquals("IV", converter.convert(4));
    }

    @Test
    void shouldConvertNineToIX() {
        assertEquals("IX", converter.convert(9));
    }

    @Test
    void shouldConvertFortyToXL() {
        assertEquals("XL", converter.convert(40));
    }

    @Test
    void shouldConvertNinetyToXC() {
        assertEquals("XC", converter.convert(90));
    }

    @Test
    void shouldConvertFourHundredToCD() {
        assertEquals("CD", converter.convert(400));
    }

    @Test
    void shouldConvertNineHundredToCM() {
        assertEquals("CM", converter.convert(900));
    }

    // Larger numbers
    @Test
    void shouldConvertFiftyEightToLVIII() {
        assertEquals("LVIII", converter.convert(58));
    }

    @Test
    void shouldConvertOneHundredNinetyFourToCXCIV() {
        assertEquals("CXCIV", converter.convert(194));
    }

    @Test
    void shouldConvertNineteenNinetyFourToMCMXCIV() {
        assertEquals("MCMXCIV", converter.convert(1994));
    }

    @Test
    void shouldConvertThreeThousandNineHundredNinetyNine() {
        assertEquals("MMMCMXCIX", converter.convert(3999));
    }

    // Invalid input
    @Test
    void shouldRejectZero() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert(0));
    }

    @Test
    void shouldRejectNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert(-1));
    }

    @Test
    void shouldRejectNumberGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert(4000));
    }
}