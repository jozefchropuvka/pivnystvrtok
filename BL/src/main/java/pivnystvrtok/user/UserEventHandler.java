package pivnystvrtok.user;

import javax.xml.bind.ValidationException;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

	 	@HandleBeforeCreate
	 	@HandleBeforeSave
	    public void userCreate(User u) throws ValidationException{
	 		Assert.notNull(u.getPassword());
	 		Assert.notNull(u.getUsername());
	 		Assert.notNull(u.getRole());
	        u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));	
	    }
}
