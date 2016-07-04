package application.controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.entities.Drink;
import application.models.DrinkDao;

@Controller
public class DrinkController {

	@Autowired
	private DrinkDao drinkDao;
	
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

	@RequestMapping(value="/drink/save", method=RequestMethod.GET)
    public String drinkForm(Model model) {
        model.addAttribute("drink", new Drink());
        return "drink";
    }
	
	@RequestMapping(value = "/drink/save", method = RequestMethod.POST)
	public String addDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "drink";	
		}
		drinkDao.save(drink);
		return "result";

	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 
	
}
