package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.models.DrinkDao;
import application.models.NeighbourhoodDao;


@Controller
public class MainController {
	@Autowired
	private DrinkDao drinkDao;
	private NeighbourhoodDao neighDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String getMainData(Model model) {
        model.addAttribute("drinks", drinkDao.getAllDrinks());
        //model.addAttribute("neighs", neighDao.getAllNeighs());
        return "index";
    }
}
