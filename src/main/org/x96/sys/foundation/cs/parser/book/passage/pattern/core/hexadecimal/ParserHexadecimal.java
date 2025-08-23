package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.hexadecimal;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Hexadecimal;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;

public class ParserHexadecimal extends Parser implements Parsing<Hexadecimal> {

    public ParserHexadecimal(Tape tape) {
        super(tape);
    }

    @Override
    public Hexadecimal parse() {
        StringBuilder hexString = new StringBuilder();
        consume("hexadecimal"); // '0'
        consume("hexadecimal"); // ('X' | 'x')

        while (hasNext("hexadecimal")) {
            byte b = consume("hexadecimal").lexeme().b();
            hexString.append((char) b);
        }

        return new Hexadecimal(Integer.parseInt(hexString.toString(), 16));
    }
}
