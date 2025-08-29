package org.x96.sys.cs.parser.passage.pattern.modifier.ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.modifier.ghost.ParserGhost;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.token.architecture.Lexeme;
import org.x96.sys.lexer.token.architecture.span.Position;
import org.x96.sys.lexer.token.architecture.span.Span;

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
