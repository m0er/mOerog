package moer.moerog.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@Configuration
@ComponentScan(basePackages="moer.moerog",
		useDefaultFilters=false,
		includeFilters=@ComponentScan.Filter(Controller.class))
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
