package cat.xtec.ioc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cat.xtec.ioc.domain.repository.CartelleraRepository;

@Controller
public class EspectacleController {

	@Autowired
	private CartelleraRepository showRepository;
	
	@RequestMapping(value = "/shows", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
    	ModelAndView modelview = new ModelAndView("shows");    	
        modelview.getModelMap().addAttribute("shows", showRepository.getAllEspectacles());
    	return modelview;
	}
}
