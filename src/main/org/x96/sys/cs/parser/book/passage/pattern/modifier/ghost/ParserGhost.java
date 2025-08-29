package org.x96.sys.cs.parser.book.passage.pattern.modifier.ghost;

import org.x96.sys.cs.ast.book.passage.pattern.modifier.Ghost;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;

public class ParserGhost extends Parser implements Parsing<Ghost> {

    public ParserGhost(Tape tape) {
        super(tape);
    }

    @Override
    public Ghost parse() {
        return new Ghost(consume("ghost").lexeme().b());
    }
}
