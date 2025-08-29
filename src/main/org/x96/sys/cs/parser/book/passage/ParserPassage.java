package org.x96.sys.cs.parser.book.passage;

import org.x96.sys.cs.ast.book.passage.Passage;
import org.x96.sys.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Modifier;
import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.glyph.ParserGlyph;
import org.x96.sys.cs.parser.book.passage.pattern.pattern.ParserPattern;
import org.x96.sys.lexer.token.Token;

import java.util.Optional;

public class ParserPassage extends Parser implements Parsing<Passage> {
    public ParserPassage(Tape tape) {
        super(tape);
    }

    @Override
    public Passage parse() {
        Glyph glyph = new ParserGlyph(tape).parse();
        skipES();
        consume("EQUALS");
        skipES();
        Optional<Modifier> mod = Optional.empty();
        if (hasNext("COMMERCIAL_AT")) {
            Token t = consume("COMMERCIAL_AT");
            mod = Optional.of(new Shell(t.lexeme().b()));
            skipES();
        }
        return new Passage(glyph, mod, new ParserPattern(tape).parse());
    }
}
