package guru.qa.country.controller.graphql;

import guru.qa.country.domain.graphql.CountryGql;
import guru.qa.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller// Тоже является Бином, т.к. в аннотации еще есть @Component
@RequiredArgsConstructor
public class CountryQueryController {

    private final CountryService countryService; // указываем какую бизнес-логику мы реализуем

    @QueryMapping  //соотносим по названию метода в файле query.graphqls в Query
    public List<CountryGql> countries() {
        return countryService.getAllCountries()
                .stream()
                .map(CountryGql::fromDto)
                .toList();
    }

}
