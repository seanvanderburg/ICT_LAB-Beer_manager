package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import application.transactions.PerformanceTest;
/**
 * Run the spring (boot) application
 * @author Sean
 *
 */
@SpringBootApplication
public class Application {
	/**
	 * main method
	 * @param args
	 */
  public static void main(String[] args) {
	  SpringApplication.run(Application.class, args);
	  //PerformanceTest.runtest();
  }
}
