package org.x96.sys.foundation.cs.parser.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Modifier;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

import java.util.Optional;

class ParserModifierTest {
    @Test
    void happyShell() {
        Token t =
                new Token(
                        Kind.COMMERCIAL_AT,
                        new Lexeme((byte) 0x40),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t.overKind("shell");

        Token[] tokens = new Token[] {t};
        Optional<Modifier> parsed = new ParserModifier(new Tape(tokens)).parse();
        assertTrue(parsed.isPresent());
        assertInstanceOf(Shell.class, parsed.get());
    }

    @Test
    void happyGhost() {
        Token t =
                new Token(
                        Kind.LOW_LINE,
                        new Lexeme((byte) 0x5F),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t.overKind("ghost");

        Token[] tokens = new Token[] {t};
        Optional<Modifier> parsed = new ParserModifier(new Tape(tokens)).parse();
        assertTrue(parsed.isPresent());
        assertInstanceOf(Ghost.class, parsed.get());
    }
}
