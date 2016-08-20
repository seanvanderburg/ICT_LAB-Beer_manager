package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.entities.Neighbourhood;
import application.models.NeighbourhoodDao;

@Controller
public class NeighbourhoodController {

	@Autowired
	private NeighbourhoodDao neighbourhoodDao;
	
	@RequestMapping(value = "/neigh/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Neighbourhood neighbourhood = new Neighbourhood(id);
			neighbourhoodDao.delete(neighbourhood);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Neighbourhood deleted";
	}

	@RequestMapping(value="/neigh/save", method=RequestMethod.GET)
    public String neighForm(Model model) {
        model.addAttribute("neigh", new Neighbourhood());
        return "neighbourhood";
    }
	
	@RequestMapping(value = "/neigh/save", method = RequestMethod.POST)
	public String addNeigh(@ModelAttribute("neigh") Neighbourhood neigh, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "neigh";	
		}
		neighbourhoodDao.save(neigh);
		return "result";
	}
}
