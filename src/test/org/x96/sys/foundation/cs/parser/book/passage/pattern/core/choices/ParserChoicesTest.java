package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.choices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

class ParserChoicesTest {
    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.LEFT_PARENTHESIS,
                        new Lexeme((byte) 0x28),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("LEFT_PARENTHESIS");

        Token t1 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("empty_space");

        Token t2 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("hexadecimal");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("hexadecimal");

        Token t4 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("hexadecimal");

        Token t5 =
                new Token(
                        Kind.DIGIT_ONE,
                        new Lexeme((byte) 0x31),
                        new Span(new Position(1, 5, 5), new Position(1, 6, 6)));
        t5.overKind("hexadecimal");

        Token t6 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("empty_space");

        Token t7 =
                new Token(
                        Kind.VERTICAL_LINE,
                        new Lexeme((byte) 0x7C),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("VERTICAL_LINE");

        Token t8 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));
        t8.overKind("empty_space");

        Token t9 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 9, 9), new Position(1, 10, 10)));
        t9.overKind("glyph");

        Token t10 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 10, 10), new Position(1, 11, 11)));
        t10.overKind("glyph");

        Token t11 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 11, 11), new Position(1, 12, 12)));
        t11.overKind("empty_space");

        Token t12 =
                new Token(
                        Kind.RIGHT_PARENTHESIS,
                        new Lexeme((byte) 0x29),
                        new Span(new Position(1, 12, 12), new Position(1, 13, 13)));
        t12.overKind("RIGHT_PARENTHESIS");

        Token t13 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 13, 13), new Position(1, 14, 14)));
        t13.overKind("empty_space");

        Token[] t = new Token[] {t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13};
        Choices c = new ParserChoices(new Tape(t)).parse();
        assertEquals(2, c.cores().length);
        assertFalse(c.quantifier().isPresent());

        assertInstanceOf(Hexadecimal.class, c.cores()[0]);
        Hexadecimal hex = (Hexadecimal) c.cores()[0];
        assertEquals(0x61, hex.raw());

        assertInstanceOf(Unit.class, c.cores()[1]);
        Unit unit = (Unit) c.cores()[1];
        assertFalse(unit.inhibitor().isPresent());
        assertEquals("sc", new String(unit.glyph().raw()));
    }
}
