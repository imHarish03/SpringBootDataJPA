package lab.spring.data.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lab.spring.data.rest.service.EmbeddableService;
import lab.spring.data.rest.service.OneToOneUniService;

@SpringBootApplication
public class SpringBootDataJPAApplication implements CommandLineRunner {

	@Autowired
	private OneToOneUniService oneToOneService;

	@Autowired
	private EmbeddableService embeddableService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		embeddableService.createCompany();
		System.out.println("Service Started Successfully");
	}

}
