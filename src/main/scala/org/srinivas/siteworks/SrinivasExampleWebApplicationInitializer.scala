package org.srinivas.siteworks

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import scala.annotation.varargs;


class SrinivasExampleWebApplicationInitializer extends WebApplicationInitializer {

val logger = LoggerFactory.getLogger(classOf[SrinivasExampleWebApplicationInitializer])


	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	
override def onStartup(container:ServletContext):Unit = {
		logger.info("Started to pickup the annotated classes")
		startServlet(container);
	}

	/**
	 * Start servlet.
	 * 
	 * @param container   the ServletContext
	 */
	private def startServlet(container:ServletContext):Unit = {
		val dispatcherContext:WebApplicationContext = registerContext(classOf[MvcContextConfiguration])
		val  dispatcherServlet:DispatcherServlet = new DispatcherServlet(dispatcherContext)		
		val dispatcher:ServletRegistration.Dynamic = container.addServlet("dispatcher",dispatcherServlet)		
		dispatcher.setLoadOnStartup(1)
		 val mapping: String = "/"
		dispatcher.addMapping(mapping);
	}

	/**
	 * Register context.
	 * 
	 * @param annotatedClasses the Class type variable argument of classes that needs to be registered to the context.
	 * @return the web application context
	 */
	def registerContext(@varargs annotatedClasses:Class[_]):WebApplicationContext = {
		logger.info("Using AnnotationConfigWebApplicationContext createContext");
		val context:AnnotationConfigWebApplicationContext  = new AnnotationConfigWebApplicationContext()
		context.register(annotatedClasses)		
		return context;
	}
	
	
	
}
