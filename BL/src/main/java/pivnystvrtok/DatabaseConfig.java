package pivnystvrtok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.core.WriteResultChecking;

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
	
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mt = new MongoTemplate(mongo(), getDatabaseName());
		mt.setWriteResultChecking(WriteResultChecking.EXCEPTION);
		//mt.setWriteConcern(); default is MongoDB driver’s DB or Collection setting
		return mt;
	}
}
