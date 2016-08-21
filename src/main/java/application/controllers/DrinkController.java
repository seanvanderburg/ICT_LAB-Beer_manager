package application.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.entities.Bottle;
import application.entities.Drink;
import application.models.DrinkDao;

/**
 * DrinkController, handles ../drink/ related API requests
 * @author Sean
 *
 */
@Controller
public class DrinkController {

	@Autowired
	private DrinkDao drinkDao;
	
	/**
	 * delete a drink
	 * @param id 
	 * @return message
	 */
	@RequestMapping(value = "/drink/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Drink drink = new Drink(id);
			drinkDao.delete(drink);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Drink deleted";
	}

	/**
	 * 
	 * @param model to be used for form
	 * @return drink form template
	 */
	@RequestMapping(value="/drink/save", method=RequestMethod.GET)
    public String drinkForm(Model model) {
        model.addAttribute("drink", new Drink());
        return "drink";
    }
	
	/**
	 * 
	 * @param drink to be saved
	 * @param bindingResult validation result
	 * @param model attribute tied to model
	 * @return
	 */
	@RequestMapping(value = "/drink/save", method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("drink") Drink drink, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "drink";	
		}
		drinkDao.save(drink);
		return "result";

	}
	
	/**
	 * get all drinks
	 * @return returns a list of drinks
	 */
	@RequestMapping(value = "/drink/", method = RequestMethod.GET)
    public ResponseEntity<List<Drink>> listAllDrinks() {
        List<Drink> drinks = drinkDao.getAllDrinks();
        if(drinks.isEmpty()){
            return new ResponseEntity<List<Drink>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Drink>>(drinks, HttpStatus.OK);
    }
	
	/**
	 * get drink by id
	 * @param id 
	 * @return drink that matches id
	 */
	@RequestMapping(value = "/drink/{id}", method = RequestMethod.GET)
    public ResponseEntity<Drink> listDrinkById(@PathVariable("id") long id) {
        Drink drink = drinkDao.getById(id);
        if(drink == null){
            return new ResponseEntity<Drink>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Drink>(drink, HttpStatus.OK);
    }
	
	/**
	 * post a drink
	 * @param drink to be added
	 * @return created status
	 */
	@RequestMapping(value = "/drink/", method = RequestMethod.POST)
	public ResponseEntity<String> addDrink(@RequestBody Drink drink) {
		drinkDao.save(drink);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/**
	 * binder for date format when saving drinks
	 * @param binder
	 */
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 
	
}
