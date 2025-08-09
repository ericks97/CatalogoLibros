package com.proyecto.literalura.CatalogoLibros;

import com.proyecto.literalura.CatalogoLibros.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoDeLibrosApplication implements CommandLineRunner {

	private final Principal principal;
	public CatalogoDeLibrosApplication(Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(CatalogoDeLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		principal.showMenu();
	}
}
