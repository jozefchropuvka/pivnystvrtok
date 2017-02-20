package pivnystvrtok.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/user"})
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	CurrentUserDetailsService currentService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	@ResponseBody
	public User create(@Valid UserPayload user){		
		return userService.create(user);
	}

	@GetMapping("/current")
	@ResponseBody
	public User getCurrentUser(){
		return currentService.getUser();
	}
}
