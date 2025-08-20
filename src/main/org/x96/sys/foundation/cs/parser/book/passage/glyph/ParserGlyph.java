package org.x96.sys.foundation.cs.parser.book.passage.glyph;

import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;

import java.io.ByteArrayOutputStream;

public class ParserGlyph extends Parser implements Parsing<Glyph> {
    public ParserGlyph(Tape tape) {
        super(tape);
    }

    @Override
    public Glyph parse() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        do {
            baos.write(consume("glyph").lexeme().b());
        } while (hasNext("glyph"));
        return new Glyph(baos.toByteArray());
    }
}
