package application.controllers;

import java.util.List;

import application.entities.Drink;
import application.models.DrinkDao;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public String addDrink(@ModelAttribute("drink") Drink drink) {

		drinkDao.save(drink);

		return "result";

	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showDrinks(Model model) {
		
		model.addAttribute("drink", drinkDao.getAll());
		return "index";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String showTable(Model model) {
//		
//		model.addAttribute("drink", drinkDao.getById(model.id));
//		return "index";
//	}
	
}
