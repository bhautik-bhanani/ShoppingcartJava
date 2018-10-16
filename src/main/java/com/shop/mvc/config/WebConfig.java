package com.shop.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Bhautik Bhanani
 *
 */
public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("contextConfigLocation", "");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		context.setServletContext(servletContext);
		context.refresh();
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

	// @Override
	// protected Class<?>[] getRootConfigClasses() {
	// // TODO Auto-generated method stub
	// return new Class[] { DatabaseConfig.class, SecurityConfig.class };
	// }
	//
	// @Override
	// protected Class<?>[] getServletConfigClasses() {
	// return new Class[] { AppConfig.class };
	// }
	//
	// @Override
	// protected String[] getServletMappings() {
	// // TODO Auto-generated method stub
	// return new String[] { "/" };
	// }

}
