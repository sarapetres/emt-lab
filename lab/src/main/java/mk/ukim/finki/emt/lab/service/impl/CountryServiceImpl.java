package mk.ukim.finki.emt.lab.service.impl;

import mk.ukim.finki.emt.lab.model.Country;
import mk.ukim.finki.emt.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.lab.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.lab.repository.CountryRepository;
import mk.ukim.finki.emt.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public Country findById(Long countryId) {
        return this.countryRepository.findById(countryId).orElseThrow(()-> new CountryNotFoundException(countryId));

    }

    @Override
    public Country save(String name,String continent) {
        return countryRepository.save(new Country(name,continent));
    }
}
