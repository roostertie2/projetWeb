package org.projet.projetWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"org.projet.projetWeb.model"})
public class ProjetWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetWebApplication.class, args);
	}

}
