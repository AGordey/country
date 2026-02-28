package guru.qa.country.controller.dto;

import guru.qa.country.data.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CountryDto {

    private String code;

    private String name;

    public static CountryDto fromEntity(CountryEntity entity) {
        return CountryDto.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }
}
