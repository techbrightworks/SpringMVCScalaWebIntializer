
package org.srinivas.siteworks.controllers

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



/**
 * The Class HelloWorldController.
 */
@Controller
class HelloWorldController {	

	val STRING_MESSAGE_WELCOME_TO_WEB_APPLICATION_INITIALISER:String = "Welcome to Scala WebApplication Initialiser"
	val logger = LoggerFactory.getLogger(classOf[HelloWorldController])
	

	/**
	 * Hello page.
	 * 
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = Array("/helloworld.mvc"), method =Array(RequestMethod.GET))
	def helloPage(model:Model):String = {
	  logger.info("HelloWorldController")
	  model.addAttribute("message",STRING_MESSAGE_WELCOME_TO_WEB_APPLICATION_INITIALISER)
	  return "helloworld";	
	}
}
