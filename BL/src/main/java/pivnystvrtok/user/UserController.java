package pivnystvrtok.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/user"})
public class UserController {
	
	@Autowired
	CurrentUserDetailsService currentService;
	
	@GetMapping("/current")
	@ResponseBody
	public User getCurrentUser(){
		return currentService.getUser();
	}
}
