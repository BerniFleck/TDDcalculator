package pt.ipp.isep.dei.examples.tdd.basic.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    private static Parser parser;

    @BeforeAll
    public static void setUp() {
        parser = new Parser();
    }

    @Test
    public void ensure_F_ReturnsMoveIcon() {
        String input = "f";
        String expected = ">";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }

    @Test
    public void ensure_R_ReturnsRotateIcon() {
        String input = "r";
        String expected = "o";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }

    @Test
    public void ensure_P_ReturnsPaintIcon() {
        String input = "p";
        String expected = "x";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }

    @Test
    public void ensure_FRP_ReturnsMoveRotatePaintIcons() {
        String input = "frp";
        String expected = ">ox";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }

    @Test
    public void ensure_FrP_ReturnsMoveRotatePaintIcons() {
        String input = "FrP";
        String expected = ">ox";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }

    @Test
    public void ensure_frrrp_ReturnsMove3TimesRotatePaintIcons() {
        String input = "frrrp";
        String expected = ">ooox";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }

    @Test
    public void ensure_fNpUI_ReturnsException() {
        String input = "fNpUI";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
    }

    @Test
    public void ensure_pRf_ReturnsPaintRotateMoveIcons() {
        String input = "pRf";
        String expected = "xo>";
        String actual;

        actual = parser.parse(input);

        assertEquals(expected, actual);
    }
}
