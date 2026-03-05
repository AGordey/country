package guru.qa.country.controller;

import guru.qa.country.domain.rest.CountryDto;
import guru.qa.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController// Тоже является Бином, т.к. в аннотации еще есть @Component
@RequiredArgsConstructor
@RequestMapping("api/country") //Указываем базовый адрес
public class CountryController {

    private final CountryService countryService; // указываем какую бизнес-логику мы реализуем

    @GetMapping("all")  //Конечный эндпоинт
    public List<CountryDto> all() {
        return countryService.getAllCountries();
    }

    @PostMapping("add")
    public ResponseEntity<CountryDto> addCountry(@Validated @RequestBody CountryDto country) {
        CountryDto newCountry = countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
    }

    @PatchMapping("update/{code}")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable String code,
                                                    @RequestBody CountryDto country) {
        CountryDto updateCountry = countryService.updateCountry(code, country);
        return ResponseEntity.status(HttpStatus.OK).body(updateCountry);
    }

}
