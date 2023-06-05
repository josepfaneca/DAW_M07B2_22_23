package cat.xtec.ioc.domain.repository;

import cat.xtec.ioc.domain.Year;
import java.util.List;

public interface YearRepository {
    List<Year> getAll();     
    Year getByYear(int year);
    void add(Year year);
    void update(Year year);
    void delete(int year);
}
