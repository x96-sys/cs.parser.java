package org.x96.sys.cs.parser.book.passage.pattern.core.unit.quantifier;

import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;
import org.x96.sys.lexer.token.Token;

import java.util.Optional;

public class ParserQuantifier extends Parser implements Parsing<Optional<Quantifier>> {

    public ParserQuantifier(Tape tape) {
        super(tape);
    }

    @Override
    public Optional<Quantifier> parse() {
        if (!hasNext("quantifier")) {
            return Optional.empty();
        }

        Token token = consume("quantifier");
        return switch (token.lexeme().b()) {
            case 0x2A -> Optional.of(new ZeroOrMore(token.lexeme().b()));
            case 0x3F -> Optional.of(new ZeroOrOne(token.lexeme().b()));
            case 0x2B -> Optional.of(new OneOrMore(token.lexeme().b()));
            default -> Optional.empty();
        };
    }
}
