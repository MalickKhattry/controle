package org.sid.inventoryservice;

import org.sid.inventoryservice.Repository.ProductRepository;
import org.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
@Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository ,RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.save(new Product(null,"computer",4000,133));
            productRepository.save(new Product(null,"printer",1500,122));
            productRepository.save(new Product(null,"smartphone",3000,240));
            productRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
}
}
