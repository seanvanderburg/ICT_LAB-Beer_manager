package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
  }
}
