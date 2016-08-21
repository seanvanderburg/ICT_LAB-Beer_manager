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

import application.entities.Neighbourhood;
import application.models.NeighbourhoodDao;

/**
 * NeighbourhoodController, handles ../neighbourhood/ related API requests
 * @author Sean
 *
 */
@Controller
public class NeighbourhoodController {

	@Autowired
	private NeighbourhoodDao neighbourhoodDao;
	
	/**
	 * delete a neighbourhood
	 * @param id
	 * @return message
	 */
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

	/**
	 * initialise thymeleaf creation form
	 * @param model to be used for form
	 * @return mapping
	 */
	@RequestMapping(value="/neighbourhood/save", method=RequestMethod.GET)
    public String neighForm(Model model) {
        model.addAttribute("neighbourhood", new Neighbourhood());
        return "neighbourhood";
    }
	
	/**
	 * post a neighbourhood
	 * @param neighbourhood to be saved
	 * @param bindingResult (validation)
	 * @param model to be used
	 * @return result template
	 */
	@RequestMapping(value = "/neighbourhood/save", method = RequestMethod.POST)
	public String addNeigh(@ModelAttribute("neighbourhood") Neighbourhood neighbourhood, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "neighbourhood";	
		}
		neighbourhoodDao.save(neighbourhood);
		return "result";
	}
	
	/**
	 * get a list of neighbourhoods
	 * @return neighbourhood list of objects
	 */
	@RequestMapping(value = "/neighbourhood/", method = RequestMethod.GET)
    public ResponseEntity<List<Neighbourhood>> listAllNeighbourhoods() {
        List<Neighbourhood> neighbourhoods = neighbourhoodDao.getAllNeighbourhoods();
        if(neighbourhoods.isEmpty()){
            return new ResponseEntity<List<Neighbourhood>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Neighbourhood>>(neighbourhoods, HttpStatus.OK);
    }
	
	/**
	 * get neighbourhood by ID
	 * @param id
	 * @return object and OK status
	 */
	@RequestMapping(value = "/neighbourhood/{id}", method = RequestMethod.GET)
    public ResponseEntity<Neighbourhood> listDrinkById(@PathVariable("id") long id) {
        Neighbourhood neighbourhood = neighbourhoodDao.getById(id);
        if(neighbourhood == null){
            return new ResponseEntity<Neighbourhood>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Neighbourhood>(neighbourhood, HttpStatus.OK);
    }
	
	/**
	 * post a new neighbourhood
	 * @param neighbourhood to be added
	 * @return OK status
	 */
	@RequestMapping(value = "/neighbourhood/", method = RequestMethod.POST)
	public ResponseEntity<String> addNeighbourhood(@RequestBody Neighbourhood neighbourhood) {
		neighbourhoodDao.save(neighbourhood);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
}
