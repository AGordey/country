package guru.qa.country.domain.graphql;

import guru.qa.country.domain.rest.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CountryInputGql {

    private String code;

    private String name;

    public static CountryDto toDto(CountryInputGql country) {
        return new CountryDto(country.getCode(),country.getName());
    }

}
