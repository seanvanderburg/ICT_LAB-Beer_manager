package application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import application.entities.Bottle;
import application.entities.Drink;
import application.models.BottleDao;

@Controller
public class BottleController {

	@Autowired
	private BottleDao bottleDao;


	@RequestMapping(value = "/bottle/", method = RequestMethod.GET)
    public ResponseEntity<List<Bottle>> listAllBottles() {
        List<Bottle> bottles = bottleDao.getAllBottles();
        if(bottles.isEmpty()){
            return new ResponseEntity<List<Bottle>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bottle>>(bottles, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/bottle/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bottle> listBottleById(@PathVariable("id") long id) {
        Bottle bottle = bottleDao.getById(id);
        if(bottle == null){
            return new ResponseEntity<Bottle>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Bottle>(bottle, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/bottle/", method = RequestMethod.POST)
	public ResponseEntity<String> addBottle(@RequestBody Bottle bottle) {
		bottleDao.save(bottle);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}