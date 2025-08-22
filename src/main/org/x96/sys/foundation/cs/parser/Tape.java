package org.x96.sys.foundation.cs.parser;

import org.x96.sys.foundation.cs.lexer.token.Token;

public class Tape {

    public final Token[] tokens;
    public int pointer;

    public Tape(Token[] tokens) {
        this.tokens = tokens;
        this.pointer = 0;
    }

    public Token current() {
        return this.tokens[this.pointer];
    }

    public boolean hasNext(String overKind) {
        if (this.pointer >= this.tokens.length) return false;
        return overKindIs(overKind);
    }

    public boolean overKindIs(String overKind) {
        if (current().overKind != null) {
            return y(overKind) || x(overKind);
        } else {
            return x(overKind);
        }
    }

    public Token consume(String overKind) {
        if (!overKindIs(overKind)) {
            String explain =
                    String.format(
                            "encontrado [%s] ao consumir [%s]",
                            current().overKind != null
                                    ? current().overKind
                                    : current().kind().toString(),
                            overKind);
            throw new RuntimeException(explain);
        } else {
            Token c = current();
            this.pointer += 1;
            return c;
        }
    }

    private boolean x(String overKind) {
        return current().kind().toString().toLowerCase().equals(overKind.toLowerCase());
    }

    private boolean y(String overKind) {
        return current().overKind.toLowerCase().equals(overKind.toLowerCase());
    }
}
