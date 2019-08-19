package com.codegym.formatter;

import com.codegym.model.Author;
import com.codegym.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PostFormatter implements Formatter<Author> {
    private AuthorService authorService;

    @Autowired
    public PostFormatter(AuthorService authorService){this.authorService = authorService;}

    @Override
    public Author parse(String text, Locale locale) throws ParseException {
        return authorService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Author object, Locale locale) {
        return "[" + object.getId() + object.getNameAuthor()+"]";
    }
}
