package org.x96.sys.foundation.cs.parser.book.passage.pattern.modifier.ghost;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;

public class ParserGhost extends Parser implements Parsing<Ghost> {

    public ParserGhost(Tape tape) {
        super(tape);
    }

    @Override
    public Ghost parse() {
        return new Ghost(consume("ghost").lexeme().b());
    }
}
