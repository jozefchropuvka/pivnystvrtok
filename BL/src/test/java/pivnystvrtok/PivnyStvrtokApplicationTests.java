package pivnystvrtok;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import pivnystvrtok.user.Role;
import pivnystvrtok.user.User;
import pivnystvrtok.user.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PivnyStvrtokApplicationTests {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

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

	@Test
	public void testAdminView() throws Exception {
		this.mockMvc.perform(get("/admin")).andExpect(status().isOk());
	}
	
	@Test
	public void testUserView() throws Exception {
		this.mockMvc.perform(get("/user")).andExpect(status().isOk());
	}
}
