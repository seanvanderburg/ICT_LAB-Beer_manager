package application.transactions;

import java.io.Serializable;

import application.entities.Drink;

public class PerformanceTest {
	public void runtest(){
		for (int i=0; i>10; i++) {
			  
				Drink d = new Drink();
			   d.setDrinkName("TestDrank"+i);
			}

	}
	
}
