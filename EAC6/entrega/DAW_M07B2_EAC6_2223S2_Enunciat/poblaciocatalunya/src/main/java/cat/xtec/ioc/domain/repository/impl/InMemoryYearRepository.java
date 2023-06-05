package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Year;
import cat.xtec.ioc.domain.repository.YearRepository;
import cat.xtec.ioc.utils.Utilitats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryYearRepository implements YearRepository {

    private List<Year> years = new ArrayList<Year>();

    public InMemoryYearRepository() {
        //TODO
        //years.add(new Year(2000, 7000000, 3400000, 3600000));
        //years.add(new Year(2001, 7100000, 3400000, 3700000));
        this.years = Utilitats.listaYearsFromCsv("dades.csv", ";");
        Collections.sort(this.years); //ordenar per any per a construir bé la x de la gràfica
    }

    @Override
    public List<Year> getAll() {
        return this.years;
    }

    @Override
    public Year getOneYear(Integer findyear) {
        for (Year year : this.years) {
            if (year.getYear() == findyear) {
                return year;
            }
        }
        return null;
    }

    @Override
    public void add(Year year) {
        this.years.add(year);
    }

    @Override
    public void update(Year year) {
        Year yearUpdate = getOneYear(year.getYear());
        if (yearUpdate != null) {
            yearUpdate.setDones(year.getDones());
            yearUpdate.setHomes(year.getHomes());
            yearUpdate.setTotal(year.getTotal());
        }
    }

    @Override
    public void delete(int ano) {
        Year year = getOneYear(ano);
        if (year != null) {
            this.years.remove(year);
        }
    }

}
