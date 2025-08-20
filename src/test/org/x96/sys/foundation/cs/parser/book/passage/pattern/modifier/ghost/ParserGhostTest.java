package org.x96.sys.foundation.cs.parser.book.passage.pattern.modifier.ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserGhostTest {
    @Test
    void happyGhost() {
        byte raw = 0x5F;
        Token t =
                new Token(
                        Kind.LOW_LINE,
                        new Lexeme(raw),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t.overKind("ghost");

        Token[] tokens = new Token[] {t};
        Ghost ghost = new ParserGhost(new Tape(tokens)).parse();
        assertEquals(raw, ghost.raw());
    }
}
