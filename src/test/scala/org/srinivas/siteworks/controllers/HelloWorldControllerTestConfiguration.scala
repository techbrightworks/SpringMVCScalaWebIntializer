package org.srinivas.siteworks.controllers

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
	 class HelloWorldControllerTestConfiguration {

		@Bean
		def helloWorldController():HelloWorldController = {
			new HelloWorldController;
		}
		
	}