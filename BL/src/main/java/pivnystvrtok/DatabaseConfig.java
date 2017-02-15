package pivnystvrtok;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import pivnystvrtok.pivnystvrtok.PivnyStvrtokRepository;
import pivnystvrtok.restaurant.RestaurantRepository;
import pivnystvrtok.user.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses={UserRepository.class,RestaurantRepository.class,PivnyStvrtokRepository.class})
public class DatabaseConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "pivnystvrtok";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost" , 27017);
	}

}
