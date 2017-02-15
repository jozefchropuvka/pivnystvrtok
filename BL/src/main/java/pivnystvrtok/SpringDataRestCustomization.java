package pivnystvrtok;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter{
	
	@Override
	  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		config.getCorsRegistry().addMapping("/svc/**")
	      .allowedOrigins("http://localhost:4200")
	      .allowedMethods("*")
	      .allowedHeaders("*")
	      .exposedHeaders("header1", "header2")
	      .allowCredentials(false).maxAge(3600);
	  }
}
