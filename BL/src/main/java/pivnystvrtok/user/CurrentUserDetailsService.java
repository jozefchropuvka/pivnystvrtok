package pivnystvrtok.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	private CurrentUser currentUser;
	private User user;
	
	public CurrentUser getCurrentUser() {
		return currentUser;
	}
	
	public User getUser(){
		return user;
	}

	@Autowired
	public CurrentUserDetailsService(UserRepository repository) {
		this.userRepository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username=%s was not found", username)));
        return currentUser = new CurrentUser(user);
	}

}
