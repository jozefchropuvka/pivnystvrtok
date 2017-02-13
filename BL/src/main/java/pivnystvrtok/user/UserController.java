package pivnystvrtok.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	@ResponseBody	
	public String create(@Valid User user){
		userService.create(user);
		return "user?created";
	}
	
}
