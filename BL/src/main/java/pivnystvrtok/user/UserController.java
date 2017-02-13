package pivnystvrtok.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value="/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
//	@PreAuthorize("hasAuthority('ADMIN')")
	/*@PostMapping
	public String create(@Valid User user){
		userService.create(user);
		return "user_create";
	}*/
	
}
