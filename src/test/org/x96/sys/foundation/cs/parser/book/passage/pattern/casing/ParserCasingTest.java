package org.x96.sys.foundation.cs.parser.book.passage.pattern.casing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserCasingTest {

    @Test
    void happyUnitUnit() {
        Token t0 =
                new Token(
                        Kind.LEFT_CURLY_BRACKET,
                        new Lexeme((byte) 0x7B),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("LEFT_CURLY_BRACKET");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("glyph");

        Token t2 =
                new Token(
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("empty_space");

        Token t3 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("glyph");

        Token t4 =
                new Token(
                        Kind.RIGHT_CURLY_BRACKET,
                        new Lexeme((byte) 0x7D),
                        new Span(new Position(1, 4, 4), new Position(1, 5, 5)));
        t4.overKind("RIGHT_CURLY_BRACKET");

        Token[] t = new Token[] {t0, t1, t2, t3, t4};
        Casing casing = new ParserCasing(new Tape(t)).parse();
        assertFalse(casing.quantifier().isPresent());
        assertEquals(2, casing.cores().length);
        assertInstanceOf(Unit.class, casing.cores()[0]);
        assertInstanceOf(Unit.class, casing.cores()[1]);
    }
}
