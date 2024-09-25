package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    private final Converter converter = new Converter();

    @Test
    void whenRomanContainsInvalidCharacters_ThenThrowException() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            converter.romanToDecimal("AGFJDF");
        });
        Assertions.assertSame(IllegalArgumentException.class, e.getClass());
        Assertions.assertEquals("Invalid roman numeral", e.getMessage());
    }

    @Test
    void whenRomanIsNull_ThenThrowException() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            converter.romanToDecimal(null);
        });
        Assertions.assertSame(IllegalArgumentException.class, e.getClass());
        Assertions.assertEquals("Roman can not be null", e.getMessage());
    }

    @Test
    void whenRomanContainsLowerCaseCharacters_ThenThrowException() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            converter.romanToDecimal("xviii");
        });
        Assertions.assertSame(IllegalArgumentException.class, e.getClass());
        Assertions.assertEquals("Invalid roman numeral", e.getMessage());
    }

    @Test
    void whenRomanIsI_ThenReturn1() {
        assertEquals(1, converter.romanToDecimal("I"));
    }

    @Test
    void whenRomanIsII_ThenReturn2() {
        assertEquals(2, converter.romanToDecimal("II"));
    }

    @Test
    void whenRomanIsIV_ThenReturn4() {
        assertEquals(4, converter.romanToDecimal("IV"));
    }

    @Test
    void whenRomanIsV_ThenReturn5() {
        assertEquals(5, converter.romanToDecimal("V"));
    }

    @Test
    void whenRomanIsVI_ThenReturn6() {
        assertEquals(6, converter.romanToDecimal("VI"));
    }

    @Test
    void whenRomanIsIX_ThenReturn9() {
        assertEquals(9, converter.romanToDecimal("IX"));
    }

    @Test
    void whenRomanIsX_ThenReturn10() {
        assertEquals(10, converter.romanToDecimal("X"));
    }

    @Test
    void whenRomanIsL_ThenReturn50() {
        assertEquals(50, converter.romanToDecimal("L"));
    }

    @Test
    void whenRomanIsC_ThenReturn100() {
        assertEquals(100, converter.romanToDecimal("C"));
    }

    @Test
    void whenRomanIsD_ThenReturn500() {
        assertEquals(500, converter.romanToDecimal("D"));
    }

    @Test
    void whenRomanIsM_ThenReturn1000() {
        assertEquals(1000, converter.romanToDecimal("M"));
    }
}