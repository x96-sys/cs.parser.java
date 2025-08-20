package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.axis;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Axis;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.choices.ParserChoices;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.rangeHex.ParserRangeHex;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.segment.ParserSegment;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.ParserUnit;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.word.ParserWord;

public class ParserAxis extends Parser implements Parsing<Axis> {
    public ParserAxis(Tape tape) {
        super(tape);
    }

    @Override
    public Axis parse() {
        if (hasNext("q")) return new ParserWord(tape).parse();
        if (hasNext("hex")) return new ParserRangeHex(tape).parse();
        if (hasNext("glyph")) return new ParserUnit(tape).parse();
        if (hasNext("inhibitor")) return new ParserUnit(tape).parse();
        if (hasNext("LEFT_PARENTHESIS")) return new ParserChoices(tape).parse();
        if (hasNext("LEFT_SQUARE_BRACKET")) return new ParserSegment(tape).parse();

        System.out.println(kind());
        throw new RuntimeException();
    }
}
