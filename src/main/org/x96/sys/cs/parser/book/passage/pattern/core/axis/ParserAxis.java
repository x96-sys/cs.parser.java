package org.x96.sys.cs.parser.book.passage.pattern.core.axis;

import org.x96.sys.cs.ast.book.passage.pattern.core.Axis;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.core.choices.ParserChoices;
import org.x96.sys.cs.parser.book.passage.pattern.core.rangeHex.ParserRangeHex;
import org.x96.sys.cs.parser.book.passage.pattern.core.segment.ParserSegment;
import org.x96.sys.cs.parser.book.passage.pattern.core.unit.ParserUnit;
import org.x96.sys.cs.parser.book.passage.pattern.core.word.ParserWord;

public class ParserAxis extends Parser implements Parsing<Axis> {
    public ParserAxis(Tape tape) {
        super(tape);
    }

    @Override
    public Axis parse() {
        if (hasNext("q")) return new ParserWord(tape).parse();
        if (hasNext("hexadecimal")) return new ParserRangeHex(tape).parse();
        if (hasNext("glyph")) return new ParserUnit(tape).parse();
        if (hasNext("bang")) return new ParserUnit(tape).parse();
        if (hasNext("LEFT_PARENTHESIS")) return new ParserChoices(tape).parse();
        if (hasNext("LEFT_SQUARE_BRACKET")) return new ParserSegment(tape).parse();

        System.out.println(tape.current().toString());
        throw new RuntimeException();
    }
}
