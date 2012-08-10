package moer.moerog.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.stereotype.*;

import com.mongodb.*;

@Configuration
@ImportResource({"classpath:applicationContext.xml", "classpath:applicationContext-security.xml"})
@ComponentScan(basePackages="moer.moerog", excludeFilters={@ComponentScan.Filter(Configuration.class), @ComponentScan.Filter(Controller.class)})
public class AppConfig {
	@Autowired Mongo mongo;
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongo, "mOerog");
		return mongoTemplate;
	}
}
