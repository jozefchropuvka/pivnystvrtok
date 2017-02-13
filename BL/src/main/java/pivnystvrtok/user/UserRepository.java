package pivnystvrtok.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
	User findOneById(Long id);
	Optional<User> findByUsername(String username);
	public User findByRole();
}
