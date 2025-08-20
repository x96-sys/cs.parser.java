package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.inhibitor;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.unit.Inhibitor;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;

public class ParserInhibitor extends Parser implements Parsing<Inhibitor> {

    public ParserInhibitor(Tape tape) {
        super(tape);
    }

    @Override
    public Inhibitor parse() {
        return new Inhibitor(consume("inhibitor").lexeme().b());
    }
}
