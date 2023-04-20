package mk.ukim.finki.emt.lab.service;


import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService  {

    Optional<Author> findById(Long id);

    Author save(String name, String surname, Long countryId);

    List<Author> listAll();
}