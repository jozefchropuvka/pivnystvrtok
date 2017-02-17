package pivnystvrtok;

import java.math.BigDecimal;
import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import pivnystvrtok.pivnystvrtok.PivnyStvrtok;
import pivnystvrtok.pivnystvrtok.PivnyStvrtokRepository;
import pivnystvrtok.pivnystvrtok.Post;
import pivnystvrtok.pivnystvrtok.Vote;
import pivnystvrtok.restaurant.Address;
import pivnystvrtok.restaurant.Restaurant;
import pivnystvrtok.restaurant.RestaurantRepository;
import pivnystvrtok.user.CurrentUserDetailsService;
import pivnystvrtok.user.Role;
import pivnystvrtok.user.User;
import pivnystvrtok.user.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PivnyStvrtokApplicationTests {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	PivnyStvrtokRepository psRepository;
	
	@Autowired
	CurrentUserDetailsService currentUserService;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
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
	public void createPS() {
		currentUserService.loadUserByUsername("testAdmin");
		PivnyStvrtok ps = new PivnyStvrtok();
		Post post = new Post();
		post.setEntry("DFLSDFDSLFSDLFJ a lksjfala sjflaskjdfA <fldkj aldfkj dslfjsdlf jsdlvfj asfljasdas dfas dfas fas dfas df");
		post.setUser(currentUserService.getCurrentUser().getId());
		Vote vote = new Vote();
		vote.setDate(new DateTime());
		vote.setRestaurant(restaurantRepository.findByName("Zámocký pivovar").getId());
		vote.setUser(currentUserService.getCurrentUser().getId());
		ps.setDate(new DateTime());
		ps.setPosts(Arrays.asList(post,post,post));
		ps.setVotes(Arrays.asList(vote,vote,vote));
		psRepository.save(ps);
	}
	
	@Test
	public void createRestaurant() {
		Restaurant restaurant = new Restaurant();
		Address address = new Address();
		address.setStreet("Zámocká 13, Bratislava");
		address.setZipcode(81101);
		BigDecimal[] bd = {new BigDecimal(48.144757), new BigDecimal(17.102248)};
		address.setCoord(bd);
		restaurant.setName("Zámocký pivovar");
		restaurant.setAddress(address);
		restaurantRepository.save(restaurant);
	}
}
