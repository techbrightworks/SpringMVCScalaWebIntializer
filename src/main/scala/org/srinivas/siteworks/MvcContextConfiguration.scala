package org.srinivas.siteworks

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


/**
 * The Class MvcContextConfiguration.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = Array("org.srinivas.siteworks","org.srinivas.siteworks.controllers"))
class MvcContextConfiguration extends WebMvcConfigurerAdapter {

  val logger = LoggerFactory.getLogger(classOf[MvcContextConfiguration])


	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
	 */
override	def configureDefaultServletHandling(configurer:DefaultServletHandlerConfigurer ):Unit={
		logger.info("WebMvcContextConfiguration: configureDefaultServletHandling Method")
		configurer.enable();
	}

}