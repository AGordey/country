package guru.qa.country.domain.graphql;

import guru.qa.country.domain.rest.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CountryGql {

    private String code;

    private String name;

    public static CountryGql fromDto(CountryDto countryDTO){
        return new CountryGql(countryDTO.getCode(), countryDTO.getName());
    }
}
