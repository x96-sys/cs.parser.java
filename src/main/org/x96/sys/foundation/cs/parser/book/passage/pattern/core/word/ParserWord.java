package org.x96.sys.foundation.cs.parser.book.passage.pattern.core.word;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;

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
