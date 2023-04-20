package mk.ukim.finki.emt.lab.service;

import mk.ukim.finki.emt.lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {


    Optional<Country> findById(Long id);

    Country save(String name,String continent);
    List<Country> listAll();
}