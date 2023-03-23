package mk.ukim.finki.emt.lab.service;

import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.enumerations.Category;

import java.util.List;

public interface BookService {

    Book findById(Long id);

    List<Book> listAll();

    Book save(String name, Category category, Long authorId, Integer availableCopies);

    Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Book deleteById(Long id);

    Book markAsTaken(Long id,Integer availableCopies);


}
