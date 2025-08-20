package org.x96.sys.foundation.cs.parser.book.passage.pattern.casing;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.ParserCore;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.quantifier.ParserQuantifier;

import java.util.ArrayList;
import java.util.List;

public class ParserCasing extends Parser implements Parsing<Casing> {
    public ParserCasing(Tape tape) {
        super(tape);
    }

    @Override
    public Casing parse() {
        consume("LEFT_CURLY_BRACKET");
        skipES();
        List<Core> cores = new ArrayList<>();
        cores.add(new ParserCore(tape).parse());
        skipES();
        followCore(cores);
        skipES();
        consume("RIGHT_CURLY_BRACKET");
        return new Casing(cores.toArray(Core[]::new), new ParserQuantifier(tape).parse());
    }
}
