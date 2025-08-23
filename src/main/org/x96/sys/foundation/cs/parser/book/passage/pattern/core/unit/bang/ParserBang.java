package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.bang;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Bang;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;

public class ParserBang extends Parser implements Parsing<Bang> {

    public ParserBang(Tape tape) {
        super(tape);
    }

    @Override
    public Bang parse() {
        return new Bang(consume("bang").lexeme().b());
    }
}
