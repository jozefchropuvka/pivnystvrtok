package pivnystvrtok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import pivnystvrtok.user.UserRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses=UserRepository.class)
public class PivnyStvrtokApplication {

	public static void main(String[] args) {
		SpringApplication.run(PivnyStvrtokApplication.class, args);
	}
}
