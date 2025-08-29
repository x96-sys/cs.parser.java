package org.x96.sys.cs.parser.book.passage.pattern.pattern;

import org.x96.sys.cs.ast.book.passage.pattern.Pattern;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.casing.ParserCasing;
import org.x96.sys.cs.parser.book.passage.pattern.lineage.ParserLineage;

public class ParserPattern extends Parser implements Parsing<Pattern> {
    public ParserPattern(Tape tape) {
        super(tape);
    }

    @Override
    public Pattern parse() {
        if (hasNext("LEFT_CURLY_BRACKET")) {
            return new ParserCasing(tape).parse();
        }

        return new ParserLineage(tape).parse();
    }
}
