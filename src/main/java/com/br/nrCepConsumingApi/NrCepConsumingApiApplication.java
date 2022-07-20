package com.br.nrCepConsumingApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class NrCepConsumingApiApplication {
	private static final Logger log = LoggerFactory.getLogger(NrCepConsumingApiApplication.class);
	private String texto ="";
	public static void main(String[] args) {
		SpringApplication.run(NrCepConsumingApiApplication.class, args);
	}
	@GetMapping("/")
	public String textoInit(){
		return "teste de funcionamento";
	}
	@Bean
	public RestTemplate restTemplate (RestTemplateBuilder builder){
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate){
	return args -> {
		Cep cep = restTemplate.getForObject(
				"https://viacep.com.br/ws/04128080/json/",Cep.class);
		log.info(cep.printCepAllInfo());
	};
	}
	@PostMapping
	public void listener(@RequestParam String cep){
		texto = cep;
		log.info((texto));
	}

}
