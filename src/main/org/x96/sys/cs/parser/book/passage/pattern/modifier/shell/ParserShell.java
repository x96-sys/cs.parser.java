package org.x96.sys.cs.parser.book.passage.pattern.modifier.shell;

import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;

public class ParserShell extends Parser implements Parsing<Shell> {

    public ParserShell(Tape tape) {
        super(tape);
    }

    @Override
    public Shell parse() {
        return new Shell(consume("shell").lexeme().b());
    }
}
