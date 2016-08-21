package application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.entities.Drink;
import application.entities.Neighbourhood;
import application.models.NeighbourhoodDao;

@Controller
public class NeighbourhoodController {

	@Autowired
	private NeighbourhoodDao neighbourhoodDao;
	
	@RequestMapping(value = "/neighbourhood/delete")
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

	@RequestMapping(value="/neighbourhood/save", method=RequestMethod.GET)
    public String neighForm(Model model) {
        model.addAttribute("neighbourhood", new Neighbourhood());
        return "neighbourhood";
    }
	
	@RequestMapping(value = "/neighbourhood/save", method = RequestMethod.POST)
	public String addNeigh(@ModelAttribute("neighbourhood") Neighbourhood neigh, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "neighbourhood";	
		}
		neighbourhoodDao.save(neigh);
		return "result";
	}
	
	
	@RequestMapping(value = "/neighbourhood/", method = RequestMethod.GET)
    public ResponseEntity<List<Neighbourhood>> listAllNeighbourhoods() {
        List<Neighbourhood> neighbourhoods = neighbourhoodDao.getAllNeighbourhoods();
        if(neighbourhoods.isEmpty()){
            return new ResponseEntity<List<Neighbourhood>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Neighbourhood>>(neighbourhoods, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/neighbourhood/{id}", method = RequestMethod.GET)
    public ResponseEntity<Neighbourhood> listDrinkById(@PathVariable("id") long id) {
        Neighbourhood neighbourhood = neighbourhoodDao.getById(id);
        if(neighbourhood == null){
            return new ResponseEntity<Neighbourhood>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Neighbourhood>(neighbourhood, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/neighbourhood/", method = RequestMethod.POST)
	public ResponseEntity<String> addNeighbourhood(@RequestBody Neighbourhood neighbourhood) {
		neighbourhoodDao.save(neighbourhood);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
}
