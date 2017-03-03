package pivnystvrtok.restaurant;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Restaurant findByName(String name);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@Override
	default Restaurant findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@PreAuthorize("hasRole('ROLE_USER')")
	@Override
	default List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
