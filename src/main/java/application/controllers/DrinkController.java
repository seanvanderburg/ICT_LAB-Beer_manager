package application.controllers;

import java.util.List;

import application.entities.Drink;
import application.models.DrinkDao;
import application.models.DrinkRep;

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
	private DrinkDao _drinkDao;

	@Autowired 
	private DrinkRep drinkrep;
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		drinkrep.save(arg0)
		try {
			Drink drink = new Drink(id);
			_drinkDao.delete(drink);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping(value = "/get-by-name")
	@ResponseBody
	public String getByName(String name) {
		String drinkId;
		try {
			Drink drink = _drinkDao.getByName(name);
			drinkId = String.valueOf(drink.getId());
		} catch (Exception ex) {
			return "Drink not found";
		}
		return "The Drink id is: " + drinkId;
	}

	@RequestMapping(value="/drink/save", method=RequestMethod.GET)
    public String drinkForm(Model model) {
        model.addAttribute("drink", new Drink());
        return "drink";
    }
	
	@RequestMapping(value = "/drink/save", method = RequestMethod.POST)
	public String addDrink(@ModelAttribute("drink") Drink drink) {

		_drinkDao.save(drink);

		return "result";

	}
	
//	@RequestMapping(value = "/drink/save", method = RequestMethod.GET)
//    public String getAllDrinks(Model model)
//    {
//        List<Drink> drink = _drinkDao.getAll();
//        model.addAttribute("drink", drink);
//        return "drink";
//    }
}
