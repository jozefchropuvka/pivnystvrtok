package pivnystvrtok.restaurant;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
	
	@PreAuthorize("hasRole('ROLE_USER')")
	Restaurant findByName(String name);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@Override
	Restaurant findOne(String id);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@Override
	List<Restaurant> findAll();
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@Override
	Page<Restaurant> findAll(Pageable pageable);
}
