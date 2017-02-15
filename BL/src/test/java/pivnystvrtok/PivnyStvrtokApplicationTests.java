package pivnystvrtok;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import pivnystvrtok.user.Role;
import pivnystvrtok.user.User;
import pivnystvrtok.user.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PivnyStvrtokApplicationTests {

	@Autowired
	UserServiceImpl userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUser() {
		User user = new User();
		user.setPassword("testPass");
		user.setUsername("testAdmin");
		user.setRole(Role.ADMIN);
		Assert.notNull(userService.create(user));
	}
}
