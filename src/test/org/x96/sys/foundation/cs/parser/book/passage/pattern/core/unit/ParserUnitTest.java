package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

class ParserUnitTest {
    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.EXCLAMATION_MARK,
                        new Lexeme((byte) 0x21),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("bang");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("glyph");

        Token t2 =
                new Token(
                        Kind.QUESTION_MARK,
                        new Lexeme((byte) 0x3F),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("quantifier");
        Unit unit = new ParserUnit(new Tape(new Token[] {t0, t1, t2})).parse();
        assertEquals("c", new String(unit.glyph().raw()));
        assertTrue(unit.bang().isPresent());
        assertEquals(0x21, unit.bang().get().raw());
        assertTrue(unit.quantifier().isPresent());
    }
}
