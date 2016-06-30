package testservice;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import testlauncher.AbstractTest;
import application.entities.Drink;
import application.models.DrinkDao;

@Transactional
public class ControllerTest extends AbstractTest {
	@Autowired
	private DrinkDao drinkDao;
	
	@Test
	public void findAll(){
		List<Drink> drinks = drinkDao.getAll();
		
		Assert.assertNotNull("Test failed, no drinks present", drinks);
	}
}
