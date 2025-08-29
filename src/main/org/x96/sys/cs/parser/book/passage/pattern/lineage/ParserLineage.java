package org.x96.sys.cs.parser.book.passage.pattern.lineage;

import org.x96.sys.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.cs.parser.book.passage.pattern.core.ParserCore;

import java.util.ArrayList;
import java.util.List;

public class ParserLineage extends Parser implements Parsing<Lineage> {
    public ParserLineage(Tape tape) {
        super(tape);
    }

    @Override
    public Lineage parse() {
        List<Core> cores = new ArrayList<>();
        cores.add(new ParserCore(tape).parse());
        skipES();
        followCore(cores);
        skipES();
        consume("SEMICOLON");
        return new Lineage(cores.toArray(Core[]::new));
    }
}
