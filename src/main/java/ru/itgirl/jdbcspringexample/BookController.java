package ru.itgirl.jdbcspringexample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    @GetMapping("/book/id")
    public Book findBook(@RequestParam(value = "id", defaultValue = "World") int id) {
        Book searchedBook = new Book();
        for (Book book : bookRepository.findAllBooks()) {
            if (book.getId() == id) {
                searchedBook = book;
            }
        }
        return searchedBook;
    }
}
