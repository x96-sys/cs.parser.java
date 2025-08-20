package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.quantifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

import java.util.Optional;

class ParserQuantifierTest {

    @Test
    void happyZeroOrMore() {
        Token t0 =
                new Token(
                        Kind.ASTERISK,
                        new Lexeme((byte) 0x2A),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("quantifier");

        Token[] tokens = new Token[] {t0};
        Optional<Quantifier> q = new ParserQuantifier(new Tape(tokens)).parse();
        assertTrue(q.isPresent());
        assertInstanceOf(ZeroOrMore.class, q.get());
        assertEquals(0x2A, q.get().b());
        assertEquals("*", q.get().decor());
    }

    @Test
    void happyOneOrMore() {
        Token t0 =
                new Token(
                        Kind.PLUS,
                        new Lexeme((byte) 0x2B),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("quantifier");

        Token[] tokens = new Token[] {t0};
        Optional<Quantifier> q = new ParserQuantifier(new Tape(tokens)).parse();
        assertTrue(q.isPresent());
        assertInstanceOf(OneOrMore.class, q.get());
        assertEquals(0x2B, q.get().b());
        assertEquals("+", q.get().decor());
    }

    @Test
    void happyZeroOrOne() {
        Token t0 =
                new Token(
                        Kind.QUESTION_MARK,
                        new Lexeme((byte) 0x3F),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("quantifier");

        Token[] tokens = new Token[] {t0};
        Optional<Quantifier> q = new ParserQuantifier(new Tape(tokens)).parse();
        assertTrue(q.isPresent());
        assertInstanceOf(ZeroOrOne.class, q.get());
        assertEquals(0x3F, q.get().b());
        assertEquals("?", q.get().decor());
    }
}
