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

import testlauncher.AbstractTest;
import application.entities.Drink;

public class ValidatorTest extends AbstractTest {

	private static Validator validator;
	private Date date;
	private Calendar cal = Calendar.getInstance();

	@BeforeClass
	public static void before() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}


	@Before
	public void setUp() throws Exception {
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 24);
		cal.set(Calendar.YEAR, 2017);
		date = cal.getTime();
	}

	@Test
	public void validateAttributes() {
		Drink drink = new Drink("Drinktype", "Drinkname", date, false);
		Set<ConstraintViolation<Drink>> constraintViolations = validator.validate( drink );
			assertEquals( 0, constraintViolations.size() );
	}
}
