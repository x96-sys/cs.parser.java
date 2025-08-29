package org.x96.sys.cs.parser.passage.pattern.core.unit.bang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.core.unit.bang.ParserBang;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.token.architecture.Lexeme;
import org.x96.sys.lexer.token.architecture.span.Position;
import org.x96.sys.lexer.token.architecture.span.Span;

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
