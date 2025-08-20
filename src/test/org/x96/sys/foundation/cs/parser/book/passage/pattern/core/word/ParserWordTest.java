package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.token.architecture.Lexeme;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Position;
import org.x96.sys.foundation.cs.lexer.token.architecture.span.Span;

class ParserWordTest {
    @Test
    void happy() {
        Token t0 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(0, 0, 0), new Position(1, 1, 1)));
        t0.overKind("q");

        Token t1 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_C,
                        new Lexeme((byte) 0x63),
                        new Span(new Position(1, 1, 1), new Position(1, 2, 2)));
        t1.overKind("word");

        Token t2 =
                new Token(
                        Kind.LATIN_SMALL_LETTER_S,
                        new Lexeme((byte) 0x73),
                        new Span(new Position(1, 2, 2), new Position(1, 3, 3)));
        t2.overKind("word");

        Token t3 =
                new Token(
                        Kind.APOSTROPHE,
                        new Lexeme((byte) 0x27),
                        new Span(new Position(1, 3, 3), new Position(1, 4, 4)));
        t3.overKind("q");

        Token[] tokens = new Token[] {t0, t1, t2, t3};
        Word word = new ParserWord(new Tape(tokens)).parse();
        assertEquals("cs", new String(word.raw()));
    }
}
