package pivnystvrtok.user;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByUsername(String email);

    Collection<User> getAllUsers();

    User create(User form);

}
