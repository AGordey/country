package guru.qa.country.controller;

import guru.qa.country.controller.dto.CountryDto;
import guru.qa.country.domain.Country;
import guru.qa.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Тоже является Бином, т.к. в аннотации еще есть @Component
@RequestMapping("api/country") //Указываем базовый адрес
public class CountryController {

    private final CountryService countryService; // указываем какую бизнес-логику мы реализуем

    @Autowired //Для извлечения экземпляра из CountryService из ApplicationContext
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("all")  //Конечный эндпоинт
    public List<CountryDto> all() {
        return countryService.getAllCountries();
    }

    @PostMapping("add")
    public ResponseEntity<CountryDto> addCountry(@Validated @RequestBody CountryDto country){
        CountryDto newCountry = countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
    }

    @PatchMapping("update/{code}")
    public ResponseEntity<CountryDto> updateCountry(@PathVariable String code,
                                                    @RequestBody CountryDto country) {
        CountryDto updateCountry = countryService.updateCountry(code, country);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCountry);
    }


}
