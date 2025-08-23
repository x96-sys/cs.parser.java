package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.*;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

class ParserSegmentTest {
    @Test
    void happyWordUnitRange() {
        Token t0 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));

        Token t1 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("q");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("word");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_E,
                        new Lexeme((byte) 0x65),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("word");

        Token t4 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("word");

        Token t5 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("word");

        Token t6 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("q");

        Token t7 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("empty_space");

        Token t8 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));
        t8.overKind("glyph");

        Token t9 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
                        new Span(new Position(1, 9, 9), new Position(1, 10, 10)));
        t9.overKind("glyph");

        Token t10 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_F,
                        new Lexeme((byte) 0x66),
                        new Span(new Position(1, 10, 10), new Position(1, 11, 11)));
        t10.overKind("glyph");

        Token t11 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 11, 11), new Position(1, 12, 12)));
        t11.overKind("glyph");

        Token t12 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 12, 12), new Position(1, 13, 13)));
        t12.overKind("empty_space");

        Token t13 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 13, 13), new Position(1, 14, 14)));
        t13.overKind("hexadecimal");

        Token t14 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 14, 14), new Position(1, 15, 15)));
        t14.overKind("hexadecimal");

        Token t15 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 15, 15), new Position(1, 16, 16)));
        t15.overKind("hexadecimal");

        Token t16 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(1, 16, 16), new Position(1, 17, 17)));
        t16.overKind("hexadecimal");

        Token t17 =
                new Token(
                        Kind.HYPHEN_MINUS,
                        new Lexeme((byte) 0x2D),
                        new Span(new Position(1, 17, 17), new Position(1, 18, 18)));

        Token t18 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 18, 18), new Position(1, 19, 19)));
        t18.overKind("hexadecimal");

        Token t19 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 19, 19), new Position(1, 20, 20)));
        t19.overKind("hexadecimal");

        Token t20 =
                new Token(
                        Kind.DIGIT_SEVEN,
                        new Lexeme((byte) 0x37),
                        new Span(new Position(1, 20, 20), new Position(1, 21, 21)));
        t20.overKind("hexadecimal");

        Token t21 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(1, 21, 21), new Position(1, 22, 22)));
        t21.overKind("hexadecimal");

        Token t22 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 22, 22), new Position(1, 23, 23)));

        Token t23 =
                new Token(
                        Kind.PLUS,
                        new Lexeme((byte) 0x2B),
                        new Span(new Position(1, 23, 23), new Position(1, 24, 24)));
        t23.overKind("quantifier");

        Token[] t =
                new Token[] {
                    t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17,
                    t18, t19, t20, t21, t22, t23
                };

        Segment s = new ParserSegment(new Tape(t)).parse();
        assertTrue(s.quantifier().isPresent());
        assertInstanceOf(OneOrMore.class, s.quantifier().get());
        assertEquals(3, s.axes().length);

        assertInstanceOf(Word.class, s.axes()[0]);
        Word w = (Word) s.axes()[0];
        assertArrayEquals("ceci".getBytes(), w.raw());

        assertInstanceOf(Unit.class, s.axes()[1]);
        Unit u = (Unit) s.axes()[1];
        assertFalse(u.bang().isPresent());
        assertEquals("sofi", new String(u.glyph().raw()));

        assertInstanceOf(RangeHex.class, s.axes()[2]);
        RangeHex r = (RangeHex) s.axes()[2];
        assertEquals(0x63, r.min().raw());
        assertEquals(0x73, r.max().raw());
    }

    @Test
    public void happyChoice() {
        Token t0 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));

        Token t1 =
                new Token(
                        Kind.LEFT_PARENTHESIS,
                        new Lexeme((byte) 0x28),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));

        Token t2 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("empty_space");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("glyph");

        Token t4 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_E,
                        new Lexeme((byte) 0x65),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("glyph");

        Token t5 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("glyph");

        Token t6 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("glyph");

        Token t7 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("empty_space");

        Token t8 =
                new Token(
                        Kind.VERTICAL_LINE,
                        new Lexeme((byte) 0x7C),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));

        Token t9 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 9, 9), new Position(1, 10, 10)));
        t9.overKind("empty_space");

        Token t10 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 10, 10), new Position(1, 11, 11)));
        t10.overKind("q");

        Token t11 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 11, 11), new Position(1, 12, 12)));
        t11.overKind("word");

        Token t12 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
                        new Span(new Position(1, 12, 12), new Position(1, 13, 13)));
        t12.overKind("word");

        Token t13 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_F,
                        new Lexeme((byte) 0x66),
                        new Span(new Position(1, 13, 13), new Position(1, 14, 14)));
        t13.overKind("word");

        Token t14 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 14, 14), new Position(1, 15, 15)));
        t14.overKind("word");

        Token t15 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 15, 15), new Position(1, 16, 16)));
        t15.overKind("q");

        Token t16 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 16, 16), new Position(1, 17, 17)));
        t16.overKind("empty_space");

        Token t17 =
                new Token(
                        Kind.RIGHT_PARENTHESIS,
                        new Lexeme((byte) 0x29),
                        new Span(new Position(1, 17, 17), new Position(1, 18, 18)));

        Token t18 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 18, 18), new Position(1, 19, 19)));

        Token t19 =
                new Token(
                        Kind.ASTERISK,
                        new Lexeme((byte) 0x2A),
                        new Span(new Position(1, 19, 19), new Position(1, 20, 20)));
        t19.overKind("quantifier");

        Token[] t =
                new Token[] {
                    t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17,
                    t18, t19
                };

        Segment segment = new ParserSegment(new Tape(t)).parse();
        assertInstanceOf(Choices.class, segment.axes()[0]);
        Choices choices = (Choices) segment.axes()[0];
        assertEquals(2, choices.cores().length);
        assertInstanceOf(Unit.class, choices.cores()[0]);
        assertInstanceOf(Word.class, choices.cores()[1]);

        Unit unit = (Unit) choices.cores()[0];
        Word word = (Word) choices.cores()[1];

        assertFalse(unit.bang().isPresent());
        assertEquals("ceci", new String(unit.glyph().raw()));
        assertFalse(unit.quantifier().isPresent());

        assertEquals("sofi", new String(word.raw()));
    }

    @Test
    void happyRecursive() {
        Token t0 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("LEFT_SQUARE_BRACKET");

        Token t1 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("LEFT_SQUARE_BRACKET");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("glyph");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("glyph");

        Token t4 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_F,
                        new Lexeme((byte) 0x66),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("glyph");

        Token t5 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("glyph");

        Token t6 =
                new Token(
                        Kind.ASTERISK,
                        new Lexeme((byte) 0x2A),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("quantifier");

        Token t7 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("RIGHT_SQUARE_BRACKET");

        Token t8 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));
        t8.overKind("empty_space");

        Token t9 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 9, 9), new Position(1, 10, 10)));
        t9.overKind("LEFT_SQUARE_BRACKET");

        Token t10 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 10, 10), new Position(1, 11, 11)));
        t10.overKind("hexadecimal");

        Token t11 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 11, 11), new Position(1, 12, 12)));
        t11.overKind("hexadecimal");

        Token t12 =
                new Token(
                        Kind.DIGIT_FOUR,
                        new Lexeme((byte) 0x34),
                        new Span(new Position(1, 12, 12), new Position(1, 13, 13)));
        t12.overKind("hexadecimal");

        Token t13 =
                new Token(
                        Kind.DIGIT_ONE,
                        new Lexeme((byte) 0x31),
                        new Span(new Position(1, 13, 13), new Position(1, 14, 14)));
        t13.overKind("hexadecimal");

        Token t14 =
                new Token(
                        Kind.HYPHEN_MINUS,
                        new Lexeme((byte) 0x2D),
                        new Span(new Position(1, 14, 14), new Position(1, 15, 15)));
        t14.overKind("HYPHEN_MINUS");

        Token t15 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 15, 15), new Position(1, 16, 16)));
        t15.overKind("hexadecimal");

        Token t16 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 16, 16), new Position(1, 17, 17)));
        t16.overKind("hexadecimal");

        Token t17 =
                new Token(
                        Kind.DIGIT_FOUR,
                        new Lexeme((byte) 0x34),
                        new Span(new Position(1, 17, 17), new Position(1, 18, 18)));
        t17.overKind("hexadecimal");

        Token t18 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 18, 18), new Position(1, 19, 19)));
        t18.overKind("hexadecimal");

        Token t19 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 19, 19), new Position(1, 20, 20)));
        t19.overKind("RIGHT_SQUARE_BRACKET");

        Token t20 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 20, 20), new Position(1, 21, 21)));
        t20.overKind("empty_space");

        Token t21 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 21, 21), new Position(1, 22, 22)));
        t21.overKind("LEFT_SQUARE_BRACKET");

        Token t22 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 22, 22), new Position(1, 23, 23)));
        t22.overKind("LEFT_SQUARE_BRACKET");

        Token t23 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 23, 23), new Position(1, 24, 24)));
        t23.overKind("glyph");

        Token t24 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_E,
                        new Lexeme((byte) 0x65),
                        new Span(new Position(1, 24, 24), new Position(1, 25, 25)));
        t24.overKind("glyph");

        Token t25 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 25, 25), new Position(1, 26, 26)));
        t25.overKind("glyph");

        Token t26 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 26, 26), new Position(1, 27, 27)));
        t26.overKind("glyph");

        Token t27 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 27, 27), new Position(1, 28, 28)));
        t27.overKind("RIGHT_SQUARE_BRACKET");

        Token t28 =
                new Token(
                        Kind.ASTERISK,
                        new Lexeme((byte) 0x2A),
                        new Span(new Position(1, 28, 28), new Position(1, 29, 29)));
        t28.overKind("quantifier");

        Token t29 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 29, 29), new Position(1, 30, 30)));
        t29.overKind("RIGHT_SQUARE_BRACKET");

        Token t30 =
                new Token(
                        Kind.QUESTION_MARK,
                        new Lexeme((byte) 0x3F),
                        new Span(new Position(1, 30, 30), new Position(1, 31, 31)));
        t30.overKind("quantifier");

        Token t31 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 31, 31), new Position(1, 32, 32)));
        t31.overKind("empty_space");

        Token t32 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 32, 32), new Position(1, 33, 33)));
        t32.overKind("LEFT_SQUARE_BRACKET");

        Token t33 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 33, 33), new Position(1, 34, 34)));
        t33.overKind("hexadecimal");

        Token t34 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 34, 34), new Position(1, 35, 35)));
        t34.overKind("hexadecimal");

        Token t35 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 35, 35), new Position(1, 36, 36)));
        t35.overKind("hexadecimal");

        Token t36 =
                new Token(
                        Kind.DIGIT_ONE,
                        new Lexeme((byte) 0x31),
                        new Span(new Position(1, 36, 36), new Position(1, 37, 37)));
        t36.overKind("hexadecimal");

        Token t37 =
                new Token(
                        Kind.HYPHEN_MINUS,
                        new Lexeme((byte) 0x2D),
                        new Span(new Position(1, 37, 37), new Position(1, 38, 38)));
        t37.overKind("HYPHEN_MINUS");

        Token t38 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 38, 38), new Position(1, 39, 39)));
        t38.overKind("hexadecimal");

        Token t39 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 39, 39), new Position(1, 40, 40)));
        t39.overKind("hexadecimal");

        Token t40 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 40, 40), new Position(1, 41, 41)));
        t40.overKind("hexadecimal");

        Token t41 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 41, 41), new Position(1, 42, 42)));
        t41.overKind("hexadecimal");

        Token t42 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 42, 42), new Position(1, 43, 43)));
        t42.overKind("RIGHT_SQUARE_BRACKET");

        Token t43 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 43, 43), new Position(1, 44, 44)));
        t43.overKind("RIGHT_SQUARE_BRACKET");

        Token t44 =
                new Token(
                        Kind.ASTERISK,
                        new Lexeme((byte) 0x2A),
                        new Span(new Position(1, 44, 44), new Position(1, 45, 45)));
        t44.overKind("quantifier");

        Token[] t =
                new Token[] {
                    t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17,
                    t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33,
                    t34, t35, t36, t37, t38, t39, t40, t41, t42, t43, t44
                };

        Segment segment = new ParserSegment(new Tape(t)).parse();
        assertTrue(segment.quantifier().isPresent());
        assertInstanceOf(ZeroOrMore.class, segment.quantifier().get());
        assertEquals(4, segment.axes().length);
    }

    @Test
    public void happy() {
        Token t0 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("LEFT_SQUARE_BRACKET");

        Token t1 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("empty_space");

        Token t2 =
                new Token(
                        Kind.LEFT_PARENTHESIS,
                        new Lexeme((byte) 0x28),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("LEFT_PARENTHESIS");

        Token t3 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("empty_space");

        Token t4 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_A,
                        new Lexeme((byte) 0x61),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("glyph");

        Token t5 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("empty_space");

        Token t6 =
                new Token(
                        Kind.VERTICAL_LINE,
                        new Lexeme((byte) 0x7C),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("VERTICAL_LINE");

        Token t7 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("empty_space");

        Token t8 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));
        t8.overKind("hexadecimal");

        Token t9 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 9, 9), new Position(1, 10, 10)));
        t9.overKind("hexadecimal");

        Token t10 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 10, 10), new Position(1, 11, 11)));
        t10.overKind("hexadecimal");

        Token t11 =
                new Token(
                        Kind.DIGIT_ONE,
                        new Lexeme((byte) 0x31),
                        new Span(new Position(1, 11, 11), new Position(1, 12, 12)));
        t11.overKind("hexadecimal");

        Token t12 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 12, 12), new Position(1, 13, 13)));
        t12.overKind("empty_space");

        Token t13 =
                new Token(
                        Kind.RIGHT_PARENTHESIS,
                        new Lexeme((byte) 0x29),
                        new Span(new Position(1, 13, 13), new Position(1, 14, 14)));
        t13.overKind("RIGHT_PARENTHESIS");

        Token t14 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 14, 14), new Position(1, 15, 15)));
        t14.overKind("empty_space");

        Token t15 =
                new Token(
                        Kind.LEFT_PARENTHESIS,
                        new Lexeme((byte) 0x28),
                        new Span(new Position(1, 15, 15), new Position(1, 16, 16)));
        t15.overKind("LEFT_PARENTHESIS");

        Token t16 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 16, 16), new Position(1, 17, 17)));
        t16.overKind("empty_space");

        Token t17 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 17, 17), new Position(1, 18, 18)));
        t17.overKind("LEFT_SQUARE_BRACKET");

        Token t18 =
                new Token(
                        Kind.LEFT_PARENTHESIS,
                        new Lexeme((byte) 0x28),
                        new Span(new Position(1, 18, 18), new Position(1, 19, 19)));
        t18.overKind("LEFT_PARENTHESIS");

        Token t19 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 19, 19), new Position(1, 20, 20)));
        t19.overKind("empty_space");

        Token t20 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 20, 20), new Position(1, 21, 21)));
        t20.overKind("hexadecimal");

        Token t21 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 21, 21), new Position(1, 22, 22)));
        t21.overKind("hexadecimal");

        Token t22 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 22, 22), new Position(1, 23, 23)));
        t22.overKind("hexadecimal");

        Token t23 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(1, 23, 23), new Position(1, 24, 24)));
        t23.overKind("hexadecimal");

        Token t24 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 24, 24), new Position(1, 25, 25)));
        t24.overKind("empty_space");

        Token t25 =
                new Token(
                        Kind.VERTICAL_LINE,
                        new Lexeme((byte) 0x7C),
                        new Span(new Position(1, 25, 25), new Position(1, 26, 26)));
        t25.overKind("VERTICAL_LINE");

        Token t26 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 26, 26), new Position(1, 27, 27)));
        t26.overKind("empty_space");

        Token t27 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 27, 27), new Position(1, 28, 28)));
        t27.overKind("glyph");

        Token t28 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 28, 28), new Position(1, 29, 29)));
        t28.overKind("empty_space");

        Token t29 =
                new Token(
                        Kind.RIGHT_PARENTHESIS,
                        new Lexeme((byte) 0x29),
                        new Span(new Position(1, 29, 29), new Position(1, 30, 30)));
        t29.overKind("RIGHT_PARENTHESIS");

        Token t30 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 30, 30), new Position(1, 31, 31)));
        t30.overKind("RIGHT_SQUARE_BRACKET");

        Token t31 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 31, 31), new Position(1, 32, 32)));
        t31.overKind("empty_space");

        Token t32 =
                new Token(
                        Kind.VERTICAL_LINE,
                        new Lexeme((byte) 0x7C),
                        new Span(new Position(1, 32, 32), new Position(1, 33, 33)));
        t32.overKind("VERTICAL_LINE");

        Token t33 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 33, 33), new Position(1, 34, 34)));
        t33.overKind("empty_space");

        Token t34 =
                new Token(
                        Kind.LEFT_PARENTHESIS,
                        new Lexeme((byte) 0x28),
                        new Span(new Position(1, 34, 34), new Position(1, 35, 35)));
        t34.overKind("LEFT_PARENTHESIS");

        Token t35 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 35, 35), new Position(1, 36, 36)));
        t35.overKind("LEFT_SQUARE_BRACKET");

        Token t36 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 36, 36), new Position(1, 37, 37)));
        t36.overKind("glyph");

        Token t37 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 37, 37), new Position(1, 38, 38)));
        t37.overKind("RIGHT_SQUARE_BRACKET");

        Token t38 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 38, 38), new Position(1, 39, 39)));
        t38.overKind("empty_space");

        Token t39 =
                new Token(
                        Kind.VERTICAL_LINE,
                        new Lexeme((byte) 0x7C),
                        new Span(new Position(1, 39, 39), new Position(1, 40, 40)));
        t39.overKind("VERTICAL_LINE");

        Token t40 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 40, 40), new Position(1, 41, 41)));
        t40.overKind("empty_space");

        Token t41 =
                new Token(
                        Kind.LEFT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5B),
                        new Span(new Position(1, 41, 41), new Position(1, 42, 42)));
        t41.overKind("LEFT_SQUARE_BRACKET");

        Token t42 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 42, 42), new Position(1, 43, 43)));
        t42.overKind("hexadecimal");

        Token t43 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 43, 43), new Position(1, 44, 44)));
        t43.overKind("hexadecimal");

        Token t44 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 44, 44), new Position(1, 45, 45)));
        t44.overKind("hexadecimal");

        Token t45 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(1, 45, 45), new Position(1, 46, 46)));
        t45.overKind("hexadecimal");

        Token t46 =
                new Token(
                        Kind.HYPHEN_MINUS,
                        new Lexeme((byte) 0x2D),
                        new Span(new Position(1, 46, 46), new Position(1, 47, 47)));
        t46.overKind("HYPHEN_MINUS");

        Token t47 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 47, 47), new Position(1, 48, 48)));
        t47.overKind("hexadecimal");

        Token t48 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 48, 48), new Position(1, 49, 49)));
        t48.overKind("hexadecimal");

        Token t49 =
                new Token(
                        Kind.DIGIT_SEVEN,
                        new Lexeme((byte) 0x37),
                        new Span(new Position(1, 49, 49), new Position(1, 50, 50)));
        t49.overKind("hexadecimal");

        Token t50 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(1, 50, 50), new Position(1, 51, 51)));
        t50.overKind("hexadecimal");

        Token t51 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 51, 51), new Position(1, 52, 52)));
        t51.overKind("RIGHT_SQUARE_BRACKET");

        Token t52 =
                new Token(
                        Kind.RIGHT_PARENTHESIS,
                        new Lexeme((byte) 0x29),
                        new Span(new Position(1, 52, 52), new Position(1, 53, 53)));
        t52.overKind("RIGHT_PARENTHESIS");

        Token t53 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 53, 53), new Position(1, 54, 54)));
        t53.overKind("empty_space");

        Token t54 =
                new Token(
                        Kind.RIGHT_PARENTHESIS,
                        new Lexeme((byte) 0x29),
                        new Span(new Position(1, 54, 54), new Position(1, 55, 55)));
        t54.overKind("RIGHT_PARENTHESIS");

        Token t55 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 55, 55), new Position(1, 56, 56)));
        t55.overKind("empty_space");

        Token t56 =
                new Token(
                        Kind.RIGHT_SQUARE_BRACKET,
                        new Lexeme((byte) 0x5D),
                        new Span(new Position(1, 56, 56), new Position(1, 57, 57)));
        t56.overKind("RIGHT_SQUARE_BRACKET");

        Token[] t =
                new Token[] {
                    t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17,
                    t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33,
                    t34, t35, t36, t37, t38, t39, t40, t41, t42, t43, t44, t45, t46, t47, t48, t49,
                    t50, t51, t52, t53, t54, t55, t56
                };

        Segment segment = new ParserSegment(new Tape(t)).parse();
        assertEquals(2, segment.axes().length);
        assertInstanceOf(Choices.class, segment.axes()[0]);
        assertInstanceOf(Choices.class, segment.axes()[1]);
    }
}
