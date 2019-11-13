package com.fr.adaming;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjetSpringBootApplication {
	private final static Logger logger = LogManager.getLogger(ProjetSpringBootApplication.class);
	



	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProjetSpringBootApplication.class, args);
	

	

	logger.warn("coucou");
	logger.debug("coucou");
	}
	}