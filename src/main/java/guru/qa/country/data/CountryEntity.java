package guru.qa.country.data;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
// Можно сгенерировать геттеры и сеттеры + hashCode и equals или поставить эти аннотации lombok
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false,name = "name", unique = true)
    private String name;
}
