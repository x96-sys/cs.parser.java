package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.bang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;
import org.x96.sys.foundation.cs.parser.Tape;

class ParserBangTest {

    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.EXCLAMATION_MARK,
                        new Lexeme((byte) 0x21),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("bang");
        Bang bang = new ParserBang(new Tape(new Token[] {t0})).parse();
        assertEquals(0x21, bang.raw());
    }
}
