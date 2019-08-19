package com.codegym.formatter;

import com.codegym.model.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class StudentFormatter implements Formatter<Book> {
    private BookService bookService;
    @Autowired
    public StudentFormatter(BookService bookService) {
        this.bookService = bookService;
    }
    @Override
    public Book parse(String text, Locale locale) throws ParseException {
        return bookService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Book object, Locale locale) {
        return "["+ object.getId() + object.getNameBook()+"]";
    }
}
