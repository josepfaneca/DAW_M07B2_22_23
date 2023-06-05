package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Year;
import cat.xtec.ioc.domain.repository.YearRepository;

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
import org.json.JSONObject;
import org.json.JSONArray;

@RestController
public class YearsController {

    @Autowired
    private YearRepository yearRepository;

    public YearsController() {
    }

    public YearsController(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/years")
    public @ResponseBody
    List<Year> getAll() {
        return this.yearRepository.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/years/{year}")
    public @ResponseBody
    Year getByYear(@PathVariable int year) {
        return this.yearRepository.getByYear(year);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/years")
    public @ResponseBody
        //ResponseEntity<Year> create(@RequestBody Year year) {
    ResponseEntity<Year> create(@RequestBody String stryear) {
        //System.out.println(stryear);
        JSONArray array = new JSONArray(stryear);
        JSONObject object = array.getJSONObject(0);
        Year year = new Year(Integer.parseInt(object.getString("year")), Integer.parseInt(object.getString("total")), Integer.parseInt(object.getString("homes")), Integer.parseInt(object.getString("dones")));

        this.yearRepository.add(year);
        return new ResponseEntity<>(year, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/years")
    public @ResponseBody
    ResponseEntity<Year> update(@RequestBody String stryear) {
        JSONArray array = new JSONArray(stryear);
        JSONObject object = array.getJSONObject(0);
        Year year = new Year(Integer.parseInt(object.getString("year")), Integer.parseInt(object.getString("total")), Integer.parseInt(object.getString("homes")), Integer.parseInt(object.getString("dones")));

        this.yearRepository.update(year);
        return new ResponseEntity<>(year, HttpStatus.OK);
    }

    @RequestMapping(value = "/years/{year}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Year> delete(@PathVariable int year) {
        this.yearRepository.delete(year);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
