package pivnystvrtok;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import pivnystvrtok.user.CurrentUser;
import pivnystvrtok.user.Role;
import pivnystvrtok.user.User;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {
	@Override
	public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		User user = new User();
		user.setRole(Role.ROLE_ADMIN);
		user.setUsername(customUser.username());
		user.setPassword("password");
		CurrentUser principal = new CurrentUser( user );
		Authentication auth =
			new UsernamePasswordAuthenticationToken(principal,  principal.getPassword(), principal.getAuthorities());
		context.setAuthentication(auth);
		return context;
	}
}
