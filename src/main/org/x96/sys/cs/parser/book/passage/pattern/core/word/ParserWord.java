package org.x96.sys.cs.parser.book.passage.pattern.core.word;

import org.x96.sys.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.parser.Parser;
import org.x96.sys.parser.Parsing;
import org.x96.sys.parser.Tape;

import java.io.ByteArrayOutputStream;

public class ParserWord extends Parser implements Parsing<Word> {

    public ParserWord(Tape tape) {
        super(tape);
    }

    @Override
    public Word parse() {
        consume("q");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        do {
            stream.write(consume("word").lexeme().b());
        } while (hasNext("word"));
        consume("q");
        return new Word(stream.toByteArray());
    }
}
