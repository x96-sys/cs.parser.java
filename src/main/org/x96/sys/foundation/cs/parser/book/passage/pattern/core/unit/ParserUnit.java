package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit;

import org.x96.sys.foundation.cs.ast.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Inhibitor;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.glyph.ParserGlyph;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.inhibitor.ParserInhibitor;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.quantifier.ParserQuantifier;

import java.util.Optional;

public class ParserUnit extends Parser implements Parsing<Unit> {

    public ParserUnit(Tape tape) {
        super(tape);
    }

    @Override
    public Unit parse() {
        Optional<Inhibitor> inhibitor = Optional.empty();
        if (hasNext("inhibitor")) {
            inhibitor = Optional.of(new ParserInhibitor(this.tape).parse());
        }
        Glyph glyph = new ParserGlyph(this.tape).parse();
        Optional<Quantifier> quantifier = Optional.empty();
        if (hasNext("quantifier")) {
            quantifier = new ParserQuantifier(this.tape).parse();
        }
        return new Unit(inhibitor, glyph, quantifier);
    }
}
