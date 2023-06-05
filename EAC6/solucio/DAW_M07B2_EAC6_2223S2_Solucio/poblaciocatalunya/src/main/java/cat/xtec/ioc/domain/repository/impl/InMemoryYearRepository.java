package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Year;
import cat.xtec.ioc.domain.repository.YearRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Repository
public class InMemoryYearRepository implements YearRepository {

    private final List<Year> years = new ArrayList<>();

    public InMemoryYearRepository() {
        String delimiter = ";";
        try {
            String csvFile = "/dades/dades.csv";
            InputStream is = InMemoryYearRepository.class.getResourceAsStream(csvFile);
            assert is != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            String[] tempArr;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                tempArr = line.split(delimiter);
                Year year = new Year(Integer.parseInt(tempArr[0]), Integer.parseInt(tempArr[1]), Integer.parseInt(tempArr[2]), Integer.parseInt(tempArr[3]));
                years.add(year);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //test bàsic:
        /*
        System.out.println(getByYear(2005).toString());
        delete(2005);
        Year year = new Year(2023, 7000000, 3400000, 3600000);
        add(year);
        year.setTotal(8000000);
        year.setHomes(3000000);
        year.setDones(5000000);
        update(year);
        */
        
    }

    @Override
    public List<Year> getAll() {
        return years;
    }

    @Override
    public Year getByYear(int year) {
        Year yearfound = null;
        for (Year itemyear : years) {
            if (itemyear != null && itemyear.getYear() == year) {
                yearfound = itemyear;
                break;
            }
        }
        if (yearfound == null) {
            throw new IllegalArgumentException(
                    "No s'ha trobat l'any amb valor: " + year);
        }
        return yearfound;
    }

    @Override
    public void add(Year year) {
        //s'hauria de controlar que l'any no existeixi prèviament
        years.add(year);
    }

    @Override
    public void update(Year year) {
        Year yearfound = getByYear(year.getYear());
        //s'hauria de controlar que hem trobat l'any
        //canviem els valors de la població:
        assert yearfound != null;
        yearfound.setTotal(year.getTotal());
        yearfound.setHomes(year.getHomes());
        yearfound.setDones(year.getDones());
    }

    @Override
    public void delete(int year) {
        Year yearfound = getByYear(year);
        //s'hauria de controlar que hem trobat l'any
        assert yearfound != null;
        years.remove(yearfound);
    }
}
