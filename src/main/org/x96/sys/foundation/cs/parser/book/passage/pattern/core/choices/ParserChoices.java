package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.choices;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.ParserCore;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.unit.quantifier.ParserQuantifier;

import java.util.ArrayList;
import java.util.List;

public class ParserChoices extends Parser implements Parsing<Choices> {
    public ParserChoices(Tape tape) {
        super(tape);
    }

    @Override
    public Choices parse() {
        List<Core> cores = new ArrayList<>();
        consume("LEFT_PARENTHESIS");
        skipES();
        cores.add(new ParserCore(tape).parse());
        skipES();
        follow(cores);
        consume("RIGHT_PARENTHESIS");
        skipES();
        return new Choices(cores.toArray(Core[]::new), new ParserQuantifier(tape).parse());
    }

    private void follow(List<Core> cores) {
        consume("VERTICAL_LINE");
        skipES();
        cores.add(new ParserCore(tape).parse());
        skipES();
        if (hasNext("VERTICAL_LINE")) {
            follow(cores);
        }
    }
}
