package com.niveksys.poc.springdi;

import com.niveksys.poc.springdi.bean.FakeDataSource;
import com.niveksys.poc.springdi.bean.FakeJmsBroker;
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

		System.out.println();
		System.out.println("------ Test DI by Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------ Test DI by Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------ Test DI by Controller");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println();
		System.out.println("------ Test Primary Bean");
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());

		System.out.println();
		System.out.println("------ Test Profile Annotation");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println("------ Test Multiple Profile Annotation ------");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println();
		System.out.println("------ Test Property Source");
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());

		System.out.println("------ Test Multiple Property Source");
		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeJmsBroker.getUsername());
		System.out.println(fakeJmsBroker.getPassword());

		System.out.println();
	}

}
