package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.rangeHex;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.RangeHex;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.hexadecimal.ParserHexadecimal;

public class ParserRangeHex extends Parser implements Parsing<RangeHex> {
    public ParserRangeHex(Tape tape) {
        super(tape);
    }

    @Override
    public RangeHex parse() {
        Hexadecimal min = new ParserHexadecimal(tape).parse();
        consume("HYPHEN_MINUS");
        Hexadecimal max = new ParserHexadecimal(tape).parse();
        return new RangeHex(min, max);
    }
}
