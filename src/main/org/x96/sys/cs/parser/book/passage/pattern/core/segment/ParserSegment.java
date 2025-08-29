package org.x96.sys.cs.parser.book.passage.pattern.core.segment;

import org.x96.sys.cs.ast.book.passage.pattern.core.Axis;
import org.x96.sys.cs.ast.book.passage.pattern.core.Segment;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.core.axis.ParserAxis;
import org.x96.sys.cs.parser.book.passage.pattern.core.unit.quantifier.ParserQuantifier;

import java.util.ArrayList;
import java.util.List;

public class ParserSegment extends Parser implements Parsing<Segment> {
    public ParserSegment(Tape tape) {
        super(tape);
    }

    private boolean follow() {
        if (hasNext("word")) return true;
        if (hasNext("hexadecimal")) return true;
        if (hasNext("glyph")) return true;
        if (hasNext("LEFT_SQUARE_BRACKET")) return true;
        if (hasNext("LEFT_PARENTHESIS")) return true;
        return hasNext("bang");
    }

    @Override
    public Segment parse() {
        consume("LEFT_SQUARE_BRACKET");
        skipES();
        List<Axis> axes = new ArrayList<>();
        do {
            axes.add(new ParserAxis(tape).parse());
            skipES();
        } while (follow());
        skipES();
        consume("RIGHT_SQUARE_BRACKET");
        skipES();
        return new Segment(axes.toArray(Axis[]::new), new ParserQuantifier(tape).parse());
    }
}
