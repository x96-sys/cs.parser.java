package org.x96.sys.cs.parser.book.passage.pattern.modifier;

import org.x96.sys.cs.ast.book.passage.pattern.modifier.Modifier;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.modifier.ghost.ParserGhost;
import org.x96.sys.cs.parser.book.passage.pattern.modifier.shell.ParserShell;

import java.util.Optional;

public class ParserModifier extends Parser implements Parsing<Optional<Modifier>> {

    public ParserModifier(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Modifier> parse() {
        if (hasNext("shell")) {
            return Optional.of(new ParserShell(tape).parse());
        }

        if (hasNext("ghost")) {
            return Optional.of(new ParserGhost(tape).parse());
        }
        return Optional.empty();
    }
}
