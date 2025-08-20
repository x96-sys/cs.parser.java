package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserHexadecimalTest {

    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("hex");

        Token t1 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_X,
                        new Lexeme((byte) 0x58),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("hex");

        Token t2 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_E,
                        new Lexeme((byte) 0x45),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("hex");

        Token t3 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_F,
                        new Lexeme((byte) 0x46),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("hex");

        Token[] t = new Token[] {t0, t1, t2, t3};
        Hexadecimal parse = new ParserHexadecimal(new Tape(t)).parse();
        assertEquals(0xEF, parse.raw());
    }

    @Test
    void happyLow() {
        Token t0 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("hex");

        Token t1 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_X,
                        new Lexeme((byte) 0x58),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("hex");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_E,
                        new Lexeme((byte) 0x65),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("hex");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_F,
                        new Lexeme((byte) 0x66),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("hex");
        Token[] t = new Token[] {t0, t1, t2, t3};
        Hexadecimal parse = new ParserHexadecimal(new Tape(t)).parse();
        assertEquals(0xEF, parse.raw());
    }
}
