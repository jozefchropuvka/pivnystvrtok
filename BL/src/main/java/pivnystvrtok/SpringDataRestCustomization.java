package pivnystvrtok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter{
	//Workaround for https://jira.spring.io/browse/DATAREST-524
	private static final List<String> EVENTS;
	 
    static {
        List<String> events = new ArrayList<String>();
        events.add("beforeCreate");
        events.add("afterCreate");
        events.add("beforeSave");
        events.add("afterSave");
        events.add("beforeLinkSave");
        events.add("afterLinkSave");
        events.add("beforeDelete");
        events.add("afterDelete");
        EVENTS = Collections.unmodifiableList(events);
    }
 
    @Autowired
    ListableBeanFactory beanFactory;
 
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        super.configureValidatingRepositoryEventListener(validatingListener);
        Map<String, Validator> validators = beanFactory.getBeansOfType(Validator.class);
        for (Map.Entry<String, Validator> entry : validators.entrySet()) {
            EVENTS.stream().filter(p -> entry.getKey().startsWith(p)).findFirst()
                    .ifPresent(p -> validatingListener.addValidator(p, entry.getValue()));
        }
    }
    
	/*  @Override
	  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.getCorsRegistry().addMapping("/**")
	      .allowedOrigins("http://localhost:4200")
	      .allowedMethods("*")
	      .allowedHeaders("*")
	      .allowCredentials(true);
	  }*/
}
