package org.x96.sys.foundation.cs.parser.book.passage;

import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.glyph.ParserGlyph;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.pattern.ParserPattern;

import java.util.Optional;

public class ParserPassage extends Parser implements Parsing<Passage> {
    public ParserPassage(Tape tape) {
        super(tape);
    }

    @Override
    public Passage parse() {
        Glyph glyph = new ParserGlyph(tape).parse();
        skipES();
        consume("assignor");
        skipES();
        return new Passage(glyph, Optional.empty(), new ParserPattern(tape).parse());
    }
}
