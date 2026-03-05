package guru.qa.country.controller.graphql;

import guru.qa.country.domain.graphql.CountryGql;
import guru.qa.country.domain.graphql.CountryInputGql;
import guru.qa.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor // Что бы не писать конструктор с @Autowired
public class CountryMutationController {

    private final CountryService countryService; // указываем какую бизнес-логику мы реализуем

    @MutationMapping
    public CountryGql addCountry(@Argument CountryInputGql input) {
        return CountryGql.fromDto(countryService.addCountry(CountryInputGql.toDto(input)));
    }

    @MutationMapping
    public CountryGql updateCountry(@Argument String code, @Argument CountryInputGql input) {
        return CountryGql.fromDto(countryService.updateCountry(code, CountryInputGql.toDto(input)));
    }

}
