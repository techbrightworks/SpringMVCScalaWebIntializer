package org.srinivas.siteworks.controllers

import org.junit.Assert.fail;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers._;


/**
 * The Class HelloWorldControllerTest.
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(classes = Array(classOf[HelloWorldControllerTestConfiguration]))
class HelloWorldControllerTest {

  val logger = LoggerFactory.getLogger(classOf[HelloWorldControllerTest])
	

@Autowired val helloWorldController:HelloWorldController = null

	/**
	 * Test helloPage method of HelloWorldController
	 */
	@Test
	def  testHelloPage():Unit = {

   val  mockMvc:MockMvc = MockMvcBuilders.standaloneSetup(this.helloWorldController).build()
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/helloworld.mvc"))
					.andExpect(status().isOk())
					.andExpect(view().name("helloworld"))
					.andExpect(forwardedUrl("helloworld"))
					.andExpect(handler().methodName("helloPage"))
					.andExpect(
							model().attribute(
									"message",
								helloWorldController.STRING_MESSAGE_WELCOME_TO_WEB_APPLICATION_INITIALISER));
		} catch {
		   case e: Exception => {
		     logger.info("Error",e);
		     fail("Failed Due to: "+e.getMessage());		}
		}

	}

}
