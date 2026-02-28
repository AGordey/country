package guru.qa.country.domain;


//Создаем POJO класс/доменный класс/Data класс - не являются Bean с бизнес логикой.
//Bean с бизнес логикой это интерфейс в service. Здесь /service/CountryService.java
public record Country(String code,
                      String name) {
}
