package org.x96.sys.foundation.cs.parser.book.passage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.Book;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.ParserBook;

class ParserBookTest {
    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.STX,
                        new Lexeme((byte) 0x2),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        // t0.overKind("open_book");

        Token t1 =
                new Token(
                        Kind.LF,
                        new Lexeme((byte) 0xA),
                        new Span(new Position(1, 1, 1), new Position(2, 1, 2)));
        t1.overKind("empty_space");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(2, 1, 2), new Position(2, 2, 3)));
        t2.overKind("glyph");

        Token t3 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(2, 2, 3), new Position(2, 3, 4)));
        t3.overKind("empty_space");

        Token t4 =
                new Token(
                        Kind.EQUALS,
                        new Lexeme((byte) 0x3D),
                        new Span(new Position(2, 3, 4), new Position(2, 4, 5)));
        t4.overKind("assignor");

        Token t5 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(2, 4, 5), new Position(2, 5, 6)));
        t5.overKind("empty_space");

        Token t6 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(2, 5, 6), new Position(2, 6, 7)));
        t6.overKind("hexadecimal");

        Token t7 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(2, 6, 7), new Position(2, 7, 8)));
        t7.overKind("hexadecimal");

        Token t8 =
                new Token(
                        Kind.DIGIT_SIX,
                        new Lexeme((byte) 0x36),
                        new Span(new Position(2, 7, 8), new Position(2, 8, 9)));
        t8.overKind("hexadecimal");

        Token t9 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(2, 8, 9), new Position(2, 9, 10)));
        t9.overKind("hexadecimal");

        Token t10 =
                new Token(
                        Kind.SEMICOLON,
                        new Lexeme((byte) 0x3B),
                        new Span(new Position(2, 9, 10), new Position(2, 10, 11)));
        t10.overKind("SEMICOLON");

        Token t11 =
                new Token(
                        Kind.LF,
                        new Lexeme((byte) 0xA),
                        new Span(new Position(2, 10, 11), new Position(3, 1, 12)));
        t11.overKind("empty_space");

        Token t12 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(3, 1, 12), new Position(3, 2, 13)));
        t12.overKind("glyph");

        Token t13 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(3, 2, 13), new Position(3, 3, 14)));
        t13.overKind("empty_space");

        Token t14 =
                new Token(
                        Kind.EQUALS,
                        new Lexeme((byte) 0x3D),
                        new Span(new Position(3, 3, 14), new Position(3, 4, 15)));
        t14.overKind("assignor");

        Token t15 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(3, 4, 15), new Position(3, 5, 16)));
        t15.overKind("empty_space");

        Token t16 =
                new Token(
                        Kind.LEFT_CURLY_BRACKET,
                        new Lexeme((byte) 0x7B),
                        new Span(new Position(3, 5, 16), new Position(3, 6, 17)));
        t16.overKind("LEFT_CURLY_BRACKET");

        Token t17 =
                new Token(
                        Kind.DIGIT_ZERO,
                        new Lexeme((byte) 0x30),
                        new Span(new Position(3, 6, 17), new Position(3, 7, 18)));
        t17.overKind("hexadecimal");

        Token t18 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_X,
                        new Lexeme((byte) 0x78),
                        new Span(new Position(3, 7, 18), new Position(3, 8, 19)));
        t18.overKind("hexadecimal");

        Token t19 =
                new Token(
                        Kind.DIGIT_SEVEN,
                        new Lexeme((byte) 0x37),
                        new Span(new Position(3, 8, 19), new Position(3, 9, 20)));
        t19.overKind("hexadecimal");

        Token t20 =
                new Token(
                        Kind.DIGIT_THREE,
                        new Lexeme((byte) 0x33),
                        new Span(new Position(3, 9, 20), new Position(3, 10, 21)));
        t20.overKind("hexadecimal");

        Token t21 =
                new Token(
                        Kind.RIGHT_CURLY_BRACKET,
                        new Lexeme((byte) 0x7D),
                        new Span(new Position(3, 10, 21), new Position(3, 11, 22)));

        Token t22 =
                new Token(
                        Kind.LF,
                        new Lexeme((byte) 0xA),
                        new Span(new Position(3, 11, 22), new Position(4, 1, 23)));
        t22.overKind("empty_space");

        Token t23 =
                new Token(
                        Kind.ETX,
                        new Lexeme((byte) 0x3),
                        new Span(new Position(4, 1, 23), new Position(4, 2, 24)));

        Token[] t =
                new Token[] {
                    t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17,
                    t18, t19, t20, t21, t22, t23
                };

        Book book = new ParserBook(new Tape(t)).parse();
        assertEquals(2, book.passages().length);
        Passage passage = book.passages()[0];
        assertEquals("c", new String(passage.glyph().raw()));
        assertInstanceOf(Lineage.class, passage.pattern());

        passage = book.passages()[1];
        assertEquals("s", new String(passage.glyph().raw()));
        assertInstanceOf(Casing.class, passage.pattern());
    }
}
