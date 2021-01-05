package com.niveksys.poc.springdi;

import com.niveksys.poc.springdi.controller.ConstructorInjectedController;
import com.niveksys.poc.springdi.controller.I18nController;
import com.niveksys.poc.springdi.controller.MyController;
import com.niveksys.poc.springdi.controller.PetController;
import com.niveksys.poc.springdi.controller.PropertyInjectedController;
import com.niveksys.poc.springdi.controller.SetterInjectedController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.niveksys.poc" })
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println("------ Pet of the Year ------");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("------ Profile");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("------ Primary Bean");
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------ Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------ Controller");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
