package lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test void returnZero() {
        assertEquals(0, StringCalculator.Add(""));
    }

    @Test void returnNumber() {
        assertEquals(12, StringCalculator.Add("12"));
    }

    @Test void returnSum() {
        assertEquals(3, StringCalculator.Add("1,2"));
    }

    @Test void returnSumMultiple() {
        assertEquals(6, StringCalculator.Add("1,2,3"));
    }

    @Test void newlineDelimiter() {
        assertEquals(3, StringCalculator.Add("1\n2"));
    }

    @Test void differentDelimiters1() {
        assertEquals(10, StringCalculator.Add("1,2\n7"));
    }

    @Test void customDelimiter() {
        assertEquals(15, StringCalculator.Add("//>\n7>8"));
    }

    @Test void differentDelimiters2() {
        assertEquals(15, StringCalculator.Add("//:\n3,8\n1:3"));
    }

     @Test void ignoreThousand() {
        assertEquals(14, StringCalculator.Add("//:\n3,8\n3:1096"));
    }

    @Test
    void exceptNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.Add("//:\n2,-8\n-1");
        });

        assertEquals("Negatives are not allowed: [-8, -1]", exception.getMessage());
    }

    @Test void longDelimiters() {
        assertEquals(20, StringCalculator.Add("//[...]\n1,2...5\n10...2"));
    }

    @Test void multipleLongDelimiters1() {
        assertEquals(6, StringCalculator.Add("//[...][..][.]\n1..1.1,1...1\n1"));
    }

    @Test void multipleLongDelimiters2() {
        assertEquals(6, StringCalculator.Add("//[*][***][**]\n1*1**1,1***1\n1"));
    }
}
