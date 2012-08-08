package moer.moerog.config;

import javax.servlet.*;

import org.springframework.web.*;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;
import org.springframework.web.filter.*;
import org.springframework.web.servlet.*;

public class MoerogWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		servletContext.addFilter("encodingFilter", encodingFilter).addMappingForUrlPatterns(null, false, "/*");
		
		AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
		dispatcherServletContext.register(WebConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring", new DispatcherServlet(dispatcherServletContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
	
}
