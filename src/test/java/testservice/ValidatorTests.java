package testservice;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import application.Application;
import application.entities.Drink;
import application.entities.Neighbourhood;

/**
 * Test Constraint validations on Drink Entity: no violations of constraints are allowed 
 * @author Sean
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ValidatorTests{

	private static Validator validator;
	private Date date;
	private Calendar cal = Calendar.getInstance();

	/**
	 * Build validator
	 */
	@BeforeClass
	public static void before() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Set up the date object, use a date in the past to test validation fail
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 24);
		cal.set(Calendar.YEAR, 2017);
		date = cal.getTime();
	}
	
	/**
	 * Test the drink attributes, drinktype and drinkname may not be null, replace attributes with null to test the validation failure
	 */
	@Test
	public void validateDrinkAttributes() {
		Drink drink = new Drink("Drinktype", "Drinkname", date, false);
		Set<ConstraintViolation<Drink>> constraintViolations = validator.validate( drink );
			assertEquals( 0, constraintViolations.size() );
	}
	
	/**
	 * Test the neighbourhood attributes, name and city may not be null, replace attributes with null to test the validation failure
	 */
	@Test
	public void validateNeighbourhoodAttributes() {
		Neighbourhood neighbourhood = new Neighbourhood("Naam", "Stad", "Omschrijving");
		Set<ConstraintViolation<Neighbourhood>> constraintViolations = validator.validate( neighbourhood );
			assertEquals( 0, constraintViolations.size() );
	}
}
