package com.alkemy.challenge.disney;



import com.alkemy.challenge.disney.models.Genero;
import com.alkemy.challenge.disney.models.Pelicula;
import com.alkemy.challenge.disney.models.Personaje;
import com.alkemy.challenge.disney.services.PeliculaService;
import com.alkemy.challenge.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DisneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}

}
