package br.com.gmartins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gmartins.config.Sincronizador;

@SpringBootApplication
public class ServiceEmailApplication {

	public static void main(String[] args) {
		  
		SpringApplication.run(ServiceEmailApplication.class, args);

		Sincronizador run = new Sincronizador();
		run.tempo();
		
	}
	
}
