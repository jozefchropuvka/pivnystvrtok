package pivnystvrtok.restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ADMIN')")
public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
	
	@PreAuthorize("hasRole('USER')")
	Restaurant findByName(String name);
}
