package org.x96.sys.foundation.cs.parser.book.passage.glyph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserGlyphTest {

    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("glyph");

        Token t1 =
                new Token(
                        Kind.LOW_LINE,
                        new Lexeme((byte) 0x5F),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("glyph");

        Token t2 =
                new Token(
                        Kind.LATIN_CAPITAL_LETTER_S,
                        new Lexeme((byte) 0x53),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("glyph");

        Token[] t = new Token[] {t0, t1, t2};
        Glyph glyph = new ParserGlyph(new Tape(t)).parse();
        assertEquals("c_S", new String(glyph.raw()));
    }
}
