package org.x96.sys.foundation.cs.parser.book.passage.pattern.core;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.choices.ParserChoices;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.hexadecimal.ParserHexadecimal;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.segment.ParserSegment;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.ParserUnit;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.word.ParserWord;

public class ParserCore extends Parser implements Parsing<Core> {
    public ParserCore(Tape tape) {
        super(tape);
    }

    @Override
    public Core parse() {
        if (hasNext("hexadecimal")) return new ParserHexadecimal(tape).parse();
        if (hasNext("q")) return new ParserWord(tape).parse();
        if (hasNext("glyph")) return new ParserUnit(tape).parse();
        if (hasNext("bang")) return new ParserUnit(tape).parse();
        if (hasNext("inhibitor")) return new ParserUnit(tape).parse();
        if (hasNext("LEFT_PARENTHESIS")) return new ParserChoices(tape).parse();
        if (hasNext("LEFT_SQUARE_BRACKET")) return new ParserSegment(tape).parse();

        System.out.println(kind());
        throw new RuntimeException("Core ainda não suporta " + this.tape.current().toString());
    }
}
