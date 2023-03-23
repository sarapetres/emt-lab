package mk.ukim.finki.emt.lab.service.impl;

import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.enumerations.Category;
import mk.ukim.finki.emt.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.repository.BookRepository;
import mk.ukim.finki.emt.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(()-> new AuthorNotFoundException(authorId));
        return this.bookRepository.save(new Book(name,category,author,availableCopies));
    }

    @Override
    public Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));

        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(()-> new AuthorNotFoundException(authorId));

        book.setAuthor(author);
        return this.bookRepository.save(book);
    }

    @Override
    public Book deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        bookRepository.delete(book);
        return  book;
    }

    @Override
    public Book markAsTaken(Long id, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return bookRepository.save(book);
    }
}
