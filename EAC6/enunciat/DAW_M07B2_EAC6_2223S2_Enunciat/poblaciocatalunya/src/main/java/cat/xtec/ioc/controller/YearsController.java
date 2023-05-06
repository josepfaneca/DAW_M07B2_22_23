package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Year;
import cat.xtec.ioc.domain.repository.YearRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
}
