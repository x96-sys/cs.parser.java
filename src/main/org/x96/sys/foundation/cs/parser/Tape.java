package org.x96.sys.foundation.cs.parser;

import org.x96.sys.foundation.cs.lexer.token.Token;

public class Tape {

    private final Token[] tokens;
    private int pointer;

    public Tape(Token[] tokens) {
        this.tokens = tokens;
        this.pointer = 0;
    }

    public Token current() {
        if (pointer >= tokens.length) {
            throw new IllegalStateException("Pointer está fora dos limites: " + pointer);
        }
        return tokens[pointer];
    }

    public boolean hasNext(String expectedKind) {
        return pointer < tokens.length && matches(expectedKind);
    }

    public boolean matches(String expectedKind) {
        Token token = current();
        boolean b = token.kind().toString().equalsIgnoreCase(expectedKind);
        if (token.overKind != null) {
            return token.overKind.equalsIgnoreCase(expectedKind) || b;
        }
        return b;
    }

    public Token consume(String expectedKind) {
        if (!matches(expectedKind)) {
            String found =
                    current().overKind != null ? current().overKind : current().kind().toString();

            throw new IllegalStateException(
                    String.format(
                            "Token inválido: encontrado [%s], esperado [%s]", found, expectedKind));
        }
        return tokens[pointer++];
    }
}
