package org.x96.sys.foundation.cs.parser.book.passage.pattern.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.*;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

class ParserCoreTest {
    @Test
    void happyHexadecimal() {
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
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("hexadecimal");

        Token t3 =
                new Token(
                        Kind.DIGIT_ONE,
                        new Lexeme((byte) 0x31),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("hexadecimal");

        Core core = new ParserCore(new Tape(new Token[] {t0, t1, t2, t3})).parse();
        assertInstanceOf(Hexadecimal.class, core);
        Hexadecimal hex = (Hexadecimal) core;
        assertEquals(0xc1, hex.raw());
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
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
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
                        Kind.LATIN_SMALL_LETTER_F,
                        new Lexeme((byte) 0x66),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("word");

        Token t4 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("word");

        Token t5 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("q");

        Token[] t = new Token[] {t0, t1, t2, t3, t4, t5};
        Core core = new ParserCore(new Tape(t)).parse();
        assertInstanceOf(Word.class, core);
        Word word = (Word) core;
        assertEquals("sofi", new String(word.raw()));
    }

    @Test
    void happyUnitWithInhibitor() {
        Token t0 =
                new Token(
                        Kind.EXCLAMATION_MARK,
                        new Lexeme((byte) 0x21),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("inhibitor");

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

        Core core = new ParserCore(new Tape(new Token[] {t0, t1, t2, t3, t4, t5})).parse();
        assertInstanceOf(Unit.class, core);
        Unit unit = (Unit) core;
        assertTrue(unit.inhibitor().isPresent());
        assertEquals("book", new String(unit.glyph().raw()));
        assertTrue(unit.quantifier().isPresent());
        assertInstanceOf(ZeroOrOne.class, unit.quantifier().get());
    }

    @Test
    void happyUnit() {
        Token t0 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("glyph");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_O,
                        new Lexeme((byte) 0x6F),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("glyph");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_F,
                        new Lexeme((byte) 0x66),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("glyph");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_I,
                        new Lexeme((byte) 0x69),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("glyph");

        Token t4 =
                new Token(
                        Kind.PLUS,
                        new Lexeme((byte) 0x2B),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("quantifier");

        Core core = new ParserCore(new Tape(new Token[] {t0, t1, t2, t3, t4})).parse();
        assertInstanceOf(Unit.class, core);
        Unit unit = (Unit) core;
        assertFalse(unit.inhibitor().isPresent());
        assertEquals("sofi", new String(unit.glyph().raw()));
        assertTrue(unit.quantifier().isPresent());
        assertInstanceOf(OneOrMore.class, unit.quantifier().get());
    }
}
