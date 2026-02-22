package guru.qa.country.service.impl;

import guru.qa.country.controller.dto.CountryDto;
import guru.qa.country.domain.Country;
import guru.qa.country.service.CountryService;

import java.util.List;

//@Component  // значит что создан Bean, который пойдет в ApplicationContext и можем достать с помощью @Autowired используя его тип InMemoryCountryService
public class InMemoryCountryService implements CountryService {
    @Override
    public List<Country> getAllCountries() {
        return List.of(
                new Country(
                        "BY", "Belarus"),
                new Country(
                        "NoBY", "Ne Belarus")

        );
    }

    @Override
    public CountryDto addCountry(CountryDto country) {
        return null;
    }

    @Override
    public CountryDto updateCountry(String code, CountryDto country) {
        return null;
    }
}
