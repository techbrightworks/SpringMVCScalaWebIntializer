package org.srinivas.siteworks

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * The Class ViewConfiguration.
 */
@Configuration
class ViewConfiguration {

  val logger = LoggerFactory.getLogger(classOf[ViewConfiguration])
	
	/**
	 * View resolver.
	 * 
	 * @return the Resolved view
	 */
	@Bean
	def viewResolver():ViewResolver = {
		logger.info("ViewConfiguration viewResolver()")
		val viewResolver:InternalResourceViewResolver = new InternalResourceViewResolver()
		viewResolver.setOrder(1)
		viewResolver.setPrefix("/WEB-INF/displays/")
		viewResolver.setSuffix(".jsp")
		return viewResolver
	}

}