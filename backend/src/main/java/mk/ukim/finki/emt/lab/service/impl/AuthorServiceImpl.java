package mk.ukim.finki.emt.lab.service.impl;


import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Country;
import mk.ukim.finki.emt.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.repository.CountryRepository;
import mk.ukim.finki.emt.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public Author save(String name, String surname,Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(()-> new CountryNotFoundException(countryId));
        return this.authorRepository.save( new Author(name,surname,country));
    }
    @Override
    public List<Author> listAll(){
        return authorRepository.findAll();
    }
}