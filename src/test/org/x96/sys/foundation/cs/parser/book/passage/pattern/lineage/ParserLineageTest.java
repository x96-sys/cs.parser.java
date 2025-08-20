package org.x96.sys.foundation.cs.parser.book.passage.pattern.lineage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserLineageTest {

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
                        Kind.SPACE,
                        new Lexeme((byte) 0x20),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("empty_space");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("glyph");

        Token t3 =
                new Token(
                        Kind.SEMICOLON,
                        new Lexeme((byte) 0x3B),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("SEMICOLON");

        Token[] t = new Token[] {t0, t1, t2, t3};
        Lineage lineage = new ParserLineage(new Tape(t)).parse();
        assertEquals(2, lineage.cores().length);
        assertInstanceOf(Unit.class, lineage.cores()[0]);
        assertInstanceOf(Unit.class, lineage.cores()[1]);
    }
}
