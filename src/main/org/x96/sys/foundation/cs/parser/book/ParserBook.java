package org.x96.sys.foundation.cs.parser.book;

import org.x96.sys.foundation.cs.ast.book.Book;
import org.x96.sys.foundation.cs.ast.book.passage.Passage;
import org.x96.sys.foundation.cs.parser.Parser;
import org.x96.sys.foundation.cs.parser.Parsing;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.passage.ParserPassage;

import java.util.ArrayList;
import java.util.List;

public class ParserBook extends Parser implements Parsing<Book> {
    public ParserBook(Tape tape) {
        super(tape);
    }

    @Override
    public Book parse() {
        consume("open_book");
        skipES();
        List<Passage> passages = new ArrayList<>();
        followPassage(passages);
        consume("close_book");
        return new Book(passages.toArray(Passage[]::new));
    }

    private void followPassage(List<Passage> passages) {
        if (hasNext("glyph")) {
            passages.add(new ParserPassage(tape).parse());
            skipES();
            followPassage(passages);
        }
    }
}
