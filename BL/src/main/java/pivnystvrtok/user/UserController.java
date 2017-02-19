package pivnystvrtok.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value="/svc/user")
	@ResponseBody
	public User create(@Valid UserPayload user){		
		return userService.create(user);
	}

	
}
