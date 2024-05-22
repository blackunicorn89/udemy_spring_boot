package net.javaguides.springannotations;

import net.javaguides.springannotations.configurationproperties.AppPropertiesDemo;
import net.javaguides.springannotations.controller.MyController;
import net.javaguides.springannotations.controller.PizzaController;
import net.javaguides.springannotations.propertiesource.PropertySourceDemo;
import net.javaguides.springannotations.repository.MyRepository;
import net.javaguides.springannotations.service.MyService;
import net.javaguides.springannotations.service.VegePizza;
import net.javaguides.springannotations.value.ValueAnnotationDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		var configurableApplicationContext = SpringApplication.run(SpringAnnotationsApplication.class, args);
//		PizzaController pizzaController = (PizzaController) configurableApplicationContext.getBean("pizzaController");
//		System.out.println(pizzaController.GetPizza());
//
//		MyController myController = configurableApplicationContext.getBean(MyController.class);
//		System.out.println(myController.hello());
//
//		MyService myService = configurableApplicationContext.getBean(MyService.class);
//		System.out.println(myService.hello());
//
//		MyRepository myRepository = configurableApplicationContext.getBean(MyRepository.class);
//		System.out.println(myRepository.hello());

//		ValueAnnotationDemo valueAnnotationDemo = configurableApplicationContext.getBean(ValueAnnotationDemo.class);
//		System.out.println(valueAnnotationDemo.getDefaultName());
//		System.out.println(valueAnnotationDemo.getHost());
//		System.out.println(valueAnnotationDemo.getEmail());
//		System.out.println(valueAnnotationDemo.getPassword());
//		System.out.println(valueAnnotationDemo.getOS());
//		System.out.println(valueAnnotationDemo.getNvmHome());

//		PropertySourceDemo propertySourceDemo = configurableApplicationContext.getBean(PropertySourceDemo.class);
//		System.out.println(propertySourceDemo.getHost());
//		System.out.println(propertySourceDemo.getEmail());
//		System.out.println(propertySourceDemo.getPassword());
//		System.out.println(propertySourceDemo.getAppName());
//		System.out.println(propertySourceDemo.getAppDescription());

		AppPropertiesDemo appPropertiesDemo = configurableApplicationContext.getBean(AppPropertiesDemo.class);

		appPropertiesDemo.Dispaly();



//		VegePizza pizza = (VegePizza) configurableApplicationContext.getBean("vegePizza");
//		System.out.println(pizza.getPizza());
	}

}
