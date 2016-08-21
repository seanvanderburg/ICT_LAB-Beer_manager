package testservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import application.Application;

/**
 * REST API call statusses are tested with mockMvc
 * 
 * @author Sean
 *
 */
/**
 * @author Sean
 *
 */
/**
 * @author Sean
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MVCTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	/**
	 * setup mockmvc
	 * 
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	/**
	 * test get drink by id
	 * 
	 * @throws Exception
	 */
	@Test
	public void getDrinkById() throws Exception {

		mockMvc.perform(get("/drink/{id}", 1L)).andExpect(
				status().is2xxSuccessful());
	}

	/**
	 * test get all drinks
	 * 
	 * @throws Exception
	 */
	@Test
	public void getDrinks() throws Exception {

		mockMvc.perform(get("/drink/")).andExpect(status().is2xxSuccessful());
	}

	/**
	 * test add drink
	 * 
	 * @throws Exception
	 */
	@Test
	public void addDrink() throws Exception {

		mockMvc.perform(
				post("/drink/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"availability\": \"true\", \"drinkType\": \"beer\", \"drinkName\": \"bier\", \"dateFounded\": \"2016-08-19\"}"))
				.andExpect(status().is2xxSuccessful());
	}

	/**
	 * test get neighbourhood by id
	 * 
	 * @throws Exception
	 */
	@Test
	public void getNeighbourhoodById() throws Exception {

		mockMvc.perform(get("/neighbourhood/{id}", 1L)).andExpect(
				status().is2xxSuccessful());
	}

	/**
	 * test get neighbourhoods
	 * 
	 * @throws Exception
	 */
	@Test
	public void getNeighbourhoods() throws Exception {

		mockMvc.perform(get("/neighbourhood/")).andExpect(
				status().is2xxSuccessful());
	}

	/**
	 * test add neighbourhood
	 * 
	 * @throws Exception
	 */
	@Test
	public void addNeighbourhood() throws Exception {

		mockMvc.perform(
				post("/neighbourhood/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"name\": \"centrum\", \"city\": \"stad\", \"description\": \"test\"}"))
				.andExpect(status().is2xxSuccessful());
	}

	/**
	 * test get bottle by id
	 * 
	 * @throws Exception
	 */
	@Test
	public void getBottleById() throws Exception {

		mockMvc.perform(get("/bottle/{id}", 1L)).andExpect(
				status().is2xxSuccessful());
	}

	/**
	 * test get all bottles
	 * 
	 * @throws Exception
	 */
	@Test
	public void getBottles() throws Exception {

		mockMvc.perform(get("/bottle/")).andExpect(status().is2xxSuccessful());
	}

	/**
	 * test add bottle
	 * 
	 * @throws Exception
	 */
	@Test
	public void addBottle() throws Exception {

		mockMvc.perform(
				post("/bottle/").contentType(MediaType.APPLICATION_JSON)
						.content("{\"dateScanned\": \"2016-08-19\"}"))
				.andExpect(status().is2xxSuccessful());
	}
}
