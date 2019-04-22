package br.com.gmartins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.gmartins.config.Sincronizador;

@SpringBootApplication
public class ServiceEmailApplication {

	
	
	public static void main(String[] args) {
		  
		//SpringApplication.run(ServiceEmailApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(ServiceEmailApplication.class, args);
		
		Sincronizador run = (Sincronizador) context.getBean("sincronizador");

		run.tempo();
		//Sincronizador run = new Sincronizador();
		//run.tempo();
		
		
	}
	
}
