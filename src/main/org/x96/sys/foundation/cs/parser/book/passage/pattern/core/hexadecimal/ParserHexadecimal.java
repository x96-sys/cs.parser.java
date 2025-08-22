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
        // consome '0' e 'x' do prefixo
        consume("hexadecimal"); // '0'
        consume("hexadecimal"); // 'X'

        StringBuilder hexString = new StringBuilder();

        while (hasNext("hexadecimal")) {
            byte b = consume("hexadecimal").lexeme().b();
            char c = (char) b; // converte o byte ASCII para char
            hexString.append(c);
        }

        // converte a string hexadecimal para int
        int value = Integer.parseInt(hexString.toString(), 16);

        return new Hexadecimal(value);
    }
}
