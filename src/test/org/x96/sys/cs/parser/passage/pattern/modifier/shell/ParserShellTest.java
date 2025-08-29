package org.x96.sys.cs.parser.passage.pattern.modifier.shell;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.modifier.shell.ParserShell;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.token.architecture.Lexeme;
import org.x96.sys.lexer.token.architecture.span.Position;
import org.x96.sys.lexer.token.architecture.span.Span;

class ParserShellTest {
    @Test
    void happyShell() {
        byte raw = 0x40;
        Token t =
                new Token(
                        Kind.COMMERCIAL_AT,
                        new Lexeme(raw),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t.overKind("shell");

        Token[] tokens = new Token[] {t};
        Shell shell = new ParserShell(new Tape(tokens)).parse();
        assertEquals(raw, shell.raw());
    }
}
