package net.javaguides.springannotations;

import net.javaguides.springannotations.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		var configurableApplicationContext = SpringApplication.run(SpringAnnotationsApplication.class, args);
		PizzaController pizzaController = (PizzaController) configurableApplicationContext.getBean("Pizza");
		System.out.println(pizzaController.GetPizza());
	}

}
