package org.sid.customerservice;

import org.sid.customerservice.Repository.CustomerRepository;
import org.sid.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){

		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null,"Ahmed","ahmed@gmail.com"));
			customerRepository.save(new Customer(null,"Amani","amani@gmail.com"));
			customerRepository.save(new Customer(null,"Mouad","mouad@gmail.com"));

			customerRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
}
}
