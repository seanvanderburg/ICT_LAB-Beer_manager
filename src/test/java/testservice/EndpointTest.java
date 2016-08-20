package testservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import application.Application;
import application.models.DrinkDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EndpointTest {
	
	private MockMvc mockMvc;

	@Autowired
    private DrinkDao drinkDaoMock;
	
	//TODO add Unit test to find drinks per ID
	@Test
    public void findDrinks() throws Exception {
     
//        mockMvc.perform(get("/drink/"))
//                .andExpect(status().isOk());
    }
}
