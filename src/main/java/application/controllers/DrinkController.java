package application.controllers;

import application.models.Drink;
import application.models.DrinkDao;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/drink")
public class DrinkController {

  @Autowired
  private DrinkDao _drinkDao;
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
    	Drink drink = new Drink(id);
      _drinkDao.delete(drink);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-name")
  @ResponseBody
  public String getByName(String name) {
    String drinkId;
    try {
      Drink drink = _drinkDao.getByName(name);
      drinkId = String.valueOf(drink.getId());
    }
    catch(Exception ex) {
      return "Drink not found";
    }
    return "The Drink id is: " + drinkId;
  }

  @RequestMapping(value="/save")
  @ResponseBody
  public String create(String drinktype, String drinkname, String dateFounded, boolean available, Model model) {
    try {
      Drink drink = new Drink(drinktype, drinkname, dateFounded, available);
      
      _drinkDao.save(drink);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Drink succesfully saved!";
  }
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String showForm(Drink drink) {
      return "form";
  }


} // class UserController
