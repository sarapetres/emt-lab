package mk.ukim.finki.emt.lab.service.impl;

import mk.ukim.finki.emt.lab.model.Country;
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
    public Optional<Country> findById(Long countryId) {
        return this.countryRepository.findById(countryId);
    }
    @Override
    public Country save(String name,String continent) {
        return countryRepository.save(new Country(name,continent));
    }
    @Override
    public List<Country> listAll(){
        return countryRepository.findAll();
    }
}