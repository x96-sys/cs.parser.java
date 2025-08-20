package org.x96.sys.foundation.cs.parser;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Core;
import org.x96.sys.foundation.cs.parser.book.passage.pattern.core.ParserCore;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

import java.util.List;

public abstract class Parser {
    public final Tape tape;

    public Parser(Tape tape) {
        this.tape = tape;
    }

    public boolean hasNext(String s) {
        return this.tape.hasNext(s);
    }

    public Kind kind() {
        return this.tape.current().kind();
    }

    public Token consume(String s) {
        return this.tape.consume(s);
    }

    public void skipES() {
        for (String s : new String[] {"empty_space", "SPACE", "doc"}) {
            if (hasNext(s)) {
                consume(s);
                skipES();
                return;
            }
        }
    }

    public boolean hasNextCore() {
        if (hasNext("hex")) return true;
        if (hasNext("q")) return true;
        if (hasNext("glyph")) return true;
        if (hasNext("inhibitor")) return true;
        if (hasNext("LEFT_PARENTHESIS")) return true;
        return hasNext("LEFT_SQUARE_BRACKET");
    }

    public void followCore(List<Core> cores) {
        if (hasNextCore()) {
            cores.add(new ParserCore(tape).parse());
            skipES();
            followCore(cores);
        }
    }
}
