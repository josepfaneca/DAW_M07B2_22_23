package cat.xtec.ioc.domain.repository;

import cat.xtec.ioc.domain.Year;
import java.util.List;

public interface YearRepository {

    List<Year> getAll();

    Year getOneYear(Integer year);

    void add(Year year);

    void update(Year year); //(modifica qualsevol dels valors de població, però no l'any)

    void delete(int ano); //(no li passem l'objecte, sinó el valor que representa l'any)

}
