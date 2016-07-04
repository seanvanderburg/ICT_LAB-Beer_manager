package testservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import application.entities.Drink;
import testlauncher.AbstractTest;

public class ValidatorTest extends AbstractTest {
	
	private static Validator validator;
	private Date date;
    private Calendar cal = Calendar.getInstance();
    
    
	   @BeforeClass
	   public static void setUp() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }

	   @Test
	   public void drinkTypeIsNull() {
		  cal.set(Calendar.MONTH, 9);
		  cal.set(Calendar.DATE, 24);
		  cal.set(Calendar.YEAR, 2017);
		  date = cal.getTime();  
	      Drink drink = new Drink("Drink", "Beer", date , false);
	      
	      Set<ConstraintViolation<Drink>> constraintViolations = validator.validate(drink);
	      Assert.assertTrue("Drinktype not specified", constraintViolations.size() == 0);

	   }
	      

	
}
