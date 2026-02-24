package guru.qa.country.service.impl;

import guru.qa.country.controller.dto.CountryDto;
import guru.qa.country.data.CountryEntity;
import guru.qa.country.data.CountryRepository;
import guru.qa.country.service.CountryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
// значит что создан Bean? который пойдет в ApplicationContext и можем достать с помощью @Autowired используя его тип DBCountryService
//Аннотация считывает автоматом изза @SpringBootApplication и пойдет в ApplicationContext
//Применяем в CountryController
public class DBCountryService implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public DBCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(fe -> {
                    return new CountryDto(
                            fe.getCode(),
                            fe.getFullName()
                    );
                }).toList();
    }

    @Override
    public CountryDto addCountry(CountryDto country) {

        Optional<CountryEntity> foundEntity = countryRepository.findByCode(country.getCode());

        if (foundEntity.isPresent()) {
            throw new EntityNotFoundException("Country with code %s already exists".formatted(country.getCode()));
        }
        CountryEntity newEntity = CountryEntity.builder()
                .code(country.getCode())
                .fullName(country.getName())
                .build();

        countryRepository.save(newEntity);
        return CountryDto.fromEntity(newEntity);
    }

    @Override
    public CountryDto updateCountry(String code, CountryDto country) {
        Optional<CountryEntity> foundEntity = countryRepository.findByCode(code);
        if (foundEntity.isEmpty()) {
            throw new EntityNotFoundException("Country with code %s not exists in DB".formatted(code));
        }

        CountryEntity updatedEntity = foundEntity.get();
        updatedEntity.setCode(country.getCode());
        updatedEntity.setFullName(country.getName());
        return CountryDto.fromEntity(countryRepository.save(updatedEntity));
    }
}
