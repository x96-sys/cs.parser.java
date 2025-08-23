package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.axis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Axis;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.RangeHex;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

class ParserAxisTest {

    @Test
    void happyUnit() {
        Token t0 =
                new Token(
                        Kind.EXCLAMATION_MARK,
                        new Lexeme((byte) 0x21),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("bang");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_B,
                        new Lexeme((byte) 0x62),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("glyph");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
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
                        Kind.LATIN_SMALL_LETTER_K,
                        new Lexeme((byte) 0x6B),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("glyph");

        Token t5 =
                new Token(
                        Kind.QUESTION_MARK,
                        new Lexeme((byte) 0x3F),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("quantifier");

        Axis axis = new ParserAxis(new Tape(new Token[] {t0, t1, t2, t3, t4, t5})).parse();
        assertInstanceOf(Unit.class, axis);
        Unit unit = (Unit) axis;
        assertTrue(unit.bang().isPresent());
        assertEquals("book", new String(unit.glyph().raw()));
        assertTrue(unit.quantifier().isPresent());
        assertInstanceOf(ZeroOrOne.class, unit.quantifier().get());
    }

    @Test
    void happyUnitWithInhibitor() {
        Token t0 =
                new Token(
                        Kind.EXCLAMATION_MARK,
                        new Lexeme((byte) 0x21),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("bang");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_B,
                        new Lexeme((byte) 0x62),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("glyph");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
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
                        Kind.LATIN_SMALL_LETTER_K,
                        new Lexeme((byte) 0x6B),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("glyph");

        Token t5 =
                new Token(
                        Kind.QUESTION_MARK,
                        new Lexeme((byte) 0x3F),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("quantifier");

        Axis axis = new ParserAxis(new Tape(new Token[] {t0, t1, t2, t3, t4, t5})).parse();
        assertInstanceOf(Unit.class, axis);
        Unit unit = (Unit) axis;
        assertTrue(unit.bang().isPresent());
        assertEquals("book", new String(unit.glyph().raw()));
        assertTrue(unit.quantifier().isPresent());
        assertInstanceOf(ZeroOrOne.class, unit.quantifier().get());
    }

    @Test
    void happyWord() {
        Token t0 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("q");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_W,
                        new Lexeme((byte) 0x77),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("word");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("word");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_R,
                        new Lexeme((byte) 0x72),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("word");

        Token t4 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_D,
                        new Lexeme((byte) 0x64),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("word");

        Token t5 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("q");

        Axis axis = new ParserAxis(new Tape(new Token[] {t0, t1, t2, t3, t4, t5})).parse();
        assertInstanceOf(Word.class, axis);
        Word word = (Word) axis;
        assertEquals(4, word.raw().length);
        assertEquals("word", new String(word.raw()));
    }

    @Test
    void happyRange() {
        Token t0 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("hexadecimal");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("hexadecimal");

        Token t2 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_E,
                        new Lexeme((byte) 0x45),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("hexadecimal");

        Token t3 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_F,
                        new Lexeme((byte) 0x46),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("hexadecimal");

        Token t4 =
                new Token(
                        Kind.HYPHEN_MINUS,
                        new Lexeme((byte) 0x2D),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));

        Token t5 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("hexadecimal");

        Token t6 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("hexadecimal");

        Token t7 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_F,
                        new Lexeme((byte) 0x46),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("hexadecimal");

        Token t8 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_F,
                        new Lexeme((byte) 0x46),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));
        t8.overKind("hexadecimal");

        Axis axis =
                new ParserAxis(new Tape(new Token[] {t0, t1, t2, t3, t4, t5, t6, t7, t8})).parse();
        assertInstanceOf(RangeHex.class, axis);
        assertEquals(0xEF, ((RangeHex) axis).min().raw());
        assertEquals(0xFF, ((RangeHex) axis).max().raw());
    }
}
