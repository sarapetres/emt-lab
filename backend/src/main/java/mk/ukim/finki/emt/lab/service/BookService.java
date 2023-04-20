package mk.ukim.finki.emt.lab.service;

import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> listAll();

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id,BookDto bookDto);

    void deleteById(Long id);

    Book markAsTaken(Long id, Integer availableCopies);


}