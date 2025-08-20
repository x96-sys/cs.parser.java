package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.rangeHex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.RangeHex;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserRangeHexTest {

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
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
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
        t5.overKind("hex");

        Token t6 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(1, 6, 6), new Position(1, 7, 7)));
        t6.overKind("hex");

        Token t7 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_F,
                        new Lexeme((byte) 0x46),
                        new Span(new Position(1, 7, 7), new Position(1, 8, 8)));
        t7.overKind("hex");

        Token t8 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_F,
                        new Lexeme((byte) 0x46),
                        new Span(new Position(1, 8, 8), new Position(1, 9, 9)));
        t8.overKind("hex");

        RangeHex parse =
                new ParserRangeHex(new Tape(new Token[] {t0, t1, t2, t3, t4, t5, t6, t7, t8}))
                        .parse();
        assertEquals(0xEF, parse.min().raw());
        assertEquals(0xFF, parse.max().raw());
    }
}
