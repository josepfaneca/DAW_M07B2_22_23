package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Year;
import cat.xtec.ioc.domain.repository.YearRepository;
import cat.xtec.ioc.utils.Utilitats;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class YearsController {

    @Autowired
    private YearRepository yearRepository;

    public YearsController() {
    }

    public YearsController(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    @RequestMapping(value = "/years", method = RequestMethod.GET)
    public @ResponseBody
    List<Year> getAllYears() {
        return this.yearRepository.getAll();
    }

    @RequestMapping(value = "/years/{year}", method = RequestMethod.GET)
    public @ResponseBody
    Year getYearByYear(@PathVariable int year) {
        return this.yearRepository.getOneYear(year);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Year> create(@RequestBody String stryear) {
        Year newYear = Utilitats.getYearFromString(stryear);
        this.yearRepository.add(newYear);
        return new ResponseEntity<>(newYear, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Year> update(@RequestBody String stryear) {
        int ano = Utilitats.getYearFromJson(stryear);
        Year existeix = this.yearRepository.getOneYear(ano);
        if (existeix != null) {
            Year newYear = Utilitats.getYearFromString(stryear);
            this.yearRepository.update(newYear);
            return new ResponseEntity<>(newYear, HttpStatus.OK);
        }
        return new ResponseEntity<>(existeix, HttpStatus.NOT_MODIFIED);

    }

    @RequestMapping(value = "/years/{ano}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<String> delete(@PathVariable int ano) {
        Year existeix = this.yearRepository.getOneYear(ano);
        if (existeix != null) {
            this.yearRepository.delete(ano);
            return new ResponseEntity<>("S'ha eliminat l\'any: " + ano, HttpStatus.OK);
        }
        return new ResponseEntity<>("No s\'ha trobat l\'any " + ano
                + " i no s\'ha pogut eliminar", HttpStatus.NOT_FOUND);
    }

}
