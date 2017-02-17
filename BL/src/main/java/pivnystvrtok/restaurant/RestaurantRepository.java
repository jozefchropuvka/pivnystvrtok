package pivnystvrtok.restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
	Restaurant findByName(String name);
}
