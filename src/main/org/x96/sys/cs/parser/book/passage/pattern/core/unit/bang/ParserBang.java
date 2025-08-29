package org.x96.sys.cs.parser.book.passage.pattern.core.unit.bang;

import org.x96.sys.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;

public class ParserBang extends Parser implements Parsing<Bang> {

    public ParserBang(Tape tape) {
        super(tape);
    }

    @Override
    public Bang parse() {
        if (hasNext("inhibitor")) {
            return new Bang(consume("inhibitor").lexeme().b());
        }
        return new Bang(consume("bang").lexeme().b());
    }
}
