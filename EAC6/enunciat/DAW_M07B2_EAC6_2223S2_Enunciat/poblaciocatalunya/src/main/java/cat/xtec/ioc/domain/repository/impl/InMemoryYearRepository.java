package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Year;
import cat.xtec.ioc.domain.repository.YearRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.io.*;

@Repository
public class InMemoryYearRepository implements YearRepository {

    private List<Year> years = new ArrayList<Year>();

    public InMemoryYearRepository() {
        //TODO
    }
    
    @Override
    public List<Year> getAll() {
        return years;
    }
    
}
